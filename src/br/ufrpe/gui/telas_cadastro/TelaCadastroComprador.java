package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaCadastroComprador {

	private JFrame frmCadastroComprador;
	JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroComprador window = new TelaCadastroComprador();
					window.frmCadastroComprador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmCadastroComprador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroComprador.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 218);
		frmCadastroComprador.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(169, 173, 89, 23);
		panel.add(btnCadastrar);
		btnCadastrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_3.setBounds(88, 63, 268, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(22, 144, 46, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_2.setBounds(88, 141, 129, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(22, 104, 46, 14);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_1.setBounds(88, 24, 269, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(22, 66, 46, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField.setBounds(88, 101, 266, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(22, 27, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
	}
}
