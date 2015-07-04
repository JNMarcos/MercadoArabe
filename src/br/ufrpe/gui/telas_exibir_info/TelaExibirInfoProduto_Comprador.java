package br.ufrpe.gui.telas_exibir_info;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufrpe.negocio.classes_basicas.Produto;

public class TelaExibirInfoProduto_Comprador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmVejaMelhorO;
	private JButton btnVoltar;
	private JButton btnInformaesDoVendedor;
	
	Produto p;


	/**
	 * Create the application.
	 */
	public TelaExibirInfoProduto_Comprador(Produto p) {
		initialize(p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Produto p) {
		setProduto(p);
		frmVejaMelhorO = new JFrame();
		frmVejaMelhorO.setResizable(false);
		frmVejaMelhorO.setTitle("Conhe\u00E7a melhor o produto");
		frmVejaMelhorO.getContentPane().setBackground(SystemColor.activeCaption);
		frmVejaMelhorO.setBounds(100, 100, 438, 387);
		frmVejaMelhorO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVejaMelhorO.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 358);
		frmVejaMelhorO.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(189, 313, 89, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblItensDisponiveis = new JLabel("item(s) dispon\u00EDvel(is)");
		lblItensDisponiveis.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblItensDisponiveis.setBounds(46, 110, 181, 14);
		panel.add(lblItensDisponiveis);
		
		JLabel lblNomeDoProduto = new JLabel("NOME DO PRODUTO");
		lblNomeDoProduto.setBounds(10, 25, 268, 29);
		lblNomeDoProduto.setText(p.getNome());
		panel.add(lblNomeDoProduto);
		lblNomeDoProduto.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblPreo = new JLabel("R$");
		lblPreo.setForeground(new Color(0, 128, 0));
		lblPreo.setBounds(279, 237, 26, 14);
		panel.add(lblPreo);
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 17));
		
		JLabel lblPreo_1 = new JLabel("PRE\u00C7O");
		lblPreo_1.setForeground(Color.RED);
		lblPreo_1.setBounds(320, 229, 104, 24);
		lblPreo_1.setText("" + p.getPreco());
		panel.add(lblPreo_1);
		lblPreo_1.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 26));
		
		JLabel lblInformaesDoProduto = new JLabel("CATEGORIA");
		lblInformaesDoProduto.setBounds(10, 75, 171, 14);
		lblInformaesDoProduto.setText(p.getCategoria());
		panel.add(lblInformaesDoProduto);
		lblInformaesDoProduto.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(10, 150, 149, 14);
		lblDescrio.setText(p.getDescricao());
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnInformaesDoVendedor = new JButton("Estou interessado no produto");
		btnInformaesDoVendedor.setBounds(102, 279, 246, 23);
		panel.add(btnInformaesDoVendedor);
		btnInformaesDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblQuantidade = new JLabel("QUANTIDADE");
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblQuantidade.setBounds(10, 110, 171, 14);
		lblQuantidade.setText("" + p.getItensNoEstoque());
		panel.add(lblQuantidade);
	}

	private void setProduto(Produto p) {
		this.p = p;
		
	}
}
