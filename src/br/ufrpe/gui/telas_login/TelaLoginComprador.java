package br.ufrpe.gui.telas_login;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
<<<<<<< HEAD:src/br/ufrpe/gui/telas_login/TelaLoginComprador.java
import javax.swing.JPanel;
=======
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
>>>>>>> origin/master:src/br/ufrpe/gui/telas_principais/TelaLoginComprador.java
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class TelaLoginComprador {
	private JFrame frame;
<<<<<<< HEAD:src/br/ufrpe/gui/telas_login/TelaLoginComprador.java
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
	private JButton btnVoltar;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginComprador window = new TelaLoginComprador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

=======
	private JTextField textField_User;
	private JPasswordField passwordField;
	private TelaComprador telaComprador;
	private Fachada fachada;
	private Comprador comprador;
	
>>>>>>> origin/master:src/br/ufrpe/gui/telas_principais/TelaLoginComprador.java
	/**
	 * Create the application.
	 */
	public TelaLoginComprador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
<<<<<<< HEAD:src/br/ufrpe/gui/telas_login/TelaLoginComprador.java
		frame.setBounds(100, 100, 450, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 444, 199);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVendedor = new JLabel("Comprador");
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendedor.setBounds(160, 46, 121, 21);
		panel.add(lblVendedor);
		lblVendedor.setFont(new Font("Gisha", Font.BOLD, 18));
		
		btnEntrar = new JButton(" Entrar");
		btnEntrar.setBounds(239, 158, 71, 25);
		panel.add(btnEntrar);
		btnEntrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnVoltar = new JButton("Voltar ");
		btnVoltar.setBounds(122, 158, 71, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(74, 88, 48, 17);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
=======
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel lblVendedor = new JLabel("Comprador");
		lblVendedor.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		lblVendedor.setBounds(173, 31, 89, 31);
		panel.add(lblVendedor);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(87, 84, 50, 14);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblUsurio);
		
		textField_User = new JTextField();
		textField_User.setBounds(143, 81, 200, 23);
		panel.add(textField_User);
		textField_User.setColumns(10);
>>>>>>> origin/master:src/br/ufrpe/gui/telas_principais/TelaLoginComprador.java
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(74, 116, 38, 17);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
<<<<<<< HEAD:src/br/ufrpe/gui/telas_login/TelaLoginComprador.java
		
		textField = new JTextField();
		textField.setBounds(150, 87, 182, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 115, 182, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
=======
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 117, 200, 23);
		panel.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(254, 164, 89, 23);
		btnEntrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnEntrar);
		
		//liga btn entrar
		fachada = new Fachada();
		comprador = new Comprador();
		EventoBotaoEntrar acaoBtnEntrar = new EventoBotaoEntrar();
		btnEntrar.addActionListener(acaoBtnEntrar);
		
		JButton btnVoltar = new JButton("Voltar ");
		btnVoltar.setBounds(143, 164, 89, 23);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnVoltar);
		
		//liga botao voltar
		EventoBotaoVoltar acaoBtnVoltar = new EventoBotaoVoltar();
		btnVoltar.addActionListener(acaoBtnVoltar);
	}
	
	public void setVisible(boolean opcao) {
		if(opcao == true)
			frame.setVisible(opcao);
		else
			frame.setVisible(opcao);
	}
	
	private class EventoBotaoEntrar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			try {
				String senha = new String(passwordField.getPassword());
				
				comprador = fachada.verificarLoginComprador(textField_User.getText(), senha); //obs aqui
				telaComprador.setVisible(true);
				
				//mensagem boas vindas
				JOptionPane.showMessageDialog(null, "Bem vindo, " + textField_User.getText() + "!");
				textField_User.setText("");
				passwordField.setText("");
				frame.dispose(); //volta p/ tela inicio
				
			} catch(NaoEncontradoCompradorException e) {
				JOptionPane.showMessageDialog(null, "Comprador não encontrado! Tente novamente.");
				textField_User.setText("");
				passwordField.setText("");
			} catch(SenhaIncorretaException e) {
				JOptionPane.showMessageDialog(null, "Senha incorreta! Tente novamente.");
				passwordField.setText("");
			}
		}
	}
	
	private class EventoBotaoVoltar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frame.setVisible(false);
		}
	}
>>>>>>> origin/master:src/br/ufrpe/gui/telas_principais/TelaLoginComprador.java
}
