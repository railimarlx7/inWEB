package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionariosPage extends BaseClass {

	public FuncionariosPage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	private WebDriverWait wait;

	NovoFuncionarioPage newFunc = new NovoFuncionarioPage(driver, wait);

	@FindBy(css = "li:nth-child(2)")
	@CacheLookup
	protected static WebElement novoFunc;

	@FindBy(css = "input[type=search]")
	@CacheLookup
	protected static WebElement campoBusca;

	@FindBy(css = "#delete-btn")
	@CacheLookup
	protected static WebElement btnDelete;

	@FindBy(css = "a:nth-child(2) > button")
	@CacheLookup
	protected static WebElement btnEdit;

	@FindBy(css = "a.txt2.bo1")
	@CacheLookup
	protected static WebElement returnlogin;

	@FindBy(id = "inputCargo")
	@CacheLookup
	protected static WebElement inputCargo;

	@FindBy(css = "div form > div:nth-child(4)")
	@CacheLookup
	protected static WebElement btnEnviar;

	@FindBy(css = ".alert-success")
	@CacheLookup
	protected static WebElement messageReturn;

	public void pesquisaFuncionario(String nome) {
		campoBusca.click();
		campoBusca.sendKeys(nome);
	}

	public void excluirFuncionario() {
		btnDelete.click();
		}
	
	public void editarCargoFuncionario(String cargo) {
		btnEdit.click();
		inputCargo.clear();
		inputCargo.sendKeys(cargo);
		btnEnviar.click();
	}

	public void buttonNovoFunc() {
		novoFunc.click();
	}

	public void preencherCampoBusca(String busca) {
		campoBusca.clear();
		campoBusca.sendKeys(busca);
	}

	public void buttonDelete() {
		btnDelete.click();
	}

	public static void buttonEdit() {
		btnEdit.click();
	}

	public void pageIsDisplayed() {

		System.out.println("\n" + "Novo Funcionario Page: " + driver.getCurrentUrl());
		
	}

	public void iniciarCadastro() {
		novoFunc.click();
		System.out.println("\n" + "Cadastro: " + driver.getCurrentUrl());
	}

	@SuppressWarnings("static-access")
	public void validaMensagens(String mensagem) {

		if (mensagem.equals(newFunc.textoAlerta)) {
			assertEquals(mensagem, newFunc.textoAlerta);
		} else {
			assertEquals(mensagem, messageReturn.getText());
			System.out.println(messageReturn.getText());
		}

	}

	public void finalizaCadastro() {

	}

}
