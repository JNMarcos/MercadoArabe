package br.ufrpe.gui.telas_editar;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class TelaEditarVendedor extends JFrame{
	public TelaEditarVendedor() {
		setResizable(false);
		setTitle("Atualiza\u00E7\u00E3o de informa\u00E7\u00F5es cadastrais");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 551, 315);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Logradouro");
		lblNewLabel_4.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(30, 73, 78, 43);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Bairro");
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(237, 105, 46, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setBounds(30, 164, 84, 14);
		panel.add(lblNovaSenha);
		lblNovaSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblConfirmeASenha = new JLabel("Telefone");
		lblConfirmeASenha.setBounds(30, 54, 61, 14);
		panel.add(lblConfirmeASenha);
		lblConfirmeASenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setBounds(331, 51, 185, 20);
		panel.add(textField_1);
		textField_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_1.setColumns(10);
		
		JButton btnConfirmar = new JButton(" Confirmar");
		btnConfirmar.setBounds(296, 268, 104, 23);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(275, 54, 46, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblConfSenha = new JLabel("Confirme senha");
		lblConfSenha.setBounds(30, 202, 97, 14);
		panel.add(lblConfSenha);
		lblConfSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 51, 146, 20);
		panel.add(textField_2);
		textField_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apenas \u00E9 necess\u00E1rio preencher os dados que foram alterado.");
		lblNewLabel_3.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(30, 222, 486, 35);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField.setBounds(101, 115, 127, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAtualizeSuasInforme = new JLabel("Atualize suas informa\u00E7\u00F5es de contato e credenciais");
		lblAtualizeSuasInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizeSuasInforme.setBounds(30, 11, 487, 20);
		panel.add(lblAtualizeSuasInforme);
		lblAtualizeSuasInforme.setFont(new Font("Gisha", Font.PLAIN, 18));
		
		textField_3 = new JTextField();
		textField_3.setBounds(284, 116, 116, 22);
		panel.add(textField_3);
		textField_3.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBox.setBounds(437, 116, 79, 20);
		panel.add(comboBox);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(152, 268, 108, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		passwordField = new JPasswordField("");
		passwordField.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField.setBounds(137, 193, 146, 23);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField_1.setBounds(136, 158, 148, 20);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("Cidade");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 112, 53, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("UF");
		lblNewLabel_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(410, 98, 29, 50);
		panel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_4.setBounds(111, 82, 405, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
}
