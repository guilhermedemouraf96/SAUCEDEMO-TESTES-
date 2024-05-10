package pages;

import org.openqa.selenium.By;

import metodos.Metodos;

public class Login_Page{

	Metodos metodo = new Metodos();
	By username = By.name("user-name");
	By password = By.name("password"); 
	By botaoLogin = By.id("login-button");
	By msgErro = By.xpath("//h3[@data-test='error']");
	
	
	
	public void preencherUsuario(String user) {
	
		metodo.escrever(this.username, user);
	}
	public void preencherSenha(String password) {
		metodo.escrever(this.password, password);
		
	}
	public void botaoLogin() {
		metodo.clicar(this.botaoLogin);
		
	}
	public void validarLoja(String urlEsperada) {
		metodo.validarUrl(urlEsperada);
	}
	public void validarErro(String mensagem) {
		metodo.validarTexto(this.msgErro, mensagem);
	}
	
}

