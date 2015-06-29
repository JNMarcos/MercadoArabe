package br.ufrpe.gui.telas_principais;

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

import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class TelaLoginVendedor {

	private JFrame frame;
	private JTextField textField_User;
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
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		lblVendedor.setBounds(173, 31, 74, 31);
		panel.add(lblVendedor);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(87, 84, 50, 14);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblUsurio);
		
		textField_User = new JTextField();
		textField_User.setBounds(143, 81, 200, 23);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(87, 120, 46, 14);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 117, 200, 23);
		panel.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(254, 164, 89, 23);
		btnEntrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnEntrar);
		
		//liga botao entrar
		fachada = new Fachada();
		vendedor = new Vendedor();
		EventoBotaoEntrar acaoBtnEntrar = new EventoBotaoEntrar();
		btnEntrar.addActionListener(acaoBtnEntrar);
		telaVendedor = new TelaVendedor();
		
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
		}
	}
}
