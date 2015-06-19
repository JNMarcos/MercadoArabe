package br.ufrpe.gui.telas_exibir_info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class TelaExibirInfoProduto extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmVejaMelhorO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibirInfoProduto window = new TelaExibirInfoProduto();
					window.frmVejaMelhorO.setVisible(true);
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
		frmVejaMelhorO = new JFrame();
		frmVejaMelhorO.setTitle("Conhe\u00E7a melhor o produto");
		frmVejaMelhorO.getContentPane().setBackground(SystemColor.activeCaption);
		frmVejaMelhorO.setBounds(100, 100, 450, 397);
		frmVejaMelhorO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVejaMelhorO.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 358);
		frmVejaMelhorO.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(189, 313, 89, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblNomeDoProduto = new JLabel("NOME DO PRODUTO");
		lblNomeDoProduto.setBounds(10, 25, 268, 29);
		panel.add(lblNomeDoProduto);
		lblNomeDoProduto.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblPreo = new JLabel("R$");
		lblPreo.setForeground(new Color(0, 128, 0));
		lblPreo.setBounds(302, 235, 46, 14);
		panel.add(lblPreo);
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 17));
		
		JLabel lblPreo_1 = new JLabel("PRE\u00C7O");
		lblPreo_1.setForeground(Color.RED);
		lblPreo_1.setBounds(335, 229, 89, 24);
		panel.add(lblPreo_1);
		lblPreo_1.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblInformaesDoProduto = new JLabel("CATEGORIA");
		lblInformaesDoProduto.setBounds(10, 75, 171, 14);
		panel.add(lblInformaesDoProduto);
		lblInformaesDoProduto.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(10, 150, 149, 14);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnInformaesDoVendedor = new JButton("Informa\u00E7\u00F5es do vendedor");
		btnInformaesDoVendedor.setBounds(102, 279, 246, 23);
		panel.add(btnInformaesDoVendedor);
		btnInformaesDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblQuantidade = new JLabel("QUANTIDADE");
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblQuantidade.setBounds(10, 110, 171, 14);
		panel.add(lblQuantidade);
		
		JLabel lblImagem = new JLabel("IMAGEM");
		lblImagem.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblImagem.setBounds(293, 110, 108, 14);
		panel.add(lblImagem);
	}
}
