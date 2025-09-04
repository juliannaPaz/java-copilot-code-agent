---
name: ✏️ Modificar Atividade Existente
about: Solicitar alterações em uma atividade já existente
title: "[MODIFICAR ATIVIDADE] "
labels: ["enhancement", "activity", "modification", "teacher-request"]
assignees: []
---

## 🎯 Atividade a ser Modificada

### Nome da Atividade Atual
<!-- Nome exato da atividade como aparece no sistema -->
**Atividade:** 

## 📝 Modificações Solicitadas

### Que tipo de modificação você precisa?
<!-- Marque todas as opções aplicáveis com [x] -->
- [ ] Alterar nome da atividade
- [ ] Alterar descrição
- [ ] Modificar horários
- [ ] Alterar dias da semana
- [ ] Mudar limite de participantes
- [ ] Alterar categoria
- [ ] Trocar professor responsável
- [ ] Modificar local das aulas
- [ ] Outro: ___________

### Informações Atuais vs. Novas

#### Nome
- **Atual:** 
- **Novo:** 
<!-- Deixe em branco se não aplicável -->

#### Descrição
- **Atual:** 
- **Nova:** 
<!-- Deixe em branco se não aplicável -->

#### Horário
- **Atual:** 
- **Novo:** 
<!-- Ex: de "15:00-16:30" para "14:00-15:30" -->

#### Dias da Semana
- **Atual:** 
- **Novo:** 
<!-- Ex: de "Segunda, Quarta" para "Terça, Quinta" -->

#### Limite de Participantes
- **Atual:** 
- **Novo:** 
<!-- Ex: de "20" para "25" -->

#### Categoria
- **Atual:** 
- **Nova:** 
<!-- Deixe em branco se não aplicável -->

#### Professor Responsável
- **Atual:** 
- **Novo:** 
<!-- Deixe em branco se não aplicável -->

## 🎯 Critérios de Aceitação

- [ ] As modificações devem ser aplicadas corretamente na atividade especificada
- [ ] Outros dados da atividade devem permanecer inalterados
- [ ] Alunos já inscritos devem continuar inscritos (a menos que especificado diferentemente)
- [ ] As novas informações devem aparecer corretamente na interface do usuário
- [ ] Se o limite de participantes for reduzido, o sistema deve lidar com isso adequadamente
- [ ] As modificações devem ser persistidas no banco de dados

## 💡 Justificativa para a Mudança

### Por que esta modificação é necessária?
<!-- Explique o motivo da mudança -->

### Há alunos já inscritos que podem ser afetados?
<!-- Se sim, como isso deve ser tratado? -->
- [ ] Não há alunos inscritos
- [ ] Há alunos inscritos, mas a mudança não os afeta
- [ ] Há alunos inscritos que podem ser afetados: ___________

### Urgência da Modificação
- [ ] Urgente (precisa ser feito esta semana)
- [ ] Normal (pode ser feito nas próximas 2 semanas)
- [ ] Baixa prioridade (quando possível)

## 🔧 Informações Técnicas (Para o Agente de Codificação)

**Arquivos que provavelmente precisarão ser modificados:**
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/ActivityUseCase.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/entities/Activity.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/infrastructure/persistence/ActivityRepositoryImpl.java`
- Possivelmente `src/main/java/com/mergingtonhigh/schoolmanagement/infrastructure/migrations/V001_InitialDatabaseSetup.java`

**Considerações importantes:**
- Validate que a atividade existe antes de modificar
- Mantenha integridade referencial com alunos inscritos
- Se reduzir limite de participantes, implemente lógica para lidar com excesso
- Use validação de entrada nas modificações
- Mantenha logs de auditoria se necessário

**Padrões a seguir:**
- Implemente método de atualização no Use Case de atividades
- Use validação apropriada nos setters da entidade Activity
- Mantenha separação de responsabilidades da Clean Architecture
- Adicione testes para as modificações

**Testes necessários:**
- Verificar se modificações são aplicadas corretamente
- Testar casos onde alunos estão inscritos
- Validar limites de participantes modificados
- Testar integridade dos dados após modificação