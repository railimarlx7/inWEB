## InWeb

Desafio WEB - Inmetrics

## Cosntruido com:

* [Selenium](https://www.selenium.dev/documentation/en/webdriver/)
* [Maven](https://maven.apache.org/) 
* [Cucumber](https://cucumber.io/) 
* [Allure Framework](https://docs.qameta.io/allure/) 

## Pré-requisitos
* [Java SE Development Kit](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
* [Eclispe IDE](https://www.eclipse.org/downloads/)
 
## Executando pela IDE Eclipse.
* **Clonar o projeto do repesotório git** [https://github.com/railimarlx7/inWEB.git](https://github.com/railimarlx7/inWEB.git)
* **Impotar como "Existing Maven Projetcs" no "Menu File/Import"**
* **Executar o arquivo "Runner.java** (src/test/java/runner)

## Executando pelo console do Windows.
* **Navegar até a pasta onde foi clonado o projeto** 
* **Executar o comando** - mvn clean test -Dtest=Runner -Dcucumber.options="--tags @all --plugin pretty" allure:serve 

## Relatórios.
* **Será gerado automaticamente na execução do projeto via console**

## Imagem de execução pelo Jenkins
![alt text](http://url/to/img.png)

## Autor

* **Raimundo Lima Jr** - [LinkedIn](https://www.linkedin.com/in/railimajr/)