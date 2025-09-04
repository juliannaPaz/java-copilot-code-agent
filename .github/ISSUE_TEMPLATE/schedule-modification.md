---
name: 📅 Modificar Horários e Agendas
about: Solicitar mudanças nos horários das atividades ou criar novos horários
title: "[HORÁRIOS] "
labels: ["enhancement", "schedule", "teacher-request"]
assignees: []
---

## 🕐 Informações da Solicitação de Horário

### Tipo de Modificação
<!-- Marque uma das opções com [x] -->
- [ ] Alterar horário de atividade existente
- [ ] Adicionar novo horário para atividade existente
- [ ] Remover horário de atividade
- [ ] Criar horário especial (evento único)
- [ ] Modificar dias da semana
- [ ] Ajustar duração das sessões
- [ ] Outro: ___________

### Nome da Atividade
<!-- Nome exato da atividade como aparece no sistema -->
**Atividade:** 

## 📊 Detalhes Atuais vs. Novos

### Horário Atual
**Dias da semana atuais:** 
<!-- Ex: Segunda, Quarta, Sexta -->

**Horário atual:** 
<!-- Ex: 15:00 às 16:30 -->

**Duração atual:** 
<!-- Ex: 1h30min -->

### Novo Horário Solicitado
**Novos dias da semana:** 
<!-- Ex: Terça, Quinta -->

**Novo horário:** 
<!-- Ex: 14:00 às 15:30 -->

**Nova duração:** 
<!-- Ex: 1h30min -->

### Para Horários Adicionais
**Horário adicional:** 
<!-- Se for adicionar um novo horário além do existente -->

**Dias do horário adicional:** 
<!-- Dias da semana para o horário adicional -->

## 🏫 Informações de Local e Recursos

### Local das Aulas
**Local atual:** 
**Novo local (se aplicável):** 

### Disponibilidade do Local
<!-- O local está disponível no novo horário? -->
- [ ] Sim, confirmei que está livre
- [ ] Não tenho certeza, precisa verificar
- [ ] Sei que está ocupado, mas podemos negociar
- [ ] Preciso de ajuda para encontrar outro local

### Recursos Necessários
<!-- Equipamentos, materiais, etc. -->
**Recursos atuais:** 
**Novos recursos necessários:** 

## 👥 Impacto nos Participantes

### Alunos Atualmente Inscritos
**Número de alunos afetados:** 
<!-- Quantos alunos estão inscritos na atividade -->

### Comunicação com Alunos
- [ ] Já informei os alunos sobre a possível mudança
- [ ] Preciso informar os alunos após aprovação
- [ ] Os alunos solicitaram esta mudança
- [ ] A mudança não afeta alunos (ainda não há inscritos)

### Conflitos de Horário
<!-- Esta mudança pode criar conflitos com outras atividades? -->
- [ ] Não vejo conflitos
- [ ] Pode conflitar com: ___________
- [ ] Preciso verificar conflitos
- [ ] Conflitos são aceitáveis

## 📅 Prazo e Implementação

### Quando a mudança deve entrar em vigor?
- [ ] Imediatamente
- [ ] Próxima semana
- [ ] Próximo mês
- [ ] Início do próximo período/semestre
- [ ] Data específica: ___________

### Motivo da Mudança
<!-- Por que esta modificação de horário é necessária? -->
**Justificativa:** 

### Urgência
- [ ] Crítica - Precisa ser alterado urgentemente
- [ ] Alta - Importante alterar em breve
- [ ] Normal - Pode aguardar algumas semanas
- [ ] Baixa - Quando for conveniente

## 🎯 Critérios de Aceitação

- [ ] O novo horário deve aparecer corretamente na lista de atividades
- [ ] Alunos devem ver as informações de horário atualizadas
- [ ] O sistema deve validar que não há conflitos impossíveis
- [ ] Se houver alunos inscritos, eles devem ser mantidos (a menos que especificado)
- [ ] As informações antigas devem ser substituídas pelas novas
- [ ] O horário deve ser formatado corretamente na interface

## 💡 Informações Adicionais

### Professor Responsável
**Nome:** 
**Disponibilidade no novo horário:** 
- [ ] Confirmado que estou disponível
- [ ] Preciso verificar minha agenda
- [ ] Terei conflitos, mas posso resolver

### Observações Especiais
<!-- Qualquer informação adicional relevante -->

### Horários Alternativos
<!-- Se o horário solicitado não for possível, que alternativas aceita? -->
**Alternativa 1:** 
**Alternativa 2:** 

---

## 🔧 Informações Técnicas (Para o Agente de Codificação)

**Arquivos que provavelmente precisarão ser modificados:**
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/valueobjects/ScheduleDetails.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/entities/Activity.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/ActivityUseCase.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/infrastructure/migrations/V001_InitialDatabaseSetup.java`

**Considerações sobre ScheduleDetails:**
- Value object existente que armazena dias da semana e horários
- Usar `LocalTime` para horários
- Lista de dias da semana como Strings
- Validar formato de horários e dias válidos

**Padrões a seguir:**
- Validar horários usando `ScheduleDetails` adequadamente
- Verificar se novos horários não são conflitantes internamente
- Usar formato 24h para horários (`LocalTime`)
- Manter integridade de dados com alunos inscritos
- Implementar validação de entrada para horários

**Validações necessárias:**
- Formato de horário válido (HH:mm)
- Dias da semana válidos
- Horário de início antes do horário de fim
- Duração mínima e máxima razoável
- Verificar se o valor object `ScheduleDetails` suporta as mudanças

**Testes importantes:**
- Modificação de horários com alunos inscritos
- Validação de formatos de horário
- Criação de `ScheduleDetails` com novos dados
- Interface mostrando horários atualizados
- Migração de dados se necessário