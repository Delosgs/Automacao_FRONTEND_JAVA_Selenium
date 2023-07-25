package com.example.test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.page.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //*Aqui eu falo que meus testes vão seguir a ordem padrão crescente */
public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com.br/"); /** A URL do google foi passada aqui pq ele é um teste epecifico */
        googlePage = new GooglePO(driver);

    }
    
    @Test
    public void TC001_pesquisaNoGoogleTexto(){
        

        googlePage.pesquisar("Batata frita");                       /** Aqui eu uso o metodo "pesquisa"  que esta em "pages/GogglePO" */
        String resultado = googlePage.obterResultadoDaPesquisa();         /** Aqui eu crio a variavel resultado que é uma String e ela vai trazer o texto da pesquisa que esta em "pages/GogglePO"  */
        assertTrue(resultado, resultado.contains("Aproximadamente"));   /*Aqui eu verifico se o texto da variavel resultado de cima é o esperado */
        
    }

     @Test
    public void TC002_pesquisaNoGoogleTexto(){
        

        googlePage.pesquisar("Teste QA");
        String resultado = googlePage.obterResultadoDaPesquisa();       
        assertTrue(resultado, resultado.contains("resultados"));         /*Aqui eu verifico se o texto da variavel resultado de cima é o esperado */
        
    }

}
