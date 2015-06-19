package br.ufrpe.gui.telas_exibir_info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaExibirInfoVendedor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibirInfoVendedor window = new TelaExibirInfoVendedor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExibirInfoVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInformaesDoVendedor = new JLabel("Informa\u00E7\u00F5es do vendedor");
		lblInformaesDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 22));;
		lblInformaesDoVendedor.setBounds(105, 11, 231, 35);
		frame.getContentPane().add(lblInformaesDoVendedor);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 57, 39, 20);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblNome);
		
		JLabel lblNomeDoVendedor = new JLabel("NOME DO VENDEDOR");
		lblNomeDoVendedor.setBounds(59, 57, 221, 20);
		lblNomeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblNomeDoVendedor);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 88, 46, 20);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 113, 46, 20);
		lblTelefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 141, 46, 20);
		lblCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblCidade);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(168, 227, 89, 23);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblXp = new JLabel("XP:");
		lblXp.setBounds(10, 168, 46, 14);
		lblXp.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblXp);
		
		JLabel lblEmailDoVendedor = new JLabel("E-MAIL DO VENDEDOR");
		lblEmailDoVendedor.setBounds(59, 88, 120, 14);
		lblEmailDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblEmailDoVendedor);
		
		JLabel lblTelefoneDoVendedor = new JLabel("TELEFONE DO VENDEDOR");
		lblTelefoneDoVendedor.setBounds(59, 116, 120, 14);
		lblTelefoneDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblTelefoneDoVendedor);
		
		JLabel lblCidadeDoVendedor = new JLabel("CIDADE DO VENDEDOR");
		lblCidadeDoVendedor.setBounds(59, 144, 120, 14);
		lblCidadeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblCidadeDoVendedor);
		
		JLabel lblXpDpVendedor = new JLabel("XP DP VENDEDOR");
		lblXpDpVendedor.setBounds(59, 168, 85, 14);
		lblXpDpVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(lblXpDpVendedor);
	}

}
