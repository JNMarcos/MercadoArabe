package br.ufrpe.gui.telas_principais;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

public class TelaPesquisarProdutos extends JFrame {

	/**
	 * verificar se deu algo
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblNomeDoProduto;
	private JLabel lblCategoria;
	private JLabel lblCidadeDoVendedor;
	private JTextField textField_1;
	private JLabel lblDe;
	private JTextField textField_2;
	private JLabel lblA;
	private JTextField textField_3;
	private JLabel lblNoNecessrio;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the frame.
	 */
	public TelaPesquisarProdutos() {
		setTitle("Pesquisa de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 597, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 20, 406, 23);
		panel.add(textField);
		textField.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar!");
		btnPesquisar.setBounds(361, 101, 208, 23);
		panel.add(btnPesquisar);
		btnPesquisar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		comboBox = new JComboBox();
		comboBox.setBounds(106, 61, 200, 23);
		comboBox.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(comboBox);
		
		lblNomeDoProduto = new JLabel("Nome do produto");
		lblNomeDoProduto.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNomeDoProduto.setBounds(10, 13, 143, 37);
		panel.add(lblNomeDoProduto);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblCategoria.setBounds(10, 55, 86, 35);
		panel.add(lblCategoria);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_2.setBounds(361, 60, 86, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(145, 510, 89, 23);
		panel.add(btnNewButton);
		
		lblCidadeDoVendedor = new JLabel("Cidade do vendedor");
		lblCidadeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblCidadeDoVendedor.setBounds(10, 94, 125, 37);
		panel.add(lblCidadeDoVendedor);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_1.setBounds(145, 101, 206, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_2 = new JButton("Favoritar");
		btnNewButton_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_2.setBounds(378, 510, 89, 23);
		panel.add(btnNewButton_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_3.setBounds(483, 60, 86, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		table = new JTable();
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		table.setBounds(40, 179, 529, 304);
		panel.add(table);
		
		lblDe = new JLabel("De");
		lblDe.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblDe.setBounds(327, 55, 24, 36);
		panel.add(lblDe);
		
		lblA = new JLabel("a");
		lblA.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblA.setBounds(458, 53, 22, 37);
		panel.add(lblA);
		
		lblNoNecessrio = new JLabel("N\u00E3o \u00E9 necess\u00E1rio a inclus\u00E3o de todos os dados para a realiza\u00E7\u00E3o da pesquisa.");
		lblNoNecessrio.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNoNecessrio.setBounds(20, 135, 406, 23);
		panel.add(lblNoNecessrio);
		
		btnNewButton_1 = new JButton("Ver");
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(262, 510, 89, 23);
		panel.add(btnNewButton_1);
		
	}
}
