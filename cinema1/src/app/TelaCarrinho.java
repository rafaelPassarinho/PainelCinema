package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCarrinho extends JFrame {
	private ArrayList <Filme> listaDeFilmes =  null;
	private ArrayList <Item> listaDeItens =  null;
	private ArrayList <Produto> listaCarrinho = null;
    private Cinema cinema;
	private double total = 0.0;
	private String NomeCliente, CPF;
    
	private JPanel contentPane;

	/**
	 * Lança a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarrinho frame = new TelaCarrinho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a Tela.
	 */
	
	public TelaCarrinho() {
		setResizable(false);
		setTitle("CARRRINHO");
		cinema = Cinema.getInstance();
		listaDeFilmes = cinema.getFilmes();
		listaDeItens = cinema.getItens();
		listaCarrinho = new ArrayList<Produto>();
		
		
		setTitle("Carrinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilmes = new JLabel("Filmes:");
		lblFilmes.setBounds(12, 12, 66, 15);
		contentPane.add(lblFilmes);
	
		JComboBox<Filme> comboBoxFilmes = new JComboBox<Filme>();
		comboBoxFilmes.setModel(new DefaultComboBoxModel<Filme>(listaDeFilmes.toArray(new Filme[0])));
		comboBoxFilmes.setBounds(68, 7, 270, 24);
		contentPane.add(comboBoxFilmes);
		
		JLabel lblNewLabel = new JLabel("Itens:");
		lblNewLabel.setBounds(356, 12, 66, 15);
		contentPane.add(lblNewLabel);
		
		JComboBox<Item> comboBoxItens = new JComboBox<Item>();
		comboBoxItens.setModel(new DefaultComboBoxModel<Item>(listaDeItens.toArray(new Item[0])));;
		comboBoxItens.setBounds(415, 7, 185, 24);
		contentPane.add(comboBoxItens);
		
		JButton btnFecharPedido = new JButton("Fechar Carrinho");
		btnFecharPedido.addActionListener(new ActionListener() {
			//ADICIONA AÇÃO AO BOTÃO FECHAR CARRINHO
			public void actionPerformed(ActionEvent arg0) {
				String compras = "";
				for(int i =0; i< listaCarrinho.size(); i++)
			        compras += ((listaCarrinho.get(i)).getName()) + " " +"R$"+((listaCarrinho.get(i)).getPreco())+ "\n";
				if(JOptionPane.showConfirmDialog(null,"Lista de compras:\n"+compras+"\nCerteza que deseja fechar o carrinho?",null, JOptionPane.OK_CANCEL_OPTION) == 0) {
					try{	
						if(total == 0.0) throw new EmptyShoppingCartException("Carrinho Vazio !");
						
						String recibo = Arquivo.FecharCompra(cinema.getName(), cinema.getContato(), NomeCliente,CPF, total, listaCarrinho);
						JOptionPane.showMessageDialog(null, recibo, "RECIBO", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(EmptyShoppingCartException ece){
			        	JOptionPane.showMessageDialog(null, ece.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			        }
					finally{
						System.exit(0);
					}
					
				}
			}
		});
		btnFecharPedido.setBounds(331, 175, 143, 25);
		contentPane.add(btnFecharPedido);
		
		JLabel label = new JLabel("00.00");
		label.setBounds(68, 180, 66, 15);
		contentPane.add(label);
		
		JButton btnAdicionarFilmeAo = new JButton("Adicionar Ingresso");
		btnAdicionarFilmeAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBoxFilmes.getSelectedIndex();
				total += (listaDeFilmes.get(index)).getPreco();
				listaCarrinho.add( (listaDeFilmes.get(index)));
				String s = Double.toString(total);
				label.setText(s);
			}
		});
		btnAdicionarFilmeAo.setBounds(178, 119, 160, 25);
		contentPane.add(btnAdicionarFilmeAo);
		
		JButton btnAdicionarItem = new JButton("Adicionar Item");
		btnAdicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBoxItens.getSelectedIndex();
				total += (listaDeItens.get(index)).getPreco();
				listaCarrinho.add( (listaDeItens.get(index)));
				String s = Double.toString(total);
				label.setText(s);
			}
		});
		btnAdicionarItem.setBounds(458, 119, 143, 25);
		contentPane.add(btnAdicionarItem);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(12, 180, 66, 15);
		contentPane.add(lblTotal);
		
		JLabel lblR = new JLabel("R$");
		lblR.setBounds(112, 180, 66, 15);
		contentPane.add(lblR);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(486, 175, 114, 25);
		contentPane.add(btnCancelar);
		
		JButton btnRemoverItem = new JButton("Remover Ultimo Item");
		//ADICIONA AÇÃO AO BOTÃO REMOVER ITEM
		btnRemoverItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(total==0)throw new EmptyShoppingCartException("Carrinho vazio!");
					total-=(listaCarrinho.get(listaCarrinho.size()-1)).getPreco();
					listaCarrinho.remove(listaCarrinho.size()-1);
					String s = Double.toString(total);
					label.setText(s);
					
				}catch(EmptyShoppingCartException esc){
					JOptionPane.showMessageDialog(null, esc.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemoverItem.setBounds(141, 175, 178, 25);
		contentPane.add(btnRemoverItem);
	}
	public void setCliente(String name, String cpf){
		NomeCliente = name;
		CPF = cpf;
	}
	
}
