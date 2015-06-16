package br.ufrpe.gui;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaSobre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaSobre() {
		getContentPane().setFont(new Font("Gisha", Font.PLAIN, 13));
		setTitle("Sobre o Mercado \u00C1rabe");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 606, 155);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O Mercado \u00C1rabe \u00E9 um aplicativo que busca facilitar a venda e a procura de produtos");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 11, 508, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" de forma pr\u00E1tica e simples. Para quem desejar vender, basta se cadastrar em nosso app. ");
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(35, 27, 532, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Para quem est\u00E1 \u00E0 procura de um produto, basta usar nossa barra de pesquisas para aproveitar!");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 27, 586, 50);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u00C9 f\u00E1cil, comece a usar!");
		lblNewLabel_3.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(134, 65, 312, 50);
		panel.add(lblNewLabel_3);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnOk.setBounds(246, 115, 100, 30);
		panel.add(btnOk);
		
	}
}
