package br.ufrpe.gui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ufrpe.gui.telas_principais.TelaInicio;

public class TelaSobre {
	/**
	 * 
	 */
	private JFrame frame;
	private TelaInicio telaInicio;

	public TelaSobre() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Sobre o Mercado Árabe");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 700, 273);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 694, 244);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O Mercado Árabe é um aplicativo que busca facilitar a venda e a procura de produtos");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 11, 508, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Para quem desejar vender, \r\nbasta se cadastrar em nosso app e ter uma grande variedade de clientes");
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(53, 97, 593, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Para quem est\u00E1 \u00E0 procura de um produto, basta fazer um cadastro e usar nossa barra de pesquisas!");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(53, 54, 593, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u00C9 f\u00E1cil, comece a usar!");
		lblNewLabel_3.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(184, 140, 312, 50);
		panel.add(lblNewLabel_3);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnOk.setBounds(292, 201, 100, 23);
		panel.add(btnOk);
		
		EventoBtnOK acaoOK = new EventoBtnOK();
		btnOk.addActionListener(acaoOK);
		
	}
	
	private class EventoBtnOK implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frame.dispose();
			telaInicio = new TelaInicio();
			telaInicio.setVisible(true);
		}
	}
	
	public void setVisible(boolean b) {
		if(b == true)
			frame.setVisible(b);
		else
			frame.setVisible(b);
	}
}
