package app;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Classe Arquivo é responsavel por lidar com a lida e escrita de arquivos
 */
public class Arquivo{

    /**
   * Método Read
   * É ultilizado para ler um arquivo texto
   * @param caminho caminho que deve ser salvo
   * @throws IOException
   * @throws FileNotFoundException
   * @return retorna o conteudo da leitura
   */
    public static String Read(String caminho){
        String conteudo = "";
        try{
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try{
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex){
                System.out.println( "Erro: Não foi possivel ler o arquivo");
                return "";
            }
        }catch (FileNotFoundException ex){
            System.out.println("Erro: Arquivo não encontrad");
            return "";

        }
    }
    
    /**
   * Método Write
   * É ultilizado para escrever em arquivo um texto.
   * @param caminho caminho que deve ser salvo
   * @param texto texto que deve ser escrito
   * @throws IOException
   * @return true caso der certo, false caso der errado
   */
    public static boolean Write(String caminho, String texto){
        try{
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
     /**
   * Método FecharCompra
   * É ultilizado para receber os dados da compra, salvar a compra do cliente,
   * emitir um recibo em arquivo txt e ler esse arquivo posteriomente retorna-lo.
   * @param nomeCinema nome do cinema
   * @param contatoCInema contado do cinema
   * @param nomeCliente nome do cliente que está usando o serviço
   * @param CPF CPF do cliente usando o serviço
   * @param Total total da compra
   * @param produto uma lista de produtos pedidos pelo cliente
   * @return Recibo do cliente
   */
    public static String FecharCompra(String nomeCinema, String contatoCinema,String nomeCliente, String cpf, Double total, ArrayList<Produto> produto){
        String compras = "";

        //junta os produtos solicitador em uma string compras
        for(int i =0; i< produto.size(); i++){
            compras += ((produto.get(i)).getName()) + " " +"R$"+((produto.get(i)).getPreco())+ "\n";
        }

        //Recibo será o modelo do recibo emitido da compra
        String recibo = 
        "------------Cupom de compra------------\n"+
        "Dados do cinema\n"+
        nomeCinema+"\n"+
        contatoCinema+"\n\n"+
        "Dados da compra\n"+
        compras+"\n"+
        "Dados do comprador\n"+
        "Comprador: "+nomeCliente+"\n"+
        "CPF: "+cpf+"\n\n"+
        "Total: R$"+total+"\n"+
        "---------------------------------------\n";

        //Escrevo o recibo em um arquivo txt
        if(Write("recibo.txt", recibo))
            JOptionPane.showMessageDialog(null, "RECIBO SALVO!","",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR O ARQUIVO!!","",JOptionPane.ERROR_MESSAGE);
           
        //Leio o recibo salvo
        String lerRecibo = Read("recibo.txt");
            
        if(lerRecibo.isEmpty())
            System.out.println("Erro ao ler o arquivo");
        else
            return lerRecibo;
        
        return "Erro";
    }
}