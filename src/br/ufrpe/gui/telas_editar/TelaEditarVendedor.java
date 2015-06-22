package br.ufrpe.gui.telas_editar;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaEditarVendedor extends JFrame{
	public TelaEditarVendedor() {
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JLabel lblNovaSenha = new JLabel("Senha:");
		lblNovaSenha.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNovaSenha.setBounds(105, 70, 61, 14);
		getContentPane().add(lblNovaSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Telefone:");
		lblConfirmeASenha.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblConfirmeASenha.setBounds(92, 102, 61, 14);
		getContentPane().add(lblConfirmeASenha);
		
		textField = new JTextField();
		textField.setBounds(156, 67, 115, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 99, 115, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnConfirmar = new JButton(" Confirmar");
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnConfirmar.setBounds(213, 204, 89, 23);
		getContentPane().add(btnConfirmar);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblEmail.setBounds(103, 138, 46, 14);
		getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 135, 115, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAtualizeSuasInforme = new JLabel("Atualize suas informa\u00E7\u00F5es");
		lblAtualizeSuasInforme.setFont(new Font("Gisha", Font.PLAIN, 18));
		lblAtualizeSuasInforme.setBounds(120, 11, 213, 20);
		getContentPane().add(lblAtualizeSuasInforme);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnVoltar.setBounds(92, 204, 89, 23);
		getContentPane().add(btnVoltar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

}
