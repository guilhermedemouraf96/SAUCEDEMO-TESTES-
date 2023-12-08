package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Carrinho_Page;

public class Carrinho_Steps {

	Carrinho_Page carrinho = new Carrinho_Page();

	@When("clico em Add to cart")
	public void clico_em_add_to_cart() throws InterruptedException {
		carrinho.adicionar();

	}

	@Then("visualizo item no carrinho de compras")
	public void visualizo_item_no_carrinho_de_compras() {
		carrinho.validarCarrinho();

	}

	@When("quando clico em Remove")
	public void quando_clico_em_remove() throws InterruptedException {
		carrinho.acessarCarrinho();
		carrinho.removerItem();

	}

	@Then("visualizo item removido do carrinho de compras")
	public void visualizo_item_removido_do_carrinho_de_compras() {
		carrinho.validarRemocao();

	}

	@When("preencho os dados e valido as informações da compra")
	public void preenchoOsDadosEValidoAsInformaçõesDaCompra() {
		carrinho.acessarCarrinho();
		carrinho.comprar();
		carrinho.clicarComprar();
		carrinho.preencherDados("Guil", "Ferreira", "6464646");
		carrinho.validarPedido(129.94);

	}

	@When("clico em finish")
	public void clico_em_finish() {
		carrinho.finalizarCompra();

	}

	@Then("compra realizada com sucesso")
	public void compra_realizada_com_sucesso() {
		carrinho.validarCompra("THANK YOU FOR YOUR ORDER");

	}


	@When("nao preencho os campos obrigatórios")
	public void nao_preencho_os_campos_obrigatórios() {
		carrinho.acessarCarrinho();
		carrinho.clicarComprar();
		carrinho.preencherDados("", "", "");
		carrinho.validarErroDados(By.xpath("//*[@id='checkout_info_container']/div/form/h3"), "Error: First Name is required");
		carrinho.preencherDados("Gui", "", "");
		carrinho.validarErroDados(By.xpath("//*[@id='checkout_info_container']/div/form/h3"), "Error: Last Name is required");
		carrinho.preencherDados("Gui", "Ferreo", "");
		carrinho.validarErroDados(By.xpath("//*[@id='checkout_info_container']/div/form/h3"), "Error: Postal Code is required");

	}

}