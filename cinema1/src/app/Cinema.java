package app;

import java.util.ArrayList;

/**
 * Cinema é um objeto que será unico aplicando o padrão de projeto singleton
 */
public class Cinema {
    private ArrayList<Filme> listaDeFilmes = null;
    private ArrayList<Item> listaDeItens = null;
    private String name = "CineINF";
    private String contato = "CineINF@Atendimento.com";
    public static Cinema onlyCinema = null;

        /**
   * Construtor de Cinema
   * É ultilizado criar inicializar o cinema e seus produtos
   */
    private Cinema() {
        listaDeFilmes = new ArrayList<Filme>();
        listaDeItens = new ArrayList<Item>();
        listaDeFilmes.add(new Filme("Procurando Dory 3",15.00,"15:00"));
        listaDeFilmes.add(new Filme("Velozes & Furiosos 15",20.00,"17:00"));
        listaDeFilmes.add(new Filme("Bacurau", 7.00, "18:00"));
        listaDeFilmes.add(new Filme("Joker", 35.00, "22:00"));
        listaDeFilmes.add(new Filme("Aquarius", 7.00, "14:00"));

        listaDeItens.add(new Item("Refrigerente 1L",7.00));
        listaDeItens.add(new Item("Pipoca",10.00));
    }
    
    /**
   * Construtor de Filme do tipo produto
   * É ultilizado para instanciar o cinema, caso ele já não tiver sido instanciado.
   * @return uma instancia de cinema 
   */
    public static synchronized Cinema getInstance() {
        if (onlyCinema == null) {
            onlyCinema = new Cinema();       
        }
        return onlyCinema;
    }

     /**
   * metodo getItens
   * É ultilizado pra solicitar a lista de itens disponiveis no cinema
   * @return retorna uma lista de itens
   */
    public ArrayList<Item> getItens(){
       return listaDeItens;
    }
    
    /**
   * metodo getFilme
   * É ultilizado pra solicitar a lista de filmes disponiveis no cinema
   * @return retorna uma lista de filmes
   */
    public ArrayList<Filme> getFilmes(){
        return listaDeFilmes;
    }

   //getName retorna o nome do cinema
   public String getName() {
    return this.name;
}

//getName retorna o contato do cinema
public String getContato() {
    return this.contato;
}

    

    
}