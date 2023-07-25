package com.example.builder;

import com.example.page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder { // Aqui esta a classe Produto builder

    // Aqui todos os atributos tem que ser private pq não podem ser altarados diretamente na propiedade e sim ser chamado pelo metodo. 
    private String codigo = "0001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "20/07/2023";

    private ControleDeProdutoPO controleDeProdutoPO;

    //**Construtor do ProdutoBuilder que recebe a pagina de controle de produtos. */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Metodo que sabe adicionar um código ao builder.
     * @param codigo    Código que será adicionado.
     * @return          Retorna a própia classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
     * Metodo que sabe adicionar um nome ao builder.
     * @param nome      Nome que será adicionado.
     * @return          Retorna a própia classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Metodo que sabe adicionar um quantidade ao builder.
     * @param quantidade      Quantidade que será adicionado.
     * @return                Retorna a própia classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Metodo que sabe adicionar um valor ao builder.
     * @param valor      Valor que será adicionado.
     * @return           Retorna a própia classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
     * Metodo que sabe adicionar um data ao builder.
     * @param data       Data que será adicionada.
     * @return           Retorna a própia classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Metodo que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto
     */
    public void builder(){  // Esse metodo vai saber construir um produto e toda a lógica vai ficar aqui dentro.

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");  
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");            
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();

    }
    
}
