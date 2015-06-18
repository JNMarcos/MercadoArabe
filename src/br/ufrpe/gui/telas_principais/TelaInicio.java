package br.ufrpe.gui.telas_principais;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMercadorabe = new JLabel("Mercado \u00C1rabe");
		lblMercadorabe.setBounds(77, 33, 282, 53);
		panel.add(lblMercadorabe);
		lblMercadorabe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercadorabe.setFont(new Font("Gisha", Font.BOLD, 34));
		
		JButton btnComprador = new JButton("Comprador");
		btnComprador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicio.dispose();
				TelaInicio TelaLoginComprador = new TelaInicio();  
				TelaLoginComprador.setVisible(true);
			}
		});
		btnComprador.setBounds(77, 146, 101, 25);
		btnComprador.setLayout(new BorderLayout(0, 0));
		btnComprador.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnComprador);
		
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio.dispose();
				TelaInicio TelaLoginVendedor = new TelaInicio();  
				TelaLoginVendedor.setVisible(true);
			}
		});
		btnVendedor.setBounds(268, 146, 91, 25);
		panel.add(btnVendedor);
		btnVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio.dispose();
				TelaInicio TelaCadastroVendedor = new TelaInicio();  
				TelaCadastroVendedor.setVisible(true);
			}
		});
		btnCadastrese.setBackground(null);
		btnCadastrese.setBorder(null);
		btnCadastrese.setContentAreaFilled(false);
		btnCadastrese.setForeground(new Color(0, 0, 204));
		btnCadastrese.setBounds(268, 185, 103, 25);
		btnCadastrese.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadastrese);

		
		JLabel lblEntre = new JLabel("Entrar como");
		lblEntre.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblEntre.setBounds(32, 109, 83, 25);
		panel.add(lblEntre);
		
		JButton btnCadastrese_1 = new JButton("Cadastre-se");
		btnCadastrese_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio.dispose();
				TelaInicio TelaCadastroComprador = new TelaInicio();  
				TelaCadastroComprador.setVisible(true);
			}
		});
		btnCadastrese_1.setBounds(77, 187, 101, 23);
		panel.add(btnCadastrese_1);
		btnCadastrese_1.setBackground(null);
		btnCadastrese_1.setBorder(null);
		btnCadastrese_1.setContentAreaFilled(false);
		btnCadastrese_1.setForeground(new Color(0, 0, 204));
		btnCadastrese_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadastrese_1);
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
