---
name: 🐛 Relatar Problema no Sistema
about: Relatar um bug ou problema técnico no sistema de atividades
title: "[BUG] "
labels: ["bug", "teacher-report"]
assignees: []
---

## 🐛 Descrição do Problema

### O que estava tentando fazer?
<!-- Descreva a ação que estava tentando realizar -->

### O que aconteceu?
<!-- Descreva o comportamento inesperado que observou -->

### O que esperava que acontecesse?
<!-- Descreva o comportamento esperado -->

## 🔍 Detalhes do Problema

### Onde o problema ocorreu?
<!-- Marque todas as opções aplicáveis com [x] -->
- [ ] Página inicial de atividades
- [ ] Login de professor
- [ ] Inscrição de alunos
- [ ] Visualização de participantes
- [ ] Busca/filtro de atividades
- [ ] Informações de horários
- [ ] Outro: ___________

### Quando o problema acontece?
<!-- Marque a opção aplicável com [x] -->
- [ ] Sempre que tento fazer essa ação
- [ ] Às vezes (intermitente)
- [ ] Só aconteceu uma vez
- [ ] Acontece em horários específicos: ___________

### Que tipo de problema é?
<!-- Marque todas as opções aplicáveis com [x] -->
- [ ] Não consigo fazer login
- [ ] Informações incorretas sendo exibidas
- [ ] Página não carrega
- [ ] Botão não funciona
- [ ] Erro ao inscrever aluno
- [ ] Dados não salvam
- [ ] Mensagem de erro aparece
- [ ] Sistema lento
- [ ] Outro: ___________

## 📱 Informações do Ambiente

### Qual dispositivo você estava usando?
- [ ] Computador/Laptop
- [ ] Tablet
- [ ] Celular

### Qual navegador?
- [ ] Chrome
- [ ] Firefox
- [ ] Safari
- [ ] Edge
- [ ] Outro: ___________

### Sistema Operacional
- [ ] Windows
- [ ] Mac
- [ ] iOS
- [ ] Android
- [ ] Outro: ___________

## 🔄 Passos para Reproduzir

### Como posso reproduzir este problema?
<!-- Liste os passos exatos que levaram ao problema -->
1. 
2. 
3. 
4. 

### Dados de exemplo (se aplicável)
**Nome da atividade:** 
**Email do aluno:** 
**Horário em que ocorreu:** 

## 📸 Evidências

### Mensagens de erro
<!-- Cole aqui qualquer mensagem de erro que apareceu -->
```
[Cole a mensagem de erro aqui]
```

### Comportamento observado
<!-- Descreva detalhadamente o que viu -->

### Screenshots (se possível)
<!-- Se conseguir tirar uma foto da tela mostrando o problema, anexe aqui -->
_Anexar imagem ou descrever o que aparece na tela_

## ⚡ Urgência

### Qual o impacto deste problema?
- [ ] Crítico - Não consigo trabalhar (precisa ser resolvido hoje)
- [ ] Alto - Atrapalha muito o trabalho (dentro de 2-3 dias)
- [ ] Médio - Inconveniente mas posso contornar (dentro de 1 semana)
- [ ] Baixo - Problema menor (quando possível)

### Está afetando alunos?
- [ ] Sim, alunos não conseguem se inscrever
- [ ] Sim, alunos estão vendo informações erradas
- [ ] Sim, alunos estão confusos
- [ ] Não, só afeta professores
- [ ] Não tenho certeza

## 💡 Informações Adicionais

### Já tentou alguma solução?
<!-- Descreva qualquer coisa que já tentou para resolver -->

### O problema começou recentemente?
- [ ] Nunca funcionou
- [ ] Parou de funcionar hoje
- [ ] Parou de funcionar esta semana
- [ ] Não lembro quando começou
- [ ] Funcionava antes, não sei quando parou

### Observações
<!-- Qualquer outro detalhe que possa ser útil -->

---

## 🔧 Informações Técnicas (Para o Agente de Codificação)

**Áreas do código para investigar baseado no tipo de problema:**

### Problemas de Login
- `src/main/java/com/mergingtonhigh/schoolmanagement/presentation/controllers/AuthController.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/AuthenticationUseCase.java`
- `src/main/resources/static/app.js` (funções de login)

### Problemas de Atividades
- `src/main/java/com/mergingtonhigh/schoolmanagement/presentation/controllers/ActivityController.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/ActivityUseCase.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/entities/Activity.java`

### Problemas de Inscrição
- `src/main/java/com/mergingtonhigh/schoolmanagement/application/usecases/StudentRegistrationUseCase.java`
- `src/main/java/com/mergingtonhigh/schoolmanagement/domain/entities/Activity.java`

### Problemas de Interface
- `src/main/resources/static/index.html`
- `src/main/resources/static/app.js`
- `src/main/resources/static/styles.css`

**Padrões de debugging:**
- Verificar logs do Spring Boot para erros do backend
- Verificar console do navegador para erros JavaScript
- Testar endpoints da API diretamente
- Verificar validações de entrada
- Verificar status codes HTTP retornados
- Validar dados no MongoDB

**Testes de regressão:**
- Criar teste automatizado que reproduza o bug
- Verificar se correção não quebra funcionalidades existentes
- Testar em diferentes navegadores se for problema de frontend