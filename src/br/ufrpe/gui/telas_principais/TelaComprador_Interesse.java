package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class TelaComprador_Interesse {
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	/**
	 * Create the application.
	 */
	public TelaComprador_Interesse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuPerfil = new JFrame();
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 398);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 680, 364);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(77, 317, 163, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		table.setCellSelectionEnabled(true);
		table.setBounds(20, 131, 630, 160);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Produtos de interesse");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 91, 200, 29);
		panel.add(lblNewLabel);
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA está interessado em");
		lblXpDisponvel.setBounds(20, 69, 168, 17);
		panel.add(lblXpDisponvel);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel label = new JLabel("qtd");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(185, 69, 44, 17);
		panel.add(label);
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel lblProdutos = new JLabel("produto(s)");
		lblProdutos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblProdutos.setBounds(246, 69, 84, 17);
		panel.add(lblProdutos);
		
		btnNewButton_1 = new JButton("Não tenho mais interesse");
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(384, 317, 210, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(26, 23, 200, 38);
		panel.add(lblNewLabel_1);
	}
}
