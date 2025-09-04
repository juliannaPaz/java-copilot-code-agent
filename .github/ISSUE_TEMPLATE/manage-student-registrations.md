---
name: 👥 Gerenciar Inscrições de Alunos
about: Solicitar modificações nas inscrições de alunos em atividades
title: "[INSCRIÇÕES] "
labels: ["enhancement", "students", "registration", "teacher-request"]
assignees: []
---

## 🎯 Informações da Solicitação

### Nome da Atividade
<!-- Nome exato da atividade como aparece no sistema -->
**Atividade:** 

### Tipo de Solicitação
<!-- Marque uma das opções com [x] -->
- [ ] Inscrever aluno manualmente
- [ ] Remover aluno da atividade
- [ ] Transferir aluno para outra atividade
- [ ] Visualizar lista de alunos inscritos
- [ ] Alterar limite de vagas da atividade
- [ ] Criar lista de espera
- [ ] Outro: ___________

## 👨‍🎓 Informações do(s) Aluno(s)

### Para Inscrição Manual
**Nome do aluno:** 
**Email do aluno:** 
**Motivo da inscrição manual:** 
<!-- Ex: Aluno perdeu o prazo, transferência de escola, etc. -->

### Para Remoção de Aluno
**Nome do aluno:** 
**Email do aluno:** 
**Motivo da remoção:** 
<!-- Ex: Conflito de horário, desistência, transferência, etc. -->

### Para Transferência
**Nome do aluno:** 
**Email do aluno:** 
**Atividade de origem:** 
**Atividade de destino:** 
**Motivo da transferência:** 

### Para Alteração de Limite
**Limite atual:** 
**Novo limite:** 
**Justificativa:** 
<!-- Ex: Mudança de sala permitiu mais alunos -->

## 🎯 Critérios de Aceitação

### Para Inscrição Manual
- [ ] O aluno deve ser adicionado à lista de participantes da atividade
- [ ] O sistema deve verificar se ainda há vagas disponíveis
- [ ] O aluno deve receber confirmação de inscrição
- [ ] O contador de participantes deve ser atualizado

### Para Remoção de Aluno
- [ ] O aluno deve ser removido da lista de participantes
- [ ] Uma vaga deve ficar disponível para outros alunos
- [ ] O aluno deve ser notificado sobre a remoção
- [ ] Se há lista de espera, o próximo aluno deve ser automaticamente inscrito

### Para Transferência
- [ ] O aluno deve ser removido da atividade de origem
- [ ] O aluno deve ser inscrito na atividade de destino
- [ ] Verificar disponibilidade de vagas na atividade de destino
- [ ] Ambas atividades devem ter contadores atualizados

### Para Alteração de Limite
- [ ] O novo limite deve ser aplicado à atividade
- [ ] Se o novo limite for menor que o número atual de inscritos, deve haver tratamento especial
- [ ] Se o novo limite for maior, deve permitir mais inscrições

## 💡 Contexto Adicional

### Informações sobre o Aluno
<!-- Qualquer contexto adicional sobre o aluno ou situação -->

### Impacto nas Outras Atividades
<!-- Esta mudança afeta outras atividades? -->

### Data Limite
<!-- Existe alguma urgência para esta solicitação? -->
- [ ] Urgente (hoje)
- [ ] Esta semana
- [ ] Próximas duas semanas
- [ ] Não há pressa

### Observações Especiais
<!-- Qualquer informação adicional relevante -->

---

## 🔧 Informações Técnicas (Para o Agente de Codificação)

**Arquivos que provavelmente precisarão ser modificados:**
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/StudentRegistrationUseCase.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/ActivityUseCase.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/entities/Activity.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/dtos/StudentRegistrationDTO.java`

**Métodos existentes para referência:**
- `Activity.canAddParticipant()` - verifica se há vagas
- `Activity.isParticipantRegistered(Email email)` - verifica se aluno já está inscrito
- `StudentRegistrationUseCase.registerStudent()` - para inscrições

**Padrões a seguir:**
- Sempre validar autenticação do professor antes de modificações
- Verificar limites de participantes antes de inscrever
- Usar validação de email adequada
- Manter integridade dos dados
- Implementar transações para operações que afetam múltiplas entidades

**Considerações importantes:**
- Verificar se atividade existe antes de qualquer operação
- Validar formato do email do aluno
- Implementar lógica de lista de espera se necessário
- Manter logs de auditoria das modificações
- Tratar casos onde o aluno já está inscrito ou não existe

**Testes necessários:**
- Inscrição manual com e sem vagas disponíveis
- Remoção de aluno inscrito e não inscrito
- Transferência entre atividades
- Alteração de limites com diferentes cenários
- Validação de emails inválidos