@regressivos

Feature: Testar Login
Como usuario
Quero fazer o login
Para acessar a pagina da loja
@positivo
Scenario: Login com credenciais validas
When preencho com credenciais validas
Then acesso a pagina da loja 
@negativo
Scenario: Login com credenciais invalidas
But preencho com credenciais invalidas
Then visualizo mensagem de erro
@negativo
Scenario: Login com credenciais bloqueados
But preencho com credenciais bloqueados
Then visualizo mensagem de bloqueio de usuario
@negativo
Scenario: Login com dados em branco
But não preencho os campos
Then visualizo mensagem de dados em branco
@negativo
Scenario: Login com campo senha em branco
When preencho campo usuario valido
But não preencho campo senha 
Then visualizo mensagem erro campo senha em branco