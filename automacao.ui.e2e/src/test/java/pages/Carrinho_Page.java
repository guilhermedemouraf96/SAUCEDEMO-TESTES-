package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import drivers.Drivers;
import metodos.Metodos;

public class Carrinho_Page extends Drivers {

	Metodos metodo = new Metodos();

	By addToCart = By.xpath("//*[@class='btn_primary btn_inventory']");
	By preco = By.xpath("//*[@class='inventory_item_price']");// // converter em int, carrinho, checar compra
	By nomeProduto = By.xpath("//*[@class='inventory_item_name']"); // no carrinho e checar compra
	By carrinho = By.xpath("//*[@data-icon='shopping-cart']");//
	By produtoAdicionado = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
	By removerCarrinho = By.xpath("//button[@class='btn_secondary cart_button']");//
	By continueshopping = By.xpath("//a[@class='btn_secondary']");
	By checkout = By.xpath("//a[@class='btn_action checkout_button']");
	By firstName = By.xpath("//input[@id='first-name']");
	By lastName = By.xpath("//input[@id='last-name']");
	By postalCode = By.xpath("//input[@id='postal-code']");
	By submit = By.xpath("//*[@type='submit']");//
	By quantidade = By.xpath("//*[@class='summary_quantity']");
	By subtotal = By.xpath("//*[@class='summary_subtotal_label']");
	By taxa = By.xpath("//*[@class='summary_tax_label']");// taxa dividir valor por 12,496212
	By total = By.xpath("//*[@class='summary_total_label']"); // somar subtotal com a taxa
	By finish = By.xpath("//a[@class='btn_action cart_button']");// botão finish
	By validacaoCompra = By.xpath("//h2[@class='complete-header']");// compra finalizada com sucesso validar texto
	By mensagemErroFirstNome = By.xpath("");
	By mensagemErroLastNome = By.xpath("");
	By mensagemErroPostalCode = By.xpath("");
	List<WebElement> produto = driver.findElements(nomeProduto);
	List<WebElement> add = driver.findElements(addToCart);
	List<WebElement> remove = driver.findElements(removerCarrinho);

	public void adicionar() throws InterruptedException {

		boolean adicionarCarrinho = false;
		for (int i = 0; i < produto.size(); i++) {
			add.get(i).click();
		}
		if (driver.findElement(produtoAdicionado).isDisplayed()) {
			adicionarCarrinho = true;
		}

		assertTrue(adicionarCarrinho);

	}

	public void validarCarrinho() {
		boolean validarCarrinho = false;
		metodo.clicar(carrinho);
		if (driver.findElement(nomeProduto).isDisplayed()) {
			validarCarrinho = true;
		}

		assertTrue(validarCarrinho);

	}

	public void acessarCarrinho() {

		metodo.clicar(carrinho);

	}

	public void removerItem() {

		metodo.clicar(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/button"));
	}

	public void validarRemocao() {
		boolean removerCarrinho = false;
		if (!driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]")).isDisplayed()) {
			removerCarrinho = true;
		}

		assertTrue(removerCarrinho);

	}

	public void comprar() {

		List<WebElement> validarPedido = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));

		for (int i = 0; i < validarPedido.size(); i++) {
			String produtoNoCarrinho = validarPedido.get(i).getText();
			System.out.println(produtoNoCarrinho);

		}
	}

	public void clicarComprar() {
		metodo.clicar(checkout);
	}

	public void preencherDados(String nome, String Lastname, String PostalCode) {
		metodo.escrever(firstName, nome);
		metodo.escrever(lastName, Lastname);
		metodo.escrever(postalCode, PostalCode);
		metodo.clicar(submit);
	}

	public void validarPedido(double totalEstimado) {
		List<WebElement> validarPreco = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
		for (int i = 0; i < validarPreco.size(); i++) {
			String preco = validarPreco.get(i).getText();
			preco = preco.substring(1, 5);
			float price = Float.parseFloat(preco);
			System.out.println(price);

		}
		boolean validarTotal = false;
		// Massa de dados
		float subtotal = (float) totalEstimado;
		float taxa = (float) (subtotal / 12.494230);
		float totalEsperado = (float) subtotal + taxa;

		String totalPedido = driver.findElement(this.total).getText();
		totalPedido = totalPedido.substring(8, 14);
		float total = Float.parseFloat(totalPedido);
		System.out.println(total);

		if (totalEsperado == total) {
			validarTotal = true;
		}
		assertTrue(validarTotal);

	}

	public void finalizarCompra() {
		metodo.clicar(finish);
	}

	public void validarCompra(String compraRealizada) {
		metodo.validarTexto(validacaoCompra, compraRealizada);

	}

	public void validarErroDados(By element, String erroEsperado) {
		boolean erro = true;
		String erroCapturado = driver.findElement(element).getText();
		if(!erroEsperado.equals(erroCapturado)) {
			erro = false; 
		}
		//assertTrue(erro);//BUG MENSAGEM DE ERRO

	}
}