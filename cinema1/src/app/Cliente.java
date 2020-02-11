package app;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Classe Cliente é responsavel por solicitar os dados do cliente, 
 * podendo solicitar um carrinho de um cinema.
 */
public class Cliente{
    private String name;
    private String CPF;
    private Cinema cinema;
    private double total;

     /**
   * Construtor de Cliente
   * É ultilizado criar um cliente de cinema
   * @param nome nome do filme
   * @param CPF preço do filme
   */
    public Cliente(String name,String CPF){
    	try{
    		if(name.isEmpty()) throw new InvalidArgumentException("O campo Nome não pode estar vazio");
			if(name.matches("(.*)[0-9](.*)")) throw new InvalidArgumentException("O campo Nome não pode conter números");
			if(!(CPF.matches("(.*)[0-9](.*)")) || (CPF.length() != 14)) throw new InvalidArgumentException("CPF Inválido");
    	}
    	catch(InvalidArgumentException iae){
			JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
    	}
    	finally{
    		cinema = Cinema.getInstance();
	        this.name = name;
	        this.CPF = CPF;
    	}
    }

    /**
   * Metodo addCarrinho
   * É ultilizado criar um carrinho associado ao cliente, 
   * chamando uma tela de interação chamado tCarrinho
   * @param nome nome do filme
   * @param CPF preço do filme
   */
    public void addCarrinho(){
    	TelaCarrinho tCarrinho = new TelaCarrinho();
        tCarrinho.setVisible(true);
        tCarrinho.setCliente(name, CPF);
    }

   
    // getName retorna o nome do cliente
    public String getName() {
        return this.name;
    }

    // getCPF retorna o cpf do cliente
    public String getCPF() {
        return this.CPF;
    }
    
}