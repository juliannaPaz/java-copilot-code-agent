---
name: 🎯 Adicionar Nova Atividade
about: Solicitar a criação de uma nova atividade extracurricular
title: "[NOVA ATIVIDADE] "
labels: ["enhancement", "activity", "teacher-request"]
assignees: []
---

## 📋 Informações da Nova Atividade

### Nome da Atividade
<!-- Forneça o nome completo da nova atividade -->
**Nome:** 

### Descrição Detalhada
<!-- Descreva o que a atividade faz, seus objetivos e benefícios para os alunos -->
**Descrição:** 

### Categoria da Atividade
<!-- Selecione uma categoria marcando com [x] -->
- [ ] Esportes
- [ ] Artes
- [ ] Acadêmica
- [ ] Tecnologia
- [ ] Música
- [ ] Teatro
- [ ] Outra: ___________

### Informações de Agendamento
**Dias da semana:** 
<!-- Ex: Segunda, Quarta, Sexta -->

**Horário:** 
<!-- Ex: 15:00 às 16:30 -->

**Duração de cada sessão:** 
<!-- Ex: 1h30min -->

### Limites e Requisitos
**Número máximo de participantes:** 
<!-- Ex: 20 alunos -->

**Pré-requisitos (se houver):** 
<!-- Ex: Nenhum, ou "Conhecimento básico de programação" -->

### Professor Responsável
**Nome do professor:** 
<!-- Nome completo do professor que será responsável -->

**Email de contato:** 
<!-- Email institucional do professor -->

## 🎯 Critérios de Aceitação

- [ ] A nova atividade deve aparecer na lista de atividades disponíveis
- [ ] Alunos devem conseguir se inscrever na atividade
- [ ] O sistema deve respeitar o limite máximo de participantes
- [ ] As informações de horário devem ser exibidas corretamente
- [ ] A atividade deve ser categorizada adequadamente
- [ ] O professor responsável deve conseguir visualizar os alunos inscritos

## 💡 Contexto Adicional

### Localização das Aulas
<!-- Ex: Laboratório de Informática, Quadra de Esportes, Sala 201 -->
**Local:** 

### Materiais Necessários
<!-- Liste os materiais ou equipamentos necessários -->
**Materiais:** 

### Observações Especiais
<!-- Qualquer informação adicional relevante -->

---

## 🔧 Informações Técnicas (Para o Agente de Codificação)

**Arquivos que provavelmente precisarão ser modificados:**
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/entities/Activity.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/infrastructure/migrations/V001_InitialDatabaseSetup.java`
- Possível adição de novos tipos de atividade em `ActivityType.java`

**Padrões a seguir:**
- Use validação de entrada nos construtores de entidade
- Implemente o padrão de Use Case na camada de aplicação
- Mantenha a separação de responsabilidades da Clean Architecture
- Adicione a nova atividade na configuração inicial do banco de dados (se necessário)

**Considerações de teste:**
- Adicionar testes unitários para a nova atividade
- Verificar integração com sistema de inscrições
- Validar limites de participantes