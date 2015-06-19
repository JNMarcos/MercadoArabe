package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class TelaProcuraProduto {

	private JFrame frame;
	private JTextField textField;
	private JButton btnBuscar;
	private JList list;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcuraProduto window = new TelaProcuraProduto();
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
	public TelaProcuraProduto() {
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
		
		JLabel lblNewLabel = new JLabel("Ol\u00E1, fa\u00E7a aqui sua busca:");
		lblNewLabel.setBounds(10, 11, 127, 14);
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 8, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(347, 7, 77, 23);
		btnBuscar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnBuscar);
		
		list = new JList();
		list.setBounds(10, 51, 402, 177);
		frame.getContentPane().add(list);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(10, 228, 77, 22);
		btnSair.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnSair);
	}
}
