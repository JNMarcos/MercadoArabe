package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.SystemColor;

public class TelaLoginComprador {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel lblVendedor = new JLabel("Comprador");
		lblVendedor.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		lblVendedor.setBounds(173, 31, 89, 31);
		frame.getContentPane().add(lblVendedor);
		
		JButton btnEntrar = new JButton(" Entrar");
		btnEntrar.setBounds(250, 211, 89, 23);
		btnEntrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnEntrar);
		
		JButton btnVoltar = new JButton("Voltar ");
		btnVoltar.setBounds(87, 211, 89, 23);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(87, 85, 46, 14);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(87, 120, 46, 14);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(143, 81, 200, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 116, 200, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
	}
	

}
