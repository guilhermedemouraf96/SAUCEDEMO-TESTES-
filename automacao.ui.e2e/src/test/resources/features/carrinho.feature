@regressivos

Feature: Carrinho de compras
Como usuario
Quero adicionar itens ao carrinho de compras
Para realizar uma compra 

Background: 
Given que esteja logado
When clico em Add to cart

@carrinho
Scenario: Adicionar itens ao carrinho
Then visualizo item no carrinho de compras
@removercarrinho
Scenario: Remover do carrinho de compras
When quando clico em Remove 
Then visualizo item removido do carrinho de compras
@finalizarcompra
Scenario: Finalizando compra
And preencho os dados e valido as informações da compra
And clico em finish
Then compra realizada com sucesso
@dadosinvalidos
Scenario: Finalizando compra com dados em branco
But nao preencho os campos obrigatórios
Then visualizo mensagem de erro
