package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	@CacheLookup
	protected static WebElement username;

	@FindBy(name = "pass")
	@CacheLookup
	protected static WebElement pass;

	@FindBy(css = "button.login100-form-btn")
	@CacheLookup
	protected static WebElement enterButton;

	@FindBy(css = "div div > button")
	@CacheLookup
	protected static WebElement loginButton;

	@FindBy(css = "div.alert-validate")
	@CacheLookup
	protected static WebElement alertaUsuario;

	@FindBy(css = "[href*='signup']")
	@CacheLookup
	protected static WebElement cadastro;

	@FindBy(css =  "div.alert") 
	@CacheLookup
	protected static WebElement erroLogin;

	public void homePageIsDisplayed() {
		System.out.println("\n" + "Home Page: " + driver.getCurrentUrl());

	}

	public void preencherCampoUsuario(String usuario) {

		username.clear();
		username.sendKeys(usuario);

	}

	public static void preencherCampoSenha(String senha) {

		pass.clear();
		pass.sendKeys(senha);
	}

	public void clicarBotaoEntre() {

		loginButton.click();

	}
	
	public void confirmClick() {
		if (driver.getCurrentUrl().equals("https://inm-test-app.herokuapp.com/empregados/")) {
			System.out.println("\n" + "driver.getCurrentUrl()");
		} else {
			enterButton.click();
		}
	
		
	}

	public void realizarLogin(String usuario, String senha) {
		preencherCampoUsuario(usuario);
		preencherCampoSenha(senha);
		clicarBotaoEntre();
	}

	public void errorLogin(String mensagem) {
	
		assertEquals (mensagem, erroLogin.getText());

	}
	
	
	public void entrarCadastro( ) {
		cadastro.click();
	}

}
