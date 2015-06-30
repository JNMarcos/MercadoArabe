package br.ufrpe.gui.telas_login;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class TelaLoginVendedor {

	private JFrame frame;

	private JTextField textField_User;
	private JPanel panel;
	private JButton btnVoltar;
	private JButton btnEntrar;
	
	private JPasswordField passwordField;
	private Fachada fachada;
	private Vendedor vendedor;
	private TelaVendedor telaVendedor;


	/**
	 * Create the application.
	 */
	public TelaLoginVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Vendedor");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 226);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 444, 199);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendedor.setBounds(164, 24, 121, 21);
		panel.add(lblVendedor);
		lblVendedor.setFont(new Font("Gisha", Font.BOLD, 18));
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(81, 75, 48, 17);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_User = new JTextField();
		textField_User.setBounds(139, 74, 182, 20);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(81, 103, 38, 17);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 105, 182, 20);
		panel.add(passwordField);
		
		//botoes
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(235, 146, 75, 25);
		panel.add(btnEntrar);
		btnEntrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnVoltar = new JButton("Voltar ");
		btnVoltar.setBounds(150, 146, 75, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		//liga botao entrar
		fachada = new Fachada();
		vendedor = new Vendedor();
		EventoBotaoEntrar acaoBtnEntrar = new EventoBotaoEntrar();
		btnEntrar.addActionListener(acaoBtnEntrar);
		telaVendedor = new TelaVendedor();

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
				
				vendedor = fachada.verificarLoginVendedor(textField_User.getText(), senha); //obs aqui
				telaVendedor.setVisible(true);
				
				//mensagem boas vindas
				JOptionPane.showMessageDialog(null, "Bem vindo, " + textField_User.getText() + "!");
				textField_User.setText("");
				passwordField.setText("");
				frame.dispose(); //volta p/ tela inicio
				
			} catch(NaoEncontradoVendedorException e) {
				JOptionPane.showMessageDialog(null, "Vendedor não encontrado! Tente novamente.");
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
			textField_User.setText("");
			passwordField.setText("");
		}
	}
}
