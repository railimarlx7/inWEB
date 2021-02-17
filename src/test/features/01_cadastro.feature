#language:pt
#utf-8
@all @CT01 
Funcionalidade: Cadastro de usuarios
  
  	Objetivo: Preencher os formularios solicitados e realizar um cadastro com sucesso

  @CT01
  Esquema do Cenário: Realizar cadastro de usuario.
    Dado acesso a pagina de cadastro.
    Entao preencho os  usuario "<usuario>" senha "<senha>" e confirmacao de senha "<confimeSenha>"
    Entao valido a mensagem "<mensagem>" na tela de cadastro

    Exemplos: 
      | usuario   | senha    | confimeSenha | mensagem                 |
      | usuario02 | user1234 | user1235     | Senhas não combinam      |
      | usuario02 | user1234 | user1234     | Usuário já cadastrado    |
  
