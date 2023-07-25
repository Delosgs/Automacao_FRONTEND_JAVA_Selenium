package com.example.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


/**
 * Classe base para criação das novas PagesObject.
 * Todas as pages devem ser herdadas desta classe.
 */

public abstract class BasePO {

    /** Driver base que será usado pelas pages */
    protected WebDriver driver;


    /**
     * Construtor base para criação da fabrica de elementos (PageFactory)
     * @param driver Driver da página atual.
     */
    public BasePO(WebDriver driver){         /** Aqui é um metodo construtor padrão que recebe um "Webdriver que eu chamei de driver" e passa o mesmo */
        this.driver = driver;                   /** Aqui e chamo o driver de cima que é usado pelas pages e digo que ele é igual ao de baixo */
        PageFactory.initElements(driver, this); /** Aqui o driver é o de baixo e o this é o driver de cima usado pelas pages*/
    }

    /**
     * Metodo que é uma String e tem que retornar o titulo da pagina atual.
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }

    /**
     * Metodo que sabe escrever em qualquer WebElement do tipo input e da um TAB.
     * @param input   Input a qual sera escrito
     * @param texto   Texto que sera escrito no input
     */
    public void escrever(WebElement input, String texto){
        input.clear();      // Antes de escrever qualquer coisa ele vai limpar o campo.
        input.sendKeys(texto + Keys.TAB);
    }

}
