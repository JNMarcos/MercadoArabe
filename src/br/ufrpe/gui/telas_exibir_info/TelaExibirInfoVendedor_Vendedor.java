package br.ufrpe.gui.telas_exibir_info;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaExibirInfoVendedor_Vendedor {
	private JFrame frmConheaOVendedor;


	/**
	 * Create the application.
	 */
	public TelaExibirInfoVendedor_Vendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConheaOVendedor = new JFrame();
		frmConheaOVendedor.setTitle("Veja seus dados cadastrais");
		frmConheaOVendedor.getContentPane().setBackground(SystemColor.activeCaption);
		frmConheaOVendedor.setBounds(100, 100, 450, 418);
		frmConheaOVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConheaOVendedor.getContentPane().setLayout(null);;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 379);
		frmConheaOVendedor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInformaesDoVendedor = new JLabel("SOBRE");
		lblInformaesDoVendedor.setBounds(10, 29, 108, 35);
		panel.add(lblInformaesDoVendedor);
		lblInformaesDoVendedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformaesDoVendedor.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblNewLabel_1 = new JLabel("LOGRADOURO");
		lblNewLabel_1.setBounds(31, 132, 376, 35);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 111, 200, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoVendedor = new JLabel("NOME DO VENDEDOR");
		lblNomeDoVendedor.setBounds(31, 82, 323, 20);
		panel.add(lblNomeDoVendedor);
		lblNomeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(45, 345, 152, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblEmailDoVendedor = new JLabel("E-MAIL DO VENDEDOR");
		lblEmailDoVendedor.setBounds(31, 242, 300, 14);
		panel.add(lblEmailDoVendedor);
		lblEmailDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblTelefoneDoVendedor = new JLabel("TELEFONE DO VENDEDOR");
		lblTelefoneDoVendedor.setBounds(31, 267, 190, 14);
		panel.add(lblTelefoneDoVendedor);
		lblTelefoneDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblCidadeDoVendedor = new JLabel("CIDADE DO VENDEDOR");
		lblCidadeDoVendedor.setBounds(31, 169, 323, 14);
		panel.add(lblCidadeDoVendedor);
		lblCidadeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnContinuoInteressado = new JButton("Editar informa\u00E7\u00F5es");
		btnContinuoInteressado.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnContinuoInteressado.setBounds(223, 345, 172, 23);
		panel.add(btnContinuoInteressado);
		
		JLabel lblNewLabel_5 = new JLabel("SENHA");
		lblNewLabel_5.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(31, 292, 200, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("BAIRRO");
		lblNewLabel_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(31, 192, 240, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("USERNAME");
		lblNewLabel_4.setBounds(91, 32, 288, 29);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblNewLabel_3 = new JLabel("UF");
		lblNewLabel_3.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(31, 217, 122, 20);
		panel.add(lblNewLabel_3);
	}

}
