package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriveFactory;
import core.PropertiesReader;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.FuncionariosPage;
import pageObjects.NovoFuncionarioPage;

public class FuncionarioSteps {

	private WebDriver driver = DriveFactory.driver;
	private WebDriverWait wait;

	public FuncionarioSteps() throws Exception {

		PropertiesReader propertiesReader = new PropertiesReader();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}

	FuncionariosPage func = new FuncionariosPage(driver, wait);
	NovoFuncionarioPage newFunc = new NovoFuncionarioPage(driver, wait);

	@Dado("^acesso a pagina de cadastro funcionarios\\.$")
	public void acessoAPaginaDeCadastroFuncionarios() throws Throwable {
		func.pageIsDisplayed();
		func.iniciarCadastro();
	}
	
	@Dado("^acesso a pagina de funcionarios\\.$")
	public void acessoAPaginaDeFuncionarios() throws Throwable {
		func.pageIsDisplayed();
	}

	@Quando("^preencho os  campos Nome: \"([^\"]*)\" Cargo \"([^\"]*)\"$")
	public void preenchoOsCamposNomeCargo(String nome, String cargo) throws Throwable {
		newFunc.preencherNomeCargo(nome, cargo);

	}

	@Quando("^os  campos CPF: \"([^\"]*)\" Salario \"([^\"]*)\"$")
	public void osCamposCPFSalario(String cpf, String salario) throws Throwable {
		newFunc.preencherCpfSalario(cpf, salario);
	}

	@Quando("^os  campos Sexo: \"([^\"]*)\" Admissão \"([^\"]*)\"$")
	public void osCamposSexoAdmissao(String sexo, String admissao) throws Throwable {
		newFunc.preencherSexoAdimissao(sexo, admissao);
	}

	@Quando("^Tipo de Contratacao: \"([^\"]*)\"$")
	public void tipoDeContratacao(String tipo) throws Throwable {
		newFunc.selecionaTipoContrato(tipo);
	}

	@Entao("^valido a mensagem \"([^\"]*)\" na tela$")
	public void validoAMensagemNaTela(String mensagem) throws Throwable {
		func.validaMensagens(mensagem);
	}

	@Quando("^pesquiso um colaborador pelo nome\"([^\"]*)\" cadastrado$")
	public void pesquisoUmColaboradorPeloNomeCadastrado(String nome) throws Throwable {
		func.pesquisaFuncionario(nome);

	}

	@Quando("^altero o cargo \"([^\"]*)\"$")
	public void alteroOCargo(String cargo) throws Throwable {
	func.editarCargoFuncionario(cargo);
	}
	
	@Quando("^removo o colaborador$")
	public void removoOColaborador() throws Throwable {
	  func.excluirFuncionario();
	}

}