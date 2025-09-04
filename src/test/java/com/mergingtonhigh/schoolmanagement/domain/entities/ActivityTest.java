package com.mergingtonhigh.schoolmanagement.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.DifficultyLevel;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.Email;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;

/**
 * Unit tests for Activity domain entity.
 */
class ActivityTest {

    @Test
    void shouldCreateActivityWithValidData() {
        // Arrange
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday", "Wednesday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        // Act
        Activity activity = new Activity(
                "Clube de Xadrez",
                "Aprenda estratégias de xadrez",
                "Seg/Qua 15:30-17:00",
                schedule,
                12,
                ActivityType.ACADEMIC);

        // Assert
        assertEquals("Clube de Xadrez", activity.getName());
        assertEquals("Aprenda estratégias de xadrez", activity.getDescription());
        assertEquals(12, activity.getMaxParticipants());
        assertEquals(0, activity.getCurrentParticipantCount());
        assertTrue(activity.canAddParticipant());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        // Arrange
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Activity(null, "Descrição", "Horário", schedule, 12, ActivityType.ACADEMIC));
    }

    @Test
    void shouldAddParticipantSuccessfully() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");

        // Act
        activity.addParticipant(studentEmail);

        // Assert
        assertEquals(1, activity.getCurrentParticipantCount());
        assertTrue(activity.isParticipantRegistered(studentEmail));
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateParticipant() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");
        activity.addParticipant(studentEmail);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> activity.addParticipant(studentEmail));
    }

    @Test
    void shouldRemoveParticipantSuccessfully() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");
        activity.addParticipant(studentEmail);

        // Act
        activity.removeParticipant(studentEmail);

        // Assert
        assertEquals(0, activity.getCurrentParticipantCount());
        assertFalse(activity.isParticipantRegistered(studentEmail));
    }

    @Test
    void shouldThrowExceptionWhenRemovingNonExistentParticipant() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> activity.removeParticipant(studentEmail));
    }

    @Test
    void shouldCreateActivityWithDifficultyLevel() {
        // Arrange
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday", "Wednesday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        // Act
        Activity activity = new Activity(
                "Programação Avançada",
                "Curso de programação para estudantes experientes",
                "Seg/Qua 15:30-17:00",
                schedule,
                8,
                ActivityType.TECHNOLOGY,
                DifficultyLevel.ADVANCED);

        // Assert
        assertEquals("Programação Avançada", activity.getName());
        assertEquals(DifficultyLevel.ADVANCED, activity.getDifficultyLevel());
        assertEquals("Avançado", activity.getDifficultyLevel().getLabel());
    }

    @Test
    void shouldCreateActivityWithoutDifficultyLevel() {
        // Arrange
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        // Act
        Activity activity = new Activity(
                "Atividade Geral",
                "Atividade para todos os níveis",
                "Seg 15:30-17:00",
                schedule,
                12,
                ActivityType.ACADEMIC);

        // Assert
        assertEquals("Atividade Geral", activity.getName());
        assertEquals(null, activity.getDifficultyLevel());
    }

    @Test
    void shouldSetDifficultyLevel() {
        // Arrange
        Activity activity = createTestActivity();

        // Act
        activity.setDifficultyLevel(DifficultyLevel.INTERMEDIATE);

        // Assert
        assertEquals(DifficultyLevel.INTERMEDIATE, activity.getDifficultyLevel());
        assertEquals("Intermediário", activity.getDifficultyLevel().getLabel());
    }

    private Activity createTestActivity() {
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        return new Activity(
                "Atividade de Teste",
                "Descrição de teste",
                "Seg 15:30-17:00",
                schedule,
                12,
                ActivityType.ACADEMIC);
    }
}