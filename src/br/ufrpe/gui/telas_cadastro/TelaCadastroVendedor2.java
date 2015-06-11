package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroVendedor2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVendedor2 window = new TelaCadastroVendedor2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroVendedor2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 30, 46, 14);
		frame.getContentPane().add(lblCidade);
		
		textField = new JTextField();
		textField.setBounds(85, 27, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(215, 30, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(290, 27, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(107, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(241, 227, 89, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel lblNomeDoUsurio = new JLabel("Nome do Usu\u00E1rio:");
		lblNomeDoUsurio.setBounds(10, 81, 89, 14);
		frame.getContentPane().add(lblNomeDoUsurio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 78, 209, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(53, 112, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 109, 150, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSenha_1 = new JLabel("Senha:");
		lblSenha_1.setBounds(53, 149, 46, 14);
		frame.getContentPane().add(lblSenha_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 146, 150, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}

}
