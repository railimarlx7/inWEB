package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
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
public class NovoFuncionarioPage extends BaseClass {

	public NovoFuncionarioPage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	private WebDriverWait wait;
	public static String textoAlerta;

	@FindBy(id = "inputNome")
	@CacheLookup
	protected static WebElement inputNome;

	@FindBy(id = "cpf")
	@CacheLookup
	protected static WebElement inputCpf;

	@FindBy(id = "inputCargo")
	@CacheLookup
	protected static WebElement inputCargo;

	@FindBy(id = "dinheiro")
	@CacheLookup
	protected static WebElement inputSalario;

	@FindBy(id = "slctSexo")
	@CacheLookup
	protected static WebElement inputSexo;

	@FindBy(id = "clt")
	@CacheLookup
	protected static WebElement inputClt;

	@FindBy(id = "pj")
	@CacheLookup
	protected static WebElement inputPj;

	@FindBy(id = "inputAdmissao")
	@CacheLookup
	protected static WebElement inputAdimissao;

	@FindBy(css = "div form > div:nth-child(4)")
	@CacheLookup
	protected static WebElement btnEnviar;

	public void preencherNomeCargo(String nome, String cargo) {
		inputNome.sendKeys(nome);
		inputCargo.sendKeys(cargo);
	}

	@SuppressWarnings("static-access")
	public void preencherCpfSalario(String cpf, String salario) {
		inputCpf.sendKeys(cpf);
		inputCpf.sendKeys(Keys.TAB);
		if (cpf.equals("00011199900")) {
			Alert alert = driver.switchTo().alert();
			this.textoAlerta = alert.getText();
			alert.accept();
			inputSalario.sendKeys(salario);
		} else {
			inputSalario.sendKeys(salario);
		}
	}

	public void preencherSexoAdimissao(String sexo, String admissao) {
		inputSexo.sendKeys(sexo);
		inputAdimissao.sendKeys(admissao);
	}

	public void selecionaTipoContrato(String tipo) {
		if (tipo.equals("CLT")) {
			inputClt.click();
			btnEnviar.click();
		} else {
			inputPj.click();
			btnEnviar.click();
		}
	}

	public void cadastrarFunc() {
		btnEnviar.click();

	}

	public void pageIsDisplayed() {

		System.out.println("\n" + "Novo Funcionario Page: " + driver.getCurrentUrl());

	}

	public static String alertaMensagen(String mensagemAlerta) {
		mensagemAlerta = textoAlerta;
		System.out.println(mensagemAlerta);
		return mensagemAlerta;

	}
}
