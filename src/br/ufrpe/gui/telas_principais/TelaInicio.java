package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaInicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio window = new TelaInicio();
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
	public TelaInicio() {
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
		
		JLabel lblMercadorabe = new JLabel("Mercado \u00C1rabe");
		lblMercadorabe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercadorabe.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblMercadorabe.setBounds(125, 27, 164, 41);
		frame.getContentPane().add(lblMercadorabe);
		
		JButton btnComprador = new JButton("Comprador");
		btnComprador.setBounds(58, 121, 89, 23);
		frame.getContentPane().add(btnComprador);
		
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.setBounds(263, 121, 89, 23);
		frame.getContentPane().add(btnVendedor);
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setBounds(157, 162, 97, 23);
		frame.getContentPane().add(btnCadastrese);
	}
}
