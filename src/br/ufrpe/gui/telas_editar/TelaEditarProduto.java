package br.ufrpe.gui.telas_editar;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaEditarProduto extends JFrame{
	public TelaEditarProduto() {
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JLabel lblAtualizeSeuProduto = new JLabel("Atualize seu produto!");
		lblAtualizeSeuProduto.setFont(new Font("Gisha", Font.PLAIN, 18));
		lblAtualizeSeuProduto.setBounds(118, 11, 201, 22);
		getContentPane().add(lblAtualizeSeuProduto);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblPreo.setBounds(279, 59, 40, 14);
		getContentPane().add(lblPreo);
		
		textField = new JTextField();
		textField.setBounds(329, 57, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNome.setBounds(10, 60, 46, 14);
		getContentPane().add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 57, 195, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblDescrio.setBounds(10, 102, 69, 14);
		getContentPane().add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 100, 287, 70);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConfirmar = new JButton(" Confirmar");
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnConfirmar.setBounds(230, 203, 95, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVoltar.setBounds(118, 204, 89, 23);
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
