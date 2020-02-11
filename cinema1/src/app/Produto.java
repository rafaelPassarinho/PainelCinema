package app;

/**
 * Produto é uma classe abstrada que será base dos produtos Itens e Filmes
 */
public abstract class Produto{

	protected String name;
    protected double preco;
   
    /**
   * Construtor de Produto
   * É ultilizado criar um produto
   * @param nome nome do produto
   * @param preco preço do produto
   */
    public Produto(String name, double preco){
        this.name =  name;
        this.preco = preco;
    }
    
    //getName retorna o nome do produto
    public String getName() {
        return this.name;
    }

    //getPreco retorna o preco do produto
    public double getPreco() {
        return this.preco;
    }
}