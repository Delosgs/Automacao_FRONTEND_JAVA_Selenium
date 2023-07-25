package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.page.GooglePO;
import com.example.page.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //*Aqui eu falo que meus testes vão seguir a ordem padrão crescente */
public class LoginTest extends BaseTest{

    private static LoginPO loginPage;

    /*** Esse metodo recebe duas Strings como parametros que são usadas nos três testes.  */
    private void executarAcaoDeLogar(String email, String senha){

        loginPage.escrever(loginPage.inputEmail, email);
        loginPage.escrever(loginPage.inputSenha, senha);

        loginPage.buttonSenha.click();

    }

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);

    }
    
    @Test
    public void TC001_testandoLoginComEmailSenhaVazia_01(){
        
        /** Aqui é utra forma de inserir dados */
        executarAcaoDeLogar("", "");              // Usa essa linha quando o metodo executarAcaoDeLogar estiver aqui no teste.

        //loginPage.executarAcaoDeLogar("", "");              // Usa essa linha quando o metodo executarAcaoDeLogar estiver em Pages LoginPO.

        String mensagem = loginPage.obterMensagem();

        /** Essa linha verifica se a mensagem do getText retornada é igual a mensagem escrita. */
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
        
    }

    @Test
    public void TC002_testandoLoginComEmailSenhaVazia_02(){
        
        /** Aqui é utra forma de inserir dados */
        //executarAcaoDeLogar("", "");                       // Usa essa linha quando o metodo executarAcaoDeLogar estiver aqui no teste.

        loginPage.executarAcaoDeLogar("", "");   // Usa essa linha quando o metodo executarAcaoDeLogar estiver em Pages LoginPO.

        String mensagem = loginPage.obterMensagem();

        /** Essa linha verifica se a mensagem do getText retornada é igual a mensagem escrita. */
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
        
    }
    @Test
    public void TC003_testandoLoginComEmailErradoSenhaVazia(){
        
        /** Aqui é utra forma de inserir dados */
        loginPage.escrever(loginPage.inputEmail, "EmailErrada@teste.com");
        loginPage.escrever(loginPage.inputSenha, "");

        loginPage.buttonSenha.click();
        String mensagem = loginPage.obterMensagem();

        /** Essa linha verifica se a mensagem do getText retornada é igual a mensagem escrita. */
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
        
    }

    @Test
    public void TC004_testandoLoginComEmailVazioSenhaErrada(){
                
        /** Aqui é utra forma de inserir dados */
        loginPage.inputEmail.sendKeys("");            // Aqui eu estou passando dados vazios.
        loginPage.inputSenha.sendKeys("SenhaErrada");

        loginPage.buttonSenha.click();
        String mensagem = loginPage.obterMensagem();

        /** Essa linha verifica se a mensagem do getText retornada é igual a mensagem escrita. */
        assertEquals(mensagem, "E-mail ou senha inv\u00E1lidos");
        
    }

    @Test
    public void TC005_testandoLoginComEmailESenhaCorreta(){
                
        /** Aqui é utra forma de inserir dados */
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");    // Aqui eu estou passando dados Login e Senha.

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
        
    }

    

}
