package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;

public class TelaInicial {

	private JFrame frmTelaInicial;
	private JTextField textFieldNome;

	/**
	 * Lança a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmTelaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a aplicação.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Inicializa o conteudo do frame.
	 */
	private void initialize(){
		try {
			frmTelaInicial = new JFrame();
			frmTelaInicial.setResizable(false);
			frmTelaInicial.setTitle("Tela Inicial");
			frmTelaInicial.setBounds(100, 100, 450, 201);
			frmTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmTelaInicial.getContentPane().setLayout(null);
			
			JButton btnEncerrar = new JButton("ENCERRAR");
			btnEncerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnEncerrar.setBounds(314, 139, 114, 25);
			frmTelaInicial.getContentPane().add(btnEncerrar);
			
			JFormattedTextField ftfCpf;
			ftfCpf = new JFormattedTextField(new MaskFormatter( "###.###.###-##"));
			ftfCpf.setBounds(51, 40, 124, 19);
			frmTelaInicial.getContentPane().add(ftfCpf);
			JButton btnLogin = new JButton("LOGIN");
			/**
			 * Esse actionPerformed do botão LOGIN lê as caixas de texto e cria um cliente c e
			 * abre uma nova tela referente a carrinho
			 */
			btnLogin.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					String nome = textFieldNome.getText();
					String cpf = ftfCpf.getText();
					
					
					
					Cliente c = new Cliente(nome, cpf);
					frmTelaInicial.dispose();
					c.addCarrinho();
				}
			});
			btnLogin.setBounds(188, 139, 114, 25);
			frmTelaInicial.getContentPane().add(btnLogin);
		
			JLabel lblNomeCompleto = new JLabel("Nome Completo:");
			lblNomeCompleto.setBounds(12, 12, 124, 15);
			frmTelaInicial.getContentPane().add(lblNomeCompleto);
		
			textFieldNome = new JTextField();
			textFieldNome.setBounds(136, 10, 292, 19);
			frmTelaInicial.getContentPane().add(textFieldNome);
			textFieldNome.setColumns(10);
		
			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(12, 42, 66, 15);
			frmTelaInicial.getContentPane().add(lblCpf);
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
