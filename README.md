# Que Aula — Backend (Spring Boot)

## Visão geral

API REST para gerenciamento de disciplinas, turmas (sections) e aulas (courses). O projeto usa Spring Boot, JPA e validações com Bean Validation.

## Stack

- Java 17
- Spring Boot 3.5.7
- Spring Web + Spring Data JPA + Validation
- H2 (dev) e PostgreSQL (prod)

## Estrutura de domínio

- **Subject** (disciplina)
  - `code` (PK, String)
  - `name` (String)
  - 1:N com `Section`
- **Section** (turma)
  - `code` + `subjectCode` (PK composta)
  - `isStrike` (Boolean)
  - `subject` (N:1)
  - 1:N com `Course`
- **Course** (aula)
  - `idCourse` (PK, Long)
  - `section` (N:1)
  - `teacher`, `classroom`, `weekday`, `periodStart`, `periodEnd`

## Perfis e configuração

O perfil ativo padrão é `dev`.

### Dev (H2 em memória)

- Porta: **8081**
- H2 console habilitado
- `spring.jpa.hibernate.ddl-auto=update`

### Prod (PostgreSQL)

- Porta: **8080**
- Usa PostgreSQL
- `spring.jpa.hibernate.ddl-auto=update`

> Recomenda-se mover credenciais para variáveis de ambiente em produção.

## Como iniciar o projeto

### Pré-requisitos

- Java 17
- Maven (ou usar o wrapper `mvnw`)

### Subir em desenvolvimento (profile dev)

- Usando Maven Wrapper:
  - `mvnw spring-boot:run`
- A API ficará disponível em: `http://localhost:8081`

### Build e execução

- Build do JAR:
  - `mvnw clean package`
- Executar o JAR:
  - `java -jar target/que-aula-0.0.1-SNAPSHOT.jar`

## Base URL

- `http://localhost:8081/api` (dev)
- `http://localhost:8080/api` (prod)

## Endpoints

### Subjects

- `GET /api/subjects` → lista com seções
- `GET /api/subjects/{code}` → detalhes da disciplina
- `POST /api/subjects` → cria disciplina
- `PUT /api/subjects/{code}` → atualiza disciplina
- `DELETE /api/subjects/{code}` → remove disciplina

### Sections

- `GET /api/sections` → lista com cursos (aulas)
- `GET /api/sections/{subjectCode}/{code}` → detalhes da turma
- `POST /api/sections` → cria turma
- `PUT /api/sections/{subjectCode}/{code}` → atualiza turma
- `DELETE /api/sections/{subjectCode}/{code}` → remove turma

### Courses

- `GET /api/courses` → lista de aulas
- `GET /api/courses/{id}` → detalhes da aula
- `POST /api/courses` → cria aula
- `PUT /api/courses/{id}` → atualiza aula
- `DELETE /api/courses/{id}` → remove aula

## DTOs e payloads

### SubjectDTO (request)

```json
{
  "code": "INF101",
  "name": "Programação I"
}
```

### SubjectResponseDTO (response)

```json
{
  "code": "INF101",
  "name": "Programação I"
}
```

### SubjectFullDTO (response)

```json
{
  "code": "INF101",
  "name": "Programação I",
  "sections": [
    {
      "code": "A",
      "isStrike": false,
      "subjectCode": "INF101"
    }
  ]
}
```

### SectionDTO (request)

```json
{
  "code": "A",
  "isStrike": false,
  "subjectCode": "INF101"
}
```

### SectionResponseDTO (response)

```json
{
  "code": "A",
  "isStrike": false,
  "subjectCode": "INF101"
}
```

### SectionFullDTO (response)

```json
{
  "code": "A",
  "isStrike": false,
  "subjectCode": "INF101",
  "courses": [
    {
      "idCourse": 1,
      "sectionCode": "A",
      "subjectCode": "INF101",
      "teacher": "Maria",
      "classroom": "Lab 1",
      "weekday": 1,
      "periodStart": 2,
      "periodEnd": 3
    }
  ]
}
```

### CourseDTO (request)

```json
{
  "sectionCode": "A",
  "subjectCode": "INF101",
  "teacher": "Maria",
  "classroom": "Lab 1",
  "weekday": 1,
  "periodStart": 2,
  "periodEnd": 3
}
```

### CourseResponseDTO (response)

```json
{
  "idCourse": 1,
  "sectionCode": "A",
  "subjectCode": "INF101",
  "teacher": "Maria",
  "classroom": "Lab 1",
  "weekday": 1,
  "periodStart": 2,
  "periodEnd": 3
}
```

## Regras de validação

- Todos os campos de DTO marcados com `@NotBlank`/`@NotNull` são obrigatórios.
- `weekday` deve estar entre 0 e 6.
- `periodStart` e `periodEnd` devem estar entre 0 e 5.

## Erros comuns

- 404 quando `Subject`, `Section` ou `Course` não existe.
- 400 quando payload viola validações.

## Conectar com o front-end

1. Use a base URL de dev: `http://localhost:8081/api`.
2. Configure o front-end com uma variável de ambiente, por exemplo:
   - `VITE_API_URL=http://localhost:8081/api`
3. Exemplos de chamadas:
   - `GET /subjects`
   - `GET /sections`
   - `GET /courses`

> Observação: não há configuração explícita de CORS no backend. Se o front-end estiver em outra origem, adicione CORS conforme a necessidade.
