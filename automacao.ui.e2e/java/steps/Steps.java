package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import pages.Login_Page;

public class Steps {

	Login_Page login = new Login_Page();
	Metodos metodo = new Metodos();
	By username = By.xpath("//input[@id='user-name']");

	@When("preencho com credenciais validas")
	public void preencho_com_credenciais_validas() throws InterruptedException {
		metodo.abrirNavegador();
		metodo.escrever(username,"test");
		Thread.sleep(2000);
		login.preencherUsuario();
		login.preencherSenha("secret_sauce");
		login.botaoLogin();

	}

	@Then("acesso a pagina da loja")
	public void acesso_a_pagina_da_loja() {
		login.validarLoja("https://www.saucedemo.com/v1/inventory.html");

	}

	@Given("preencho com credenciais invalidas")
	public void preencho_com_credenciais_invalidas() {
		login.preencherUsuario();
		login.preencherSenha("secret_s");
		login.botaoLogin();
	}

	@Then("visualizo mensagem de erro")
	public void visualizo_mensagem_de_erro() {
		login.validarErro("Epic sadface: Username and password do not match any user in this service");

	}

	@Given("preencho com credenciais bloqueados")
	public void preencho_com_credenciais_bloqueados() {
		login.preencherUsuario();
		login.preencherSenha("secret_sauce");
		login.botaoLogin();
	}

	@Then("visualizo mensagem de bloqueio de usuario")
	public void visualizo_mensagem_de_bloqueio_de_usuario() {
		login.validarErro("Epic sadface: Sorry, this user has been locked out.");

	}

	@Given("não preencho os campos")
	public void não_preencho_os_campos() {
		login.botaoLogin();

	}

	@Then("visualizo mensagem de dados em branco")
	public void visualizo_mensagem_de_dados_em_branco() {
		login.validarErro("Epic sadface: Username is required");
	}

	@When("preencho campo usuario valido")
	public void preencho_campo_usuario_valido() {
		login.preencherUsuario();

	}

	@When("não preencho campo senha")
	public void não_preencho_campo_senha() {
		login.botaoLogin();

	}

	@Then("visualizo mensagem erro campo senha em branco")
	public void visualizo_mensagem_erro_campo_senha_em_branco() {
		login.validarErro("Epic sadface: Password is required");

	}

}
