package com.example.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 */
public abstract class BaseTest {             // Uma classe "abstract" não pode ser instanciada somente herdada

    /** Driver do navegador da pagina atual */
    protected static WebDriver driver;       // Esse atributo é protegido e só a classe "BaseTest" o os filhos dela vão poder ver.
    /** Caminho base da URL do sistema a ser testado. */
    private static final String CAMINHO_DRIVER = "src\\test\\java\\com\\example\\resource\\chromedriver.exe"; /* Aqui é o caminho de onde estar o ChromeDrive */
    /** Caminho ralativo do driver ao projeto referente ao path */
    private static final String URL_BASE = "file:///C:/Users/verus/Downloads/controle-de-produtos/sistema/login.html";
             
    /**
     * Metodo para iniciar o driver do navegador antes de qualquer classe de teste.
     */
    @BeforeClass                                                           
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER); /*Aqui é o caminho de onde o meu teste vai encontrar o ChromeDriver */
        driver = new ChromeDriver();                                       /*Aqui eu instancio o meu driver e é nesse momento que o navegador inicia */
        driver.manage().window().maximize();                               /* aqui eu chamo o drive que foi instanciado em cima para aumentar a tela do windows */
        driver.get(URL_BASE);                                              /* Aqui o driver que foi instanciodo pega a URL base  para abrir o navegador */
    }

    /**
     * Metodo para finalizar o driver do navegador depois de qualquer classe de teste.
     */
    @AfterClass                                                          
    public static void finalizar(){
        driver.quit();

    }
}
