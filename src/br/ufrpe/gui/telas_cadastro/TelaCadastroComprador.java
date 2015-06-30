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
	private JPasswordField passwordField_Confirma;

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
		btnCadastrar.setBounds(333, 184, 91, 23);
		btnCadastrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadastrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 22, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_Nome = new JTextField();
		textField_Nome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_Nome.setBounds(137, 18, 269, 23);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(81, 55, 46, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_Email.setBounds(137, 52, 268, 23);
		panel.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(81, 90, 46, 14);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_User = new JTextField();
		textField_User.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_User.setBounds(137, 86, 202, 23);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(81, 123, 46, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 120, 129, 23);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Confirmar Senha");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 154, 105, 23);
		panel.add(lblNewLabel);
		
		passwordField_Confirma = new JPasswordField();
		passwordField_Confirma.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField_Confirma.setBounds(137, 154, 129, 23);
		panel.add(passwordField_Confirma);

		//add acao ao botao cadastrar
		fachada = new Fachada();
		comprador = new Comprador();
		EventoBotaoCadastrar acaoBtnCadastrar = new EventoBotaoCadastrar();
		btnCadastrar.addActionListener(acaoBtnCadastrar);
		
		//botao cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnCancelar.setBounds(232, 184, 91, 23);
		panel.add(btnCancelar);
		EventoBotaoCancelar acaoBtnCancelar = new EventoBotaoCancelar();
		btnCancelar.addActionListener(acaoBtnCancelar);
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
				String senha = new String(passwordField.getPassword());
				String senhaConfirma = new String(passwordField_Confirma.getPassword());
				
				if(senha.equals(senhaConfirma)) {
					comprador.setNome(textField_Nome.getText());
					comprador.setNomeUsuario(textField_User.getText());
					comprador.setSenha(senha);
					
					//precisa-se fazer um campo email pro comprador ou retirar daqui. Campo data de Nascimento em branco.
					
					fachada.cadastrarComprador(comprador);
					fachada.salvarComprador();
					
					//mensagem boas vindas
					JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!\nBem-vindo ao Mercado Árabe!");
					textField_Email.setText("");
					textField_Nome.setText("");
					textField_User.setText("");
					passwordField.setText("");
					
					frmCadastroComprador.dispose(); //volta p/ tela inicio
				}	
				
			} catch(NomeVazioException e) {
				JOptionPane.showMessageDialog(null, "Informe um nome!");
				passwordField.setText("");
				
			} catch(NomeUsuarioForaPadroesException e) {
				JOptionPane.showMessageDialog(null, "Usuário inválido! Tente novamente!\n "
						+ "O Usuário deve conter no mínimo 4 caracteres.");
				textField_User.setText("");
				passwordField.setText("");
				
			} catch(SenhaForaPadroesException e) {
				JOptionPane.showMessageDialog(null, "Senha inválida! Tente novamente!\n "
						+ "A Senha deve conter no mínimo 8 caracteres e presença de números ou caracteres especiais"); //organizar aqui
				passwordField.setText("");
				
			} catch(NomeUsuarioJaCadastradoException e) {
				JOptionPane.showMessageDialog(null, "Nome de usuário já cadastrado! Tente um diferente!");
				textField_User.setText("");
				passwordField.setText("");
			}
		}
	}
	
	private class EventoBotaoCancelar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmCadastroComprador.setVisible(false);
			textField_Nome.setText("");
			textField_Email.setText("");
			textField_User.setText("");
			passwordField.setText("");
			passwordField_Confirma.setText("");
		}
	}
}
