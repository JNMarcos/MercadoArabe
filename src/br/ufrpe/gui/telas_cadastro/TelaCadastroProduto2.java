package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroProduto2 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto2 window = new TelaCadastroProduto2();
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
	public TelaCadastroProduto2() {
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
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblPreo);
		
		textField = new JTextField();
		textField.setBounds(66, 43, 69, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Imagens:");
		lblQuantidade.setBounds(10, 96, 69, 14);
		frame.getContentPane().add(lblQuantidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(282, 227, 89, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(50, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
