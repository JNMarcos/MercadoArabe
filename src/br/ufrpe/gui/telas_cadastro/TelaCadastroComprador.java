package br.ufrpe.gui.telas_cadastro;

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
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NomeVazioException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;

public class TelaCadastroComprador {

	private JFrame frmCadastroComprador;
	private JTextField textField_User;
	private JTextField textField_Nome;
	private JTextField textField_Email;
	private JPasswordField passwordField;
	private JButton btnCadastrar;
	private Comprador comprador;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroComprador window = new TelaCadastroComprador();
//					window.frmCadastroComprador.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastroComprador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroComprador = new JFrame();
		frmCadastroComprador.setTitle("Cadastro Comprador");
		frmCadastroComprador.getContentPane().setBackground(SystemColor.activeCaption);
		frmCadastroComprador.setBounds(100, 100, 450, 257);
		frmCadastroComprador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroComprador.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 218);
		frmCadastroComprador.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(169, 173, 91, 23);
		btnCadastrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadastrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(22, 27, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_Nome = new JTextField();
		textField_Nome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_Nome.setBounds(88, 24, 269, 20);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(22, 66, 46, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_Email.setBounds(88, 63, 268, 20);
		panel.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(22, 104, 46, 14);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_User = new JTextField();
		textField_User.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_User.setBounds(88, 101, 266, 20);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(22, 141, 46, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 141, 129, 20);
		panel.add(passwordField);

		//add acao ao botao cadastrar
		fachada = new Fachada();
		comprador = new Comprador();
		EventoBotaoCadastrar acaoBtnCadastrar = new EventoBotaoCadastrar();
		btnCadastrar.addActionListener(acaoBtnCadastrar);
	}
	
	public void setVisible(boolean opcao) {
		if(opcao == true)
			frmCadastroComprador.setVisible(true);
		else
			frmCadastroComprador.setVisible(false);
	}
	
	private class EventoBotaoCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			try {
				//nome
				comprador.setNome(textField_Nome.getText());
				
				//senha
				String s = new String(passwordField.getPassword());
				comprador.setSenha(s);
				
				//usuario
				comprador.setNomeUsuario(textField_User.getText());
				
				//precisa-se fazer um campo email pro comprador ou retirar daqui. Campo data de Nascimento em branco.
				
				fachada.cadastrarComprador(comprador); //cadastra
				fachada.salvarComprador();			   //salva
				
				//mensagem boas vindas
				JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!\nBem vindo ao Mercado Árabe!");
				textField_Email.setText("");
				textField_Nome.setText("");
				textField_User.setText("");
				passwordField.setText("");
				
				frmCadastroComprador.dispose(); //volta p/ tela inicio
				
			} catch(NomeVazioException e) {
				JOptionPane.showMessageDialog(null, "Informe um nome!");
				passwordField.setText("");
			} catch(NomeUsuarioForaPadroesException e) {
				JOptionPane.showMessageDialog(null, "Usuário inválido! Tente novamente!\n "
						+ "O Usuário deve conter no minimo 4 caracteres.");
				textField_User.setText("");
				passwordField.setText("");
			} catch(SenhaForaPadroesException e) {
				JOptionPane.showMessageDialog(null, "Senha inválida! Tente novamente!\n "
						+ "A Senha deve conter no mínimo 8 caracteres, etc.."); //organizar aqui
				passwordField.setText("");
			} catch(NomeUsuarioJaCadastradoException e) {
				JOptionPane.showMessageDialog(null, "Nome de usuário já cadastrado! Tente um diferente!");
				textField_User.setText("");
				passwordField.setText("");
			}
		}
	}
}
