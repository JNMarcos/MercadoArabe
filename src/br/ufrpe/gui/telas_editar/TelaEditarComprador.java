package br.ufrpe.gui.telas_editar;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TelaEditarComprador extends JFrame{
	public TelaEditarComprador() {
		setTitle("Alterar senha");
		setResizable(false);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 444, 117);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRepetirSenha = new JLabel("Repetir senha");
		lblRepetirSenha.setBounds(30, 69, 83, 17);
		panel.add(lblRepetirSenha);
		lblRepetirSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setBounds(30, 34, 72, 17);
		panel.add(lblNovaSenha);
		lblNovaSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(344, 47, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField.setBounds(134, 32, 200, 19);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField_1.setBounds(136, 66, 200, 20);
		panel.add(passwordField_1);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
}
