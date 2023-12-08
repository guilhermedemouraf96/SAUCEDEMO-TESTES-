@regressivos
@produtos

Feature: Lista de produtos da loja
Como usuario
Quero visualizar lista de produtos
Para realizar uma compra

Pré-requisito: estar logado

Background: Realizar login
Given que esteja logado

Scenario: Busca de produtos cadastrados 
When busca de produtos
Then valido se corresponde aos produtos pesquisados

@filtro
Scenario: Selecionar Filtro
When clicar em ordenar
Then valido a ordem dos produtos corresponde a filtro selecionado


