package br.ufrpe.gui.telas_exibir_info;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import br.ufrpe.negocio.classes_basicas.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExibirInfoProduto_Vendedor {
	private static final long serialVersionUID = 1L;
	private JFrame frmVejaMelhorO;
	private JButton btnVoltar;
	private JTable table;
	
	Produto p;


	/**
	 * Create the application.
	 */
	public TelaExibirInfoProduto_Vendedor(Produto p) {
		initialize(p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Produto p) {
		setProduto(p);
		frmVejaMelhorO = new JFrame();
		frmVejaMelhorO.setTitle("Descri\u00E7\u00E3o produto");
		frmVejaMelhorO.getContentPane().setBackground(SystemColor.activeCaption);
		frmVejaMelhorO.setBounds(100, 100, 517, 446);
		frmVejaMelhorO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVejaMelhorO.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 502, 407);
		frmVejaMelhorO.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExibirInfoProduto_Vendedor.dispose();
				TelaExibirInfoProduto_Vendedor TelaVendedor = new TelaExibirInfoProduto_Vendedor(p);
				TelaVendedor.setvisible(true);
			}
		});
		btnVoltar.setBounds(113, 370, 89, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblNomeDoProduto = new JLabel("NOME DO PRODUTO");
		lblNomeDoProduto.setBounds(10, 25, 268, 29);
		panel.add(lblNomeDoProduto);
		lblNomeDoProduto.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblPreo = new JLabel("R$");
		lblPreo.setForeground(new Color(0, 128, 0));
		lblPreo.setBounds(355, 201, 46, 14);
		panel.add(lblPreo);
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 17));
		
		JLabel lblPreo_1 = new JLabel("PRE\u00C7O");
		lblPreo_1.setForeground(Color.RED);
		lblPreo_1.setBounds(413, 195, 89, 24);
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
		
		table = new JTable();
		table.setBounds(20, 230, 449, 129);
		panel.add(table);
		
		JLabel lblQuantidade = new JLabel("QUAN");
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblQuantidade.setBounds(10, 110, 80, 29);
		panel.add(lblQuantidade);
		
		JLabel lblImagem = new JLabel("IMAGEM");
		lblImagem.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblImagem.setBounds(338, 99, 108, 14);
		panel.add(lblImagem);
		
		JLabel lblNewLabel = new JLabel("item(ns),");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 105, 53, 39);
		panel.add(lblNewLabel);
		
		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblQtd.setBounds(124, 99, 32, 50);
		panel.add(lblQtd);
		
		JLabel lblVendidos = new JLabel("vendidos");
		lblVendidos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblVendidos.setBounds(152, 99, 89, 50);
		panel.add(lblVendidos);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(212, 370, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vender");
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(314, 370, 89, 23);
		panel.add(btnNewButton_1);
	}

	private void setProduto(Produto p) {
		this.p = p;
	}
	

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	protected void setvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
