package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriveFactory;
import core.PropertiesReader;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.LoginPage;

public class LoginSteps {

    private WebDriver driver = DriveFactory.driver;
    private WebDriverWait wait;
    

    public LoginSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    
    LoginPage home = new LoginPage(driver, wait);


    @Dado("^que acesso o site$")
	public void queAcessoOSite() throws Throwable {
    	home.homePageIsDisplayed();

	}

	@Quando("^efetuo o login com usuario \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void efetuoOLoginComUsuarioESenha(String usuario, String senha) throws Throwable {
		home.realizarLogin(usuario, senha);
	}

	@Entao("^valido a mensagem \"([^\"]*)\" na tela de login$")
	public void valido_a_mensagem_na_tela_de_login(String mensagem) throws Throwable {
		home.errorLogin(mensagem);
		home.confirmClick();

	}
}