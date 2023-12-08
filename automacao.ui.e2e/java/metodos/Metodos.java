package metodos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import drivers.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Metodos extends Drivers {
	
	public void abrirNavegador() {
		String url = "https://www.saucedemo.com/v1/";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		
	}
		public void fecharNavegador() {
			driver.quit();
			
		}
		

	public void escrever(By element, String texto) {
		
		driver.findElement(element).sendKeys(texto);

	}

	public void clicar(By element) {
		driver.findElement(element).click();

	}
	public void validarUrl(String urlEsperado) {
		String urlCapturado = driver.getCurrentUrl();
		assertTrue(urlCapturado.contains(urlEsperado));
	}
	public void validarTexto(By element, String textoEsperado) {
		String textoCapturado = driver.findElement(element).getText();
		assertEquals(textoEsperado, textoCapturado);
	}
} 
