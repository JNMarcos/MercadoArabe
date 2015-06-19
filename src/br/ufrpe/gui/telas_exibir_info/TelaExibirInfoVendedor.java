package br.ufrpe.gui.telas_exibir_info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class TelaExibirInfoVendedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmConheaOVendedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibirInfoVendedor window = new TelaExibirInfoVendedor();
					window.frmConheaOVendedor.setVisible(true);
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
		frmConheaOVendedor = new JFrame();
		frmConheaOVendedor.setTitle("Conhe\u00E7a o vendedor");
		frmConheaOVendedor.getContentPane().setBackground(SystemColor.activeCaption);
		frmConheaOVendedor.setBounds(100, 100, 450, 300);
		frmConheaOVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConheaOVendedor.getContentPane().setLayout(null);;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frmConheaOVendedor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInformaesDoVendedor = new JLabel("SOBRE O VENDEDOR");
		lblInformaesDoVendedor.setBounds(10, 26, 310, 35);
		panel.add(lblInformaesDoVendedor);
		lblInformaesDoVendedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformaesDoVendedor.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(21, 77, 39, 20);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblNomeDoVendedor = new JLabel("NOME DO VENDEDOR");
		lblNomeDoVendedor.setBounds(68, 76, 221, 20);
		panel.add(lblNomeDoVendedor);
		lblNomeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(22, 149, 46, 20);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(22, 187, 70, 20);
		panel.add(lblTelefone);
		lblTelefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(21, 112, 46, 20);
		panel.add(lblCidade);
		lblCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(297, 227, 89, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblEmailDoVendedor = new JLabel("E-MAIL DO VENDEDOR");
		lblEmailDoVendedor.setBounds(75, 152, 159, 14);
		panel.add(lblEmailDoVendedor);
		lblEmailDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblTelefoneDoVendedor = new JLabel("TELEFONE DO VENDEDOR");
		lblTelefoneDoVendedor.setBounds(86, 191, 190, 14);
		panel.add(lblTelefoneDoVendedor);
		lblTelefoneDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblCidadeDoVendedor = new JLabel("CIDADE DO VENDEDOR");
		lblCidadeDoVendedor.setBounds(67, 116, 163, 14);
		panel.add(lblCidadeDoVendedor);
		lblCidadeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
	}

}
