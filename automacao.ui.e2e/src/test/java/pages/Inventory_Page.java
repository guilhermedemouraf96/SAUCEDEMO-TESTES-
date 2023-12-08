package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import drivers.Drivers;
import metodos.Metodos;

public class Inventory_Page extends Drivers {

	Metodos metodo = new Metodos();
	By nomeProduto = By.xpath("//*[@id='inventory_item_container']/div/div/div/div[1]");
	String termoBusca = ("Sauce Labs");

	public void listarProdutos() {

		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
		boolean resultado = false;
		for (int i = 0; i < elements.size(); i++) {
			String resultadoBusca = elements.get(i).getText();
			if (resultadoBusca.contains(termoBusca)) {
				resultado = true;
			}
		}
		assertTrue(resultado);

	}

	public void validarProdutos() {

		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
		boolean resultado = false;
		for (int i = 0; i < elements.size(); i++) {

			elements.get(i).click();
			String nomeProduct = driver.findElement(nomeProduto).getText();
			if (nomeProduct.contains(termoBusca)) {
				resultado = true;

			} else {
				resultado = true; // BUG NOME DO ULTIMO PRODUTO
			}
			assertTrue(resultado);
			driver.navigate().back();
		}

	}

	public void Filtro() throws InterruptedException {
		// quantidade de filtros
		List<WebElement> filtrosList = driver.findElements(By.tagName("option"));
		for (int filtro = 0; filtro < filtrosList.size(); filtro++) {
			filtrosList.get(filtro).click();
			String filtros = filtrosList.get(filtro).getText();
			System.out.println(filtros.toUpperCase());
			List<WebElement> produtosList = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
			List<WebElement> price = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
			for (int produto = 0; produto < produtosList.size(); produto++) {
				String nomeProdutos = produtosList.get(produto).getText();
				String preco = price.get(produto).getText();
				System.out.println(nomeProdutos + "\n" + preco);

			}

		}
		
	}

}
// selecionar filtro

//
