package com.mergingtonhigh.schoolmanagement.infrastructure.migrations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;

/**
 * Unit tests for V001_InitialDatabaseSetup migration.
 */
@ExtendWith(MockitoExtension.class)
class V001_InitialDatabaseSetupTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Environment environment;

    private V001_InitialDatabaseSetup migration;

    @BeforeEach
    void setUp() {
        migration = new V001_InitialDatabaseSetup(mongoTemplate, passwordEncoder, environment);
    }

    @Test
    void shouldCreateMangaManiacsClubWithCorrectDetails() {
        // Arrange - mock empty collections to trigger seeding
        when(mongoTemplate.count(any(Query.class), eq(Activity.class))).thenReturn(0L);
        when(mongoTemplate.count(any(Query.class), eq(Teacher.class))).thenReturn(0L);
        when(environment.getProperty("TEACHER_RODRIGUEZ_PASSWORD", "art123")).thenReturn("art123");
        when(environment.getProperty("TEACHER_CHEN_PASSWORD", "chess123")).thenReturn("chess123");
        when(environment.getProperty("PRINCIPAL_PASSWORD", "admin123")).thenReturn("admin123");
        when(passwordEncoder.encode(any(String.class))).thenReturn("encoded_password");

        // Act
        migration.migrate();

        // Assert - capture all Activity saves
        ArgumentCaptor<Activity> activityCaptor = ArgumentCaptor.forClass(Activity.class);
        verify(mongoTemplate, times(14)).save(activityCaptor.capture()); // 14 activities total

        // Find the Manga Maniacs club among the saved activities
        List<Activity> savedActivities = activityCaptor.getAllValues();
        Activity mangaManiacs = savedActivities.stream()
                .filter(activity -> "Manga Maniacs".equals(activity.getName()))
                .findFirst()
                .orElse(null);

        // Verify Manga Maniacs club was created correctly
        assertNotNull(mangaManiacs, "Manga Maniacs club should be created");
        assertEquals("Manga Maniacs", mangaManiacs.getName());
        assertTrue(mangaManiacs.getDescription().contains("ninjas"), 
                "Description should mention ninjas");
        assertTrue(mangaManiacs.getDescription().contains("piratas"), 
                "Description should mention pirates");
        assertTrue(mangaManiacs.getDescription().contains("shounen"), 
                "Description should mention shounen genre");
        assertEquals(15, mangaManiacs.getMaxParticipants());
        assertEquals(ActivityType.ARTS, mangaManiacs.getType());
        
        // Verify schedule details
        assertEquals(List.of("Tuesday"), mangaManiacs.getScheduleDetails().days());
        assertEquals(LocalTime.of(19, 0), mangaManiacs.getScheduleDetails().startTime());
        assertEquals(LocalTime.of(20, 30), mangaManiacs.getScheduleDetails().endTime());
        
        // Verify empty participant list for new club
        assertTrue(mangaManiacs.getParticipants().isEmpty(), 
                "New club should have no participants initially");
    }

    @Test
    void shouldIncludeMangaManiacsInRollback() {
        // Act
        migration.rollback();

        // Assert - verify that Manga Maniacs is included in the rollback query
        ArgumentCaptor<Query> queryCaptor = ArgumentCaptor.forClass(Query.class);
        verify(mongoTemplate, times(2)).remove(queryCaptor.capture(), any(Class.class));

        // Check that the rollback includes Manga Maniacs in the criteria
        Query activityQuery = queryCaptor.getAllValues().get(0);
        String queryString = activityQuery.toString();
        assertTrue(queryString.contains("Manga Maniacs"), 
                "Rollback should include Manga Maniacs club");
    }
}