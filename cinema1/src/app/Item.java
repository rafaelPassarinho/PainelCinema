package app;


/**
 * Item é um objeto ultizado para definir um produto que será comecializado no cinema
 */
public class Item extends Produto{
    /**
   * Construtor de Item do tipo produto
   * É ultilizado criar um objeto item
   * @param nome nome do item
   * @param preco preço do item
   */
    public Item(String name, double preco){
        super(name,preco);
    }

    //retorna os atributos do item
    public String toString() {
    	return name+" - "+"R$"+preco;
    }
}