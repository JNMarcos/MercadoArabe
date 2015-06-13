package br.ufrpe.gui.telas_exibir_info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaExibirInfoProduto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibirInfoProduto window = new TelaExibirInfoProduto();
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
	public TelaExibirInfoProduto() {
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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 27, 46, 14);
		frame.getContentPane().add(lblProduto);
		
		JLabel lblNomeDoProduto = new JLabel("NOME DO PRODUTO");
		lblNomeDoProduto.setBounds(53, 27, 99, 14);
		frame.getContentPane().add(lblNomeDoProduto);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(243, 27, 46, 14);
		frame.getContentPane().add(lblPreo);
		
		JLabel lblPreo_1 = new JLabel("PRE\u00C7O");
		lblPreo_1.setBounds(278, 27, 46, 14);
		frame.getContentPane().add(lblPreo_1);
		
		JLabel lblInformaesDoProduto = new JLabel("Informa\u00E7\u00F5es do produto:");
		lblInformaesDoProduto.setBounds(10, 85, 120, 14);
		frame.getContentPane().add(lblInformaesDoProduto);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O E IMAGENS");
		lblDescrio.setBounds(140, 85, 126, 14);
		frame.getContentPane().add(lblDescrio);
		
		JButton btnInformaesDoVendedor = new JButton("Informa\u00E7\u00F5es do vendedor");
		btnInformaesDoVendedor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnInformaesDoVendedor.setBounds(10, 52, 142, 23);
		frame.getContentPane().add(btnInformaesDoVendedor);
	}

}
