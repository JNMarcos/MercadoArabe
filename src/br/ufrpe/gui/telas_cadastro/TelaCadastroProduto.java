package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroProduto {

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
					TelaCadastroProduto window = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
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
		
		JButton btnNewButton = new JButton("Pr\u00F3ximo");
		btnNewButton.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 28, 46, 14);
		frame.getContentPane().add(lblNome);
		
	
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 76, 77, 14);
		frame.getContentPane().add(lblDescrio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 73, 295, 68);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 25, 292, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
