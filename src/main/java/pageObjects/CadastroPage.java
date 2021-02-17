package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseClass;

public class CadastroPage extends BaseClass {

	public CadastroPage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	private WebDriverWait wait;

	@FindBy(name = "username")
	@CacheLookup
	protected static WebElement username;

	@FindBy(name = "pass")
	@CacheLookup
	protected static WebElement pass;

	@FindBy(name = "confirmpass")
	@CacheLookup
	protected static WebElement confirmpass;

	@FindBy(css = "button.login100-form-btn")
	@CacheLookup
	protected static WebElement btnCadastrar;

	@FindBy(css = "a.txt2.bo1")
	@CacheLookup
	protected static WebElement returnlogin;

	@FindBy(css = "div:nth-child(5) > span > div")
	@CacheLookup
	protected static WebElement senhaNaoCombina;

	@FindBy(css = "div.p-t-10.p-b-1 > span > div")
	@CacheLookup
	protected static WebElement userCadastrado;

	public void returnLogin() {

		// WebElement elemento = returnlogin;
//		wait.until(ExpectedConditions.textToBe((By) elemento, "Login"));

	}

	public void preencherCampoUsuario(String usuario) {
		username.clear();
		username.sendKeys(usuario);
	}

	public void preencherCampoSenha(String senha) {
		pass.clear();
		pass.sendKeys(senha);
	}

	public void preencherCampoConfimeSenha(String confimeSenha) {
		confirmpass.clear();
		confirmpass.sendKeys(confimeSenha);
	}

	public static void buttonCadastrar() {
		btnCadastrar.click();

	}

	public void entrarCadastro() {
		LoginPage home = new LoginPage(driver, wait);
		home.entrarCadastro();

	}

	public void realizarCadastro(String usuario, String senha, String confimeSenha) {

		preencherCampoUsuario(usuario);
		preencherCampoSenha(senha);
		preencherCampoConfimeSenha(confimeSenha);
		buttonCadastrar();

	}

	public void validaMensagens(String mensagem) {
		if (senhaNaoCombina.getText().equals(mensagem)) {
			assertEquals(mensagem, senhaNaoCombina.getText());
		} else {
			assertEquals(mensagem, userCadastrado.getText());
		}
	}

	public void finalizaCadastro() {
		if (driver.getCurrentUrl().equals("https://inm-test-app.herokuapp.com/accounts/login/")) {
			System.out.println("Cadastro Realizado");
		} else {
			returnlogin.click();
		}

	}

}
