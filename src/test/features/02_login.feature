#language:pt
#utf-8
@all @CT02 
Funcionalidade: login
  
  	Objetivo: Validar login.

  @CT02 
  Esquema do Cenário: Realizar login.
    Dado que acesso o site
    Quando efetuo o login com usuario "<usuario>" e senha "<senha>"
    Entao valido a mensagem "<mensagem>" na tela de login

    Exemplos: 
      | usuario   | senha    | mensagem                            |
      #teste fail
      | usuario02 |      123 | ERRO! Usuário ou Senha inválidos    |
      #teste success
      | usuario02 | user1234 |                                     |
