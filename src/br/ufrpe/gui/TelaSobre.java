package br.ufrpe.gui;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class TelaSobre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaSobre() {
		getContentPane().setBackground(SystemColor.activeCaption);
		
		JTextPane txtpnOMercadorabe = new JTextPane();
		txtpnOMercadorabe.setBackground(null);
		txtpnOMercadorabe.setFont(new Font("Gisha", Font.PLAIN, 13));
		txtpnOMercadorabe.setText("O Mercado \u00C1rabe \u00E9 um aplicativo que busca facilitar a venda e a procura de produtos de forma pr\u00E1tica e simples. Para quem desejar vender, basta se cadastrar em nosso app. Para quem est\u00E1 \u00E0 procura de um produto, basta usar nossa barra de pesquisas para aproveitar! \u00C9 f\u00E1cil, comece a usar!\r\n\r\nEste \u00E9 um projeto desenvolvido por Carlos Ol\u00EDmpio, Jo\u00E3o Lucas e Jo\u00E3o Marcos, discentes da Universidade Federal Rural de Pernambuco, para o projeto da disciplina de POO do curso de Bacharelado em Ci\u00EAncia da Computa\u00E7\u00E3o.");
		txtpnOMercadorabe.setBounds(43, 11, 434, 182);
		getContentPane().add(txtpnOMercadorabe);
		
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnOK.setBounds(204, 247, 101, 25);
		getContentPane().add(btnOK);
	}
}
