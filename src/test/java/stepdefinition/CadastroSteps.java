package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriveFactory;
import core.PropertiesReader;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.CadastroPage;

public class CadastroSteps {

	private WebDriver driver = DriveFactory.driver;
	private WebDriverWait wait;

	public CadastroSteps() throws Exception {

		PropertiesReader propertiesReader = new PropertiesReader();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}

	CadastroPage cad = new CadastroPage(driver, wait);

	@Quando("^acesso a pagina de cadastro\\.$")
	public void acesso_a_pagina_de_cadastro() throws Throwable {
		cad.entrarCadastro();
	}

	@Entao("^preencho os  usuario \"([^\"]*)\" senha \"([^\"]*)\" e confirmacao de senha \"([^\"]*)\"$")
	public void preencho_os_usuario_senha_e_confirmacao_de_senha(String usuario, String senha, String confimeSenha)
			throws Throwable {
		cad.realizarCadastro(usuario, senha, confimeSenha);
	}

	@Entao("^valido a mensagem \"([^\"]*)\" na tela de cadastro$")
	public void valido_a_mensagem_na_tela_de_cadastro(String mensagem) throws Throwable {
		cad.validaMensagens(mensagem);
		cad.finalizaCadastro();
	}

}