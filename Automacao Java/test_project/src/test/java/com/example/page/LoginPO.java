package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Aqui eu faço uma herança do arquivo "BasePO" */
public class LoginPO extends BasePO{  
    
    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonSenha;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;
    //#endregion Região dos WebElements

    /**
     * Construtor padrão para criação de uma nova página de login.
     * @param driver  Driver da pagina de login.
     */
    public LoginPO(WebDriver driver) {    /** Aqui é o metodo construtor */
        super(driver);
    }
    /**
     * Metodo que obtem a mensagem disparada na tela
     * @return  Texto da mensagem.
     */
    public String obterMensagem(){
        return spanMensagem.getText();
    }

    
    /**
     * Metodo que tentar executar a ação de logar no sistema.
     * @param email     Email para tentativa de login
     * @param senha     Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonSenha.click();
    }
   
    
}
