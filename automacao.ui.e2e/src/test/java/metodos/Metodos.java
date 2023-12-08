package metodos;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import drivers.Drivers;

public class Metodos extends Drivers{

	
	
	public void escrever(By elemento, String texto) {

		driver.findElement(elemento).sendKeys(texto);

	}

	public void clicar(By element) {
		driver.findElement(element).click();

	}
	public void submit(By element) {
		driver.findElement(element).submit();
	}

	public void validarUrl(String urlEsperado) {
		String urlCapturado = driver.getCurrentUrl();
		assertEquals(urlEsperado,urlCapturado);
	}

	public void validarTexto(By element, String textoEsperado) {
		String textoCapturado = driver.findElement(element).getText();
		assertEquals(textoEsperado, textoCapturado);
	}
	public void capturarTexto(By element) {
	driver.findElement(element).getText();
		
	}

}
