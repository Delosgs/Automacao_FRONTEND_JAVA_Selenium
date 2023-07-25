package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.builder.ProdutoBuilder;
import com.example.page.ControleDeProdutoPO;
import com.example.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //*Aqui eu falo que meus testes vão seguir a ordem padrão crescente */
public class ControleDeProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);                    // Aqui eu estâncio Login pq eu preciso logar na página primeiro.
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123"); // Aqui eu mando logar

        controleProdutoPage = new ControleDeProdutoPO(driver);  // Aqui eu crio o controller e estâncio Produto
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");  // Aqui eu garanto se o controle de produto esta na tela

    }

    @Test
    public void TC001_abrirModalAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        // TODO: Remover duplo click pq para entrar esta com duplo click
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText(); // Aqui eu crio uma variavel do tipo String e vou comparar em baixo.
        assertEquals("Produto", titulo);  // Aqui eu verifico se a modal apareceu com o titulo esperado.

        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();   // Duplo click para sair na primeira vez


    }

    // @Test
    // public void TC002_deveCadastraProdutosSeClicarNoBotaoCriar(){
    //     controleProdutoPage.buttonAdicionar.click();

    //     controleProdutoPage.cadastrarProduto("001", "Banjo", 2, 1.250, "");

    //     // Aqui vamos capturar a mensagem de erro.

    //     String mensagem = controleProdutoPage.spanMensagem.getText();
    //     assertEquals("Todos os campos são obrigatórios para o cadastro!", "mensagem");  // Aqui eu verifico se a modal apareceu com o titulo esperado.

    // }

    @Test
    public void TC003_deveCadastraProdutosSeClicarNoBotaoCriar(){

        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleProdutoPage.buttonAdicionar.click();
        //controleProdutoPage.buttonAdicionar.click();
               
        // Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        // Aqui realmente ele adiciona as informações na tela. Esse builder é um metodo.
        produtoBuilder
        .adicionarCodigo("")  // Sem codigo aqui
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());  // Aqui eu verifico se a modal apareceu com o titulo esperado.

        produtoBuilder
        .adicionarCodigo("003")
        .adicionarQuantidade(12)
        .adicionarNome("Delano")
        .builder();


        produtoBuilder
        .adicionarCodigo("002")
        .adicionarValor(23.90)
        .builder();


        // Aqui nos vamos testar um produto sem nome
         produtoBuilder
        .adicionarCodigo("002")
        .adicionarNome("")
        .adicionarValor(23.90)
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());  // Aqui eu verifico se a modal apareceu com o titulo esperado.

        // Aqui nos vamos testar um produto sem data
         produtoBuilder
        .adicionarCodigo("002")
        .adicionarValor(23.90)
        .adicionarData("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());  // Aqui eu verifico se a modal apareceu com o titulo esperado.

    }
    
}
