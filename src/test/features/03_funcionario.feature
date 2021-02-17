#language:pt
#utf-8
#@all
Funcionalidade: Cadastro de funcionarios
  
  	Objetivo: Preencher os formularios solicitados e realizar um cadastro com sucesso

  @CT03 
  Esquema do Cenário: Realizar cadastro de funcionario.
    Dado acesso a pagina de cadastro funcionarios.
    Quando preencho os  campos Nome: "<nome>" Cargo "<cargo>"
    E os  campos CPF: "<cpf>" Salario "<salario>"
    E os  campos Sexo: "<sexo>" Admissão "<admissao>"
    E Tipo de Contratacao: "<tipo>"
    Entao valido a mensagem "<mensagem>" na tela

    Exemplos: 
      | nome      | cargo | cpf            | salario | sexo      | admissao   | tipo | mensagem                                   |
      | Junior    | QA    |    00011199900 | 1200000 | Masculino |   22022021 | PJ   | CPF Invalido!                              |
      | Ana Paula | QA    | 839.153.402-27 | 1300000 | Feminino  | 22/02/2021 | CLT  | SUCESSO! Usuário cadastrado                |
      | Ana Paula | QA    | 839.153.402-27 | 1300000 | Feminino  | 22/02/2021 | CLT  | SUCESSO! Usuário cadastrado com sucesso    |
      | Ana Paula | QA    | 839.153.402-27 | 1300000 | Feminino  | 22/02/2021 | CLT  | SUCESSO! Usuário cadastrado com sucesso\n× |

  @CT04 
  Esquema do Cenário: Realizar alteração de dados de funcionario
    Dado acesso a página de funcionarios.
    Quando pesquiso um colaborador pelo nome" <nome>" cadastrado
    E altero o cargo "<cargo>"
    Entao valido a mensagem "<mensagem>" na tela

    Exemplos: 
      | nome      | cargo            | mensagem                                        |
      | Ana Paula | Engenheiro de QA | SUCESSO! Informações atualizadas                |
      | Ana Paula | Engenheiro de QA | SUCESSO! Informações atualizadas com sucesso    |
      | Ana Paula | Engenheiro de QA | SUCESSO! Informações atualizadas com sucesso\n× |

  @CT05
  Esquema do Cenário: Realizar alteração de dados de funcionario
    Dado acesso a página de funcionarios.
    Quando pesquiso um colaborador pelo nome" <nome>" cadastrado
    E removo o colaborador
    Entao valido a mensagem "<mensagem>" na tela

    Exemplos: 
      | nome      | mensagem                                     |
      | Ana Paula | SUCESSO! Funcionário removido                |
      | Ana Paula | SUCESSO! Funcionário removido com sucesso    |
      | Ana Paula | SUCESSO! Funcionário removido com sucesso\n× |
