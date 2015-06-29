package br.ufrpe.gui.telas_login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaLoginVendedor {

	private JFrame frame;
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
					TelaLoginVendedor window = new TelaLoginVendedor();
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
	public TelaLoginVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 444, 199);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVendedor = new JLabel("Vendedor");
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
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(74, 116, 38, 17);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setBounds(150, 87, 182, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 115, 182, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
