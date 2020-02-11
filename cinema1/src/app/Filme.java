package app;


/**
 * Filme é um objeto ultizado para definir um produto que será comecializado no cinema
 */
public class Filme extends Produto{
    private String horario;
    
    /**
   * Construtor de Filme do tipo produto
   * É ultilizado criar um objeto filme
   * @param nome nome do filme
   * @param preco preço do filme
   * @param horario horario do filme
   */
    public Filme(String name, double preco, String horario){
        super(name,preco);
        this.horario=horario;
    }

    //retorna o preco do filme
    public double getPreco(){
        return super.getPreco();
    }

    //retorna o nome do filme
    public String getNome(){
        return super.getName();
    }

    //retorna o horario do filme
    public String getHorario() {
        return this.horario;
    }

    //retorna todos os atributos associado ao um filme
    public String toString() {
        return name+" - "+horario+" - "+"R$"+preco;
    }



}