# Sistema de Gestão Escolar - Mergington High School

Sistema de gestão de atividades extracurriculares desenvolvido com Spring Boot e arquitetura limpa (Clean Architecture).

## 📋 Visão Geral

O **School Management System** é uma aplicação web que permite o gerenciamento de atividades extracurriculares da Mergington High School. O sistema possibilita que professores administrem atividades e que estudantes se inscrevam nelas através de uma interface web intuitiva.

## 🏗️ Arquitetura

### Princípios Arquiteturais

- **Clean Architecture**: Separação clara entre camadas de domínio, aplicação, infraestrutura e apresentação
- **Domain-Driven Design (DDD)**: Modelagem focada no domínio escolar
- **SOLID Principles**: Código bem estruturado e extensível
- **Hexagonal Architecture**: Isolamento das regras de negócio

### Estrutura de Camadas

```text
src/main/java/com/mergingtonhigh/schoolmanagement/
├── domain/                    # 🎯 Camada de Domínio
│   ├── entities/             # Entidades principais
│   │   ├── Activity.java     # Atividade extracurricular
│   │   └── Teacher.java      # Professor/Administrador
│   ├── repositories/         # Interfaces de repositório
│   │   ├── ActivityRepository.java
│   │   └── TeacherRepository.java
│   └── valueobjects/         # Objetos de valor
│       ├── ActivityType.java # Enum de tipos de atividade
│       ├── Email.java        # Validação de email
│       └── ScheduleDetails.java # Detalhes de horário
├── application/              # 🔧 Camada de Aplicação
│   ├── dtos/                 # Data Transfer Objects
│   │   ├── ActivityDTO.java
│   │   ├── ActivityTypeDTO.java
│   │   ├── LoginRequestDTO.java
│   │   ├── StudentRegistrationDTO.java
│   │   └── TeacherDTO.java
│   └── usecases/             # Casos de uso
│       ├── ActivityUseCase.java
│       ├── AuthenticationUseCase.java
│       └── StudentRegistrationUseCase.java
├── infrastructure/           # 🏭 Camada de Infraestrutura
│   ├── config/               # Configurações
│   ├── migrations/           # Migrações do banco
│   │   └── V001_InitialDatabaseSetup.java
│   └── persistence/          # Implementações de repositório
│       ├── ActivityRepositoryImpl.java
│       ├── MongoActivityRepository.java
│       ├── MongoTeacherRepository.java
│       └── TeacherRepositoryImpl.java
└── presentation/             # 🎨 Camada de Apresentação
    ├── controllers/          # Controllers REST
    │   ├── ActivityController.java
    │   ├── AuthController.java
    │   └── StaticController.java
    └── mappers/              # Mapeadores DTO ↔ Entity
        ├── ActivityMapper.java
        └── TeacherMapper.java
```

## 🚀 Tecnologias Utilizadas

### Backend

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.4** - Framework principal
- **Spring Data MongoDB** - Integração com MongoDB
- **Spring Security** - Autenticação e autorização
- **Spring Web** - APIs REST
- **Spring Validation** - Validação de dados
- **Mongock 5.5.1** - Migrações do banco de dados
- **BouncyCastle** - Criptografia para senhas

### Frontend

- **HTML5/CSS3/JavaScript** - Interface web responsiva
- **Vanilla JavaScript** - Interatividade sem frameworks externos
- **Design português/brasileiro** - Interface totalmente localizada
- **Componentes principais**:
  - Sistema de filtros por categoria e busca textual
  - Modal de autenticação integrado
  - Cartões de atividade com informações visuais
  - Gerenciamento de estado de sessão
  - Feedback visual para ações do usuário

### Banco de Dados

- **MongoDB** - Banco de dados NoSQL

### Ferramentas de Desenvolvimento

- **Maven** - Gerenciamento de dependências
- **JUnit 5** - Testes unitários
- **Mockito** - Mocks para testes
- **Testcontainers** - Testes de integração
- **Jacoco** - Cobertura de testes

## 📦 Funcionalidades Principais

### 🎓 Gestão de Atividades

- **Listagem de atividades** com filtros por:
  - Dia da semana
  - Horário (manhã, tarde, fim de semana)
  - Categoria (esportes, artes, acadêmico, etc.)
- **Detalhes de atividades**:
  - Nome e descrição
  - Horários e dias da semana
  - Capacidade máxima
  - Lista de participantes

### 👨‍🏫 Sistema de Autenticação

- **Login de professores** com username/senha
- **Controle de acesso** baseado em roles (TEACHER/ADMIN)
- **Autenticação requerida** para inscrições
- **Verificação de sessão** para manter estado de login
- **Logout** para encerrar sessão do usuário

### 📝 Gestão de Inscrições

- **Inscrição de estudantes** em atividades
- **Cancelamento de inscrições**
- **Validações**:
  - Capacidade máxima
  - Duplicatas
  - Autenticação do professor

### 🎨 Interface Web

- **Design responsivo** e intuitivo
- **Filtros dinâmicos** para busca de atividades por:
  - Categoria (Esportes, Artes, Acadêmico, Comunidade, Tecnologia)
  - Busca por texto
  - Dia da semana
- **Sistema de autenticação** integrado com modais
- **Categorização automática** de atividades por tipo
- **Feedback visual** para ações do usuário
- **Gerenciamento de sessão** com persistência de login

### 🏷️ Sistema de Categorização

As atividades são automaticamente categorizadas por tipo usando a enum `ActivityType`:

- **SPORTS** (Esportes) - `#e8f5e9` / `#2e7d32`
- **ARTS** (Artes) - `#f3e5f5` / `#7b1fa2` 
- **ACADEMIC** (Acadêmico) - `#e3f2fd` / `#1565c0`
- **COMMUNITY** (Comunidade) - `#fff3e0` / `#e65100`
- **TECHNOLOGY** (Tecnologia) - `#e8eaf6` / `#3949ab`

A categorização é baseada em palavras-chave no nome e descrição da atividade, com algoritmo automático que identifica o tipo mais apropriado.

## 📋 Estrutura de Dados

### DTOs (Data Transfer Objects)

#### ActivityDTO
Representa uma atividade completa com todos os dados necessários para o frontend:
```java
public record ActivityDTO(
    String name,                    // Nome da atividade
    String description,             // Descrição detalhada  
    String schedule,                // Horário formatado para exibição
    ScheduleDetailsDTO scheduleDetails, // Detalhes estruturados do horário
    int maxParticipants,            // Capacidade máxima
    List<String> participants,      // Lista de emails dos participantes
    int currentParticipantCount,    // Número atual de participantes
    ActivityTypeDTO type            // Categoria com informações visuais
)
```

#### TeacherDTO  
Dados do professor para autenticação:
```java
public record TeacherDTO(
    String username,    // Nome de usuário único
    String displayName, // Nome para exibição
    String role         // Função (teacher/admin)
)
```

#### ActivityTypeDTO
Informações de categoria para interface:
```java
public record ActivityTypeDTO(
    String name,      // Nome interno da categoria
    String label,     // Rótulo para exibição
    String color,     // Cor de fundo
    String textColor  // Cor do texto
)
```

#### LoginRequestDTO & StudentRegistrationDTO
DTOs para operações específicas de login e inscrição de estudantes.

### Value Objects

#### ActivityType (Enum)
Define os tipos de atividade com categorização automática baseada em palavras-chave:
- Detecta automaticamente o tipo analisando nome e descrição
- Fornece cores consistentes para interface
- Suporta português e inglês

#### ScheduleDetails  
Encapsula horários estruturados:
- Lista de dias da semana
- Horários de início e fim
- Validação de consistência

#### Email
Value object para validação de endereços de email com regex pattern.

## 🔧 Configuração e Execução

### Pré-requisitos

- Java 21
- Maven 3.8+
- MongoDB 4.4+

### Variáveis de Ambiente

Crie um arquivo `.env` baseado no `.env.example`:

```bash
# Configuração de Segurança  
SECURITY_ADMIN_USERNAME=admin
SECURITY_ADMIN_PASSWORD=admin123
SECURITY_ADMIN_ROLES=ADMIN

# Senhas dos Professores (para seed do banco)
PRINCIPAL_PASSWORD=admin123
TEACHER_RODRIGUEZ_PASSWORD=art123  
TEACHER_CHEN_PASSWORD=chess456
```

**Importante**: Use senhas fortes em produção. As senhas padrão são apenas para desenvolvimento.

### Executando o Projeto

1. **Iniciar MongoDB**:

   ```bash
   # Docker
   docker run -d -p 27017:27017 --name mongodb mongo:latest
   
   # Ou MongoDB local
   mongod
   ```

2. **Compilar e executar**:

   ```bash
   # Compilar o projeto
   mvn clean compile
   
   # Executar os testes
   mvn test
   
   # Iniciar a aplicação
   mvn spring-boot:run
   ```

3. **Acessar a aplicação**:
   - Frontend: <http://localhost:8080>
   - API REST: <http://localhost:8080/activities>
   - Autenticação: <http://localhost:8080/auth>
   - Health Check: <http://localhost:8080/actuator/health>

### Tasks Maven Disponíveis

- `mvn clean install` - Build completo
- `mvn test` - Executar testes
- `mvn spring-boot:run` - Iniciar aplicação
- `mvn package -DskipTests` - Gerar JAR

## 🌐 API REST

### Endpoints Principais

#### Atividades

```http
# Listar todas as atividades
GET /activities

# Listar atividades com filtros opcionais
GET /activities?day=Monday&start_time=15:00&end_time=17:00

# Obter dias disponíveis para atividades
GET /activities/days
```

**Resposta de `/activities`**: Retorna um objeto com atividades onde cada chave é o nome da atividade e o valor contém:
- `name` - Nome da atividade
- `description` - Descrição detalhada
- `schedule` - Horário formatado para exibição
- `scheduleDetails` - Objeto com `days[]`, `startTime`, `endTime`
- `maxParticipants` - Capacidade máxima
- `participants[]` - Lista de emails dos participantes
- `currentParticipantCount` - Número atual de participantes
- `type` - Objeto com informações de categoria (`name`, `label`, `color`, `textColor`)

#### Autenticação

```http
# Login de professor
POST /auth/login
Content-Type: application/x-www-form-urlencoded

username=mrodriguez&password=password123

# Verificar sessão ativa
GET /auth/check-session?username=mrodriguez
```

**Resposta de `/auth/login`**: Retorna dados do professor logado:
```json
{
  "username": "mrodriguez",
  "displayName": "Sr. Rodriguez", 
  "role": "teacher"
}
```

**Resposta de erro**: `401` com `{"detail": "Invalid username or password"}`

#### Inscrições

```http
# Inscrever estudante em atividade
POST /activities/{activityName}/signup
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=mrodriguez

# Cancelar inscrição de estudante
POST /activities/{activityName}/unregister  
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=mrodriguez
```

**Respostas**:
- `200` - `{"message": "Sucesso na operação"}`
- `400` - `{"detail": "Erro de validação"}`
- `401` - `{"detail": "Authentication required for this action"}`
- `404` - `{"detail": "Activity/Student not found"}`

#### Interface Web

```http
# Página principal da aplicação
GET /
```

Serve a interface web estática localizada em `/static/index.html`.

## 🧪 Testes

### Estrutura de Testes

```text
src/test/java/
├── application/usecases/     # Testes de casos de uso
├── domain/entities/          # Testes de entidades
└── integration/             # Testes de integração
```

### Executar Testes

```bash
# Todos os testes
mvn test

# Testes específicos
mvn test -Dtest=ActivityTest
mvn test -Dtest=StudentRegistrationUseCaseTest

# Com cobertura
mvn jacoco:report
```

## 📊 Dados Iniciais

O sistema utiliza **Mongock** para realizar migrações automáticas do banco de dados, incluindo:

### Professores Padrão

- **admin** - Administrador principal (senha configurável via `ADMIN_PASSWORD`)
- **mrodriguez** - Sr. Rodriguez, Professor de artes (senha via `TEACHER_RODRIGUEZ_PASSWORD`)
- **mchen** - Sra. Chen, Professora de xadrez (senha via `TEACHER_CHEN_PASSWORD`)
- **principal** - Diretor da escola (senha via `PRINCIPAL_PASSWORD`)

### Atividades Exemplo

O sistema inclui 14 atividades pré-configuradas categorizadas por tipo:

**Esportes**: Time de Futebol, Time de Basquete, Fitness Matinal
**Artes**: Clube de Arte, Clube de Teatro, Manga Maniacs  
**Acadêmico**: Clube de Xadrez, Torneio de Xadrez, Clube de Matemática, Equipe de Debates, Olimpíada de Ciências
**Tecnologia**: Aula de Programação, Oficina de Robótica
**Comunidade**: Serviço Comunitário

Cada atividade possui horários específicos, capacidade limitada e alguns participantes pré-inscritos para demonstração.

## 🔒 Segurança

- **Autenticação HTTP Basic** para endpoints administrativos
- **Criptografia Argon2** para senhas
- **Validação de dados** em todas as camadas
- **CORS** configurado para desenvolvimento

## 📈 Monitoramento

- **Spring Actuator** - Métricas da aplicação
- **Logs estruturados** - Nível DEBUG para desenvolvimento
- **Health checks** - Status da aplicação e banco

## 🚀 Deploy

### Perfis de Ambiente

- **dev** - Ambiente de desenvolvimento com:
  - CORS habilitado para todos os origins (`*`)
  - Logs em nível DEBUG
  - MongoDB local (localhost:27017)
  - DevTools habilitado com LiveReload
- **prod** - Ambiente de produção (configurar conforme necessário)
