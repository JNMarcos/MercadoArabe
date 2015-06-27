package br.ufrpe.gui.telas_editar;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaEditarComprador extends JFrame{
	public TelaEditarComprador() {
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JLabel lblNovaSenha = new JLabel("Nova senha:");
		lblNovaSenha.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNovaSenha.setBounds(79, 77, 69, 19);
		getContentPane().add(lblNovaSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir senha:");
		lblRepetirSenha.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblRepetirSenha.setBounds(68, 117, 80, 14);
		getContentPane().add(lblRepetirSenha);
		
		textField = new JTextField();
		textField.setBounds(158, 76, 147, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 114, 147, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnConfirmar.setBounds(167, 173, 97, 23);
		getContentPane().add(btnConfirmar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
}
