package br.ufrpe.gui.telas_exibir_info;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.gui.telas_editar.TelaEditarProduto;
import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.gui.telas_principais.TelaVendedorConfirmarVenda;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;

public class TelaExibirInfoProduto_Vendedor {
	private JFrame frmVejaMelhorO;
	private JButton btnVoltar;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();

	private Produto p;
	private Vendedor v;
	private Fachada f;


	/**
	 * Create the application.
	 */
	public TelaExibirInfoProduto_Vendedor(Produto p, Vendedor v) {
		initialize(p, v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Produto p, Vendedor v) {
		setProduto(p);
		setVendedor(v);
		f = Fachada.getInstance();
		frmVejaMelhorO = new JFrame();
		frmVejaMelhorO.setResizable(false);
		frmVejaMelhorO.setTitle("Descri\u00E7\u00E3o produto");
		frmVejaMelhorO.getContentPane().setBackground(SystemColor.activeCaption);
		frmVejaMelhorO.setBounds(100, 100, 506, 435);
		frmVejaMelhorO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVejaMelhorO.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 502, 407);
		frmVejaMelhorO.getContentPane().add(panel);
		panel.setLayout(null);

		btnVoltar = new JButton("Voltar");
		EventoVoltar e2 = new EventoVoltar();
		btnVoltar.addActionListener(e2);
		btnVoltar.setBounds(113, 370, 89, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblNomeDoProduto = new JLabel("NOME DO PRODUTO");
		lblNomeDoProduto.setBounds(10, 25, 268, 29);
		lblNomeDoProduto.setText(p.getNome());
		panel.add(lblNomeDoProduto);
		lblNomeDoProduto.setFont(new Font("Gisha", Font.BOLD, 22));

		JLabel lblPreo = new JLabel("R$");
		lblPreo.setForeground(new Color(0, 128, 0));
		lblPreo.setBounds(355, 201, 46, 14);
		panel.add(lblPreo);
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 17));

		JLabel lblPreo_1 = new JLabel("PRE\u00C7O");
		lblPreo_1.setForeground(Color.RED);
		lblPreo_1.setBounds(384, 195, 118, 24);
		lblPreo_1.setText("" + p.getPreco());
		panel.add(lblPreo_1);
		lblPreo_1.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 20));

		JLabel lblInformaesDoProduto = new JLabel("CATEGORIA");
		lblInformaesDoProduto.setBounds(10, 75, 171, 14);
		panel.add(lblInformaesDoProduto);
		lblInformaesDoProduto.setText(p.getCategoria());
		lblInformaesDoProduto.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(10, 150, 149, 14);
		lblDescrio.setText(p.getDescricao());
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Gisha", Font.PLAIN, 13));

		modelo.addColumn("Nome");
		table = new JTable(modelo);
		table.setFont(new Font("Gisha", Font.PLAIN, 13));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 230, 449, 129);
		panel.add(barraRolagem);

		carregarTabela(modelo, p.getCompradoresInteressados());

		JLabel lblQuantidade = new JLabel("QUAN");
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblQuantidade.setBounds(10, 110, 80, 29);
		lblQuantidade.setText("" + p.getQuantidade());
		panel.add(lblQuantidade);

		JLabel lblNewLabel_1 = new JLabel("Compradores Interessados");
		lblNewLabel_1.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 197, 231, 23);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("item(ns),");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 105, 53, 39);
		panel.add(lblNewLabel);

		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblQtd.setBounds(124, 99, 32, 50);
		int itens = p.getQuantidade() - p.getItensNoEstoque();
		lblQtd.setText("" + itens);
		panel.add(lblQtd);

		JLabel lblVendidos = new JLabel("vendidos");
		lblVendidos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblVendidos.setBounds(152, 99, 89, 50);
		panel.add(lblVendidos);

		JButton btnNewButton = new JButton("Editar");
		EventoEditar e = new EventoEditar();
		btnNewButton.addActionListener(e);

		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(212, 370, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Vender");
		EventoVender e1 = new EventoVender();
		btnNewButton_1.addActionListener(e1);

		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(314, 370, 89, 23);
		panel.add(btnNewButton_1);
	}

	private void setVendedor(Vendedor v) {
		this.v = v;

	}

	private void setProduto(Produto p) {
		this.p = p;
	}

	public void setVisible(boolean b) {
		if(b == true)
			frmVejaMelhorO.setVisible(b);
		else
			frmVejaMelhorO.setVisible(b);
	}

	public static void carregarTabela(DefaultTableModel modelo, List<Comprador> compradores) {
		if (compradores != null) {
			for (Comprador c : compradores) {
				modelo.addRow(new String[] {
						c.getNome()});
			}

		}

	}

	public class EventoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frmVejaMelhorO.dispose();
			TelaVendedor telaVendedor = new TelaVendedor(v);
			telaVendedor.setVisible(true);
		}
	}

	public class EventoEditar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frmVejaMelhorO.dispose();
			TelaEditarProduto t = new TelaEditarProduto(p, v);
			t.setVisible(true);
		}
	}

	public class EventoVender implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int linha_selecionada = table.getSelectedRow();
			String nomeComp = null;
			Comprador comp = null;

			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null,
						"Nenhum produto selecionado!");
			} else {
				nomeComp = (String) table.getValueAt(linha_selecionada, 0);
				try {
					comp = f.retornarComprador(nomeComp);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null,
							"Argumento inválido");
				} catch (NaoEncontradoCompradorException e1) {
					JOptionPane.showMessageDialog(null,
							e1.getMessage());
				}
				frmVejaMelhorO.dispose();
				TelaVendedorConfirmarVenda t = new TelaVendedorConfirmarVenda(v, comp, p);
				t.setVisible(true);
			}
		}
	}
}

