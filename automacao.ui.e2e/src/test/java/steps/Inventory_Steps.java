package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import pages.Inventory_Page;
import pages.Login_Page;

public class Inventory_Steps {

	Login_Page login = new Login_Page();
	Inventory_Page inventory = new Inventory_Page();
	Metodos metodo = new Metodos();

	By busca = By.xpath("//*[@id=\"__next\"]/main/div/div/div/div/div/div[4]/div[2]/div[4]/div[1]/div");
	By pesquisar = By.xpath("//input[@id='search-form-input']");
	By botaoPesquisa = By.xpath("//button[@data-testid= 'search-form-button']");

	@Given("que esteja logado")
	public void queEstejaLogado() {

		login.preencherUsuario("standard_user");
		login.preencherSenha("secret_sauce");
		login.botaoLogin();
		login.validarLoja("https://www.saucedemo.com/v1/inventory.html");

	}

	@When("busca de produtos")
	public void buscaDeDeProdutos() throws InterruptedException {
		inventory.listarProdutos();

	}

	@Then("valido se corresponde aos produtos pesquisados")
	public void validoSeCorrespondeAosProdutosPesquisados() {
		inventory.validarProdutos();
	}
	@When("clicar em ordenar")
	public void clicar_em_ordenar() throws InterruptedException {
	    inventory.Filtro();
	}

	@Then("valido a ordem dos produtos corresponde a filtro selecionado")
	public void valido_a_ordem_dos_produtos_corresponde_a_filtro_selecionado() {
	    
	}
}
