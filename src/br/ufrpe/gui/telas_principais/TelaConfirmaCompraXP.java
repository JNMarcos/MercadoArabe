package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaConfirmaCompraXP {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConfirmaCompraXP window = new TelaConfirmaCompraXP();
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
	public TelaConfirmaCompraXP() {
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
		
		JLabel lblConfirmeSeusXps = new JLabel("Confirme seus XPs");
		lblConfirmeSeusXps.setFont(new Font("Gisha", Font.PLAIN, 18));
		lblConfirmeSeusXps.setBounds(139, 27, 148, 22);
		frame.getContentPane().add(lblConfirmeSeusXps);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(51, 76, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(51, 117, 46, 14);
		frame.getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(51, 164, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(107, 73, 148, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 114, 148, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 161, 148, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.setBounds(107, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(211, 227, 89, 23);
		frame.getContentPane().add(btnConfirmar);
	}
}
