package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.gui.telas_exibir_info.TelaExibirInfoProduto_Comprador;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.filtro.Filtro;

public class TelaPesquisarProdutos extends JFrame {
	
	/**
	 * verificar se deu algo
	 */
	private static final long serialVersionUID = 1L;
	private Filtro filtro;
	private Fachada fachada;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldNome;
	private JComboBox<String> comboBox;
	private JLabel lblNomeDoProduto;
	private JLabel lblCategoria;
	private JLabel lblCidadeDoVendedor;
	private JTextField textFieldCidade;
	private JLabel lblDe;
	private JTextField textFieldDe;
	private JLabel lblA;
	private JTextField textFieldAte;
	private JLabel lblNoNecessrio;
	private DefaultTableModel modelo;
	private JTable table;
	private JButton btnVoltar;
	private JButton btnVer;
	private JButton btnFavoritar;
	private Comprador c;

	private TelaComprador_Principal telaComprPrincipal;
	private TelaExibirInfoProduto_Comprador telaExibirProduto;

	/**
	 * Create the frame.
	 */
	public TelaPesquisarProdutos(Comprador c) {
		setResizable(false);
		setComprador(c);
		setTitle("Pesquisa de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		fachada = Fachada.getInstance();

		modelo = new DefaultTableModel();
		modelo.setRowCount(0);
		modelo.addColumn("Nome");
		modelo.addColumn("Categoria");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço");
		modelo.addColumn("Vendedor");

		panel = new JPanel();
		panel.setBounds(5, 5, 597, 600);
		contentPane.add(panel);
		panel.setLayout(null);


		textFieldNome = new JTextField();
		textFieldNome.setBounds(130, 20, 439, 23);
		panel.add(textFieldNome);
		textFieldNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldNome.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar!");
		btnPesquisar.setBounds(361, 101, 208, 23);
		panel.add(btnPesquisar);
		btnPesquisar.setFont(new Font("Gisha", Font.PLAIN, 13));

		EventoBotaoPesquisar acaoBtnPesquisar = new EventoBotaoPesquisar();
		btnPesquisar.addActionListener(acaoBtnPesquisar);

		comboBox = new JComboBox<>();
		comboBox.setBounds(106, 61, 200, 23);
		comboBox.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBox.addItem("Auto");
		comboBox.addItem("Roupas");
		comboBox.addItem("Celulares");
		comboBox.addItem("Móveis");
		comboBox.addItem("Livros e Mídias Digitais");
		comboBox.addItem("Eletrodoméstico");
		comboBox.addItem("Eletroportáteis");
		comboBox.addItem("Eletroeletrônico");
		comboBox.addItem("Info");
		comboBox.addItem("Games e Consoles");
		comboBox.addItem("Cama, Mesa e Banho");
		comboBox.addItem("Casa e Jardim");
		comboBox.addItem("TV e Áudio");
		comboBox.addItem("Instrumentos Musicais");
		comboBox.addItem("Brinquedos");
		comboBox.addItem("Beleza e Saúde");

		panel.add(comboBox);

		lblNomeDoProduto = new JLabel("Nome do produto");
		lblNomeDoProduto.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNomeDoProduto.setBounds(10, 13, 143, 37);
		panel.add(lblNomeDoProduto);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblCategoria.setBounds(10, 55, 86, 35);
		panel.add(lblCategoria);

		textFieldDe = new JTextField();
		textFieldDe.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldDe.setBounds(361, 60, 86, 23);
		panel.add(textFieldDe);
		textFieldDe.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVoltar.setBounds(145, 510, 89, 23);
		panel.add(btnVoltar);

		EventoBotaoVoltar acaoBotaoVoltar = new EventoBotaoVoltar();
		btnVoltar.addActionListener(acaoBotaoVoltar);

		lblCidadeDoVendedor = new JLabel("Cidade do vendedor");
		lblCidadeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblCidadeDoVendedor.setBounds(10, 94, 125, 37);
		panel.add(lblCidadeDoVendedor);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldCidade.setBounds(145, 101, 206, 23);
		panel.add(textFieldCidade);
		textFieldCidade.setColumns(10);

		btnFavoritar = new JButton("Favoritar");
		btnFavoritar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnFavoritar.setBounds(378, 510, 89, 23);
		panel.add(btnFavoritar);
		
		EventoBotaoFavoritar acaoBtnFavoritar = new EventoBotaoFavoritar();
		btnFavoritar.addActionListener(acaoBtnFavoritar);

		textFieldAte = new JTextField();
		textFieldAte.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldAte.setBounds(483, 60, 86, 23);
		panel.add(textFieldAte);
		textFieldAte.setColumns(10);

		table = new JTable(modelo);
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		carregarTabela(modelo, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 169, 539, 330);
		panel.add(scrollPane);


		lblDe = new JLabel("De");
		lblDe.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblDe.setBounds(327, 55, 24, 36);
		panel.add(lblDe);

		lblA = new JLabel("até");
		lblA.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblA.setBounds(458, 53, 22, 37);
		panel.add(lblA);

		lblNoNecessrio = new JLabel("N\u00E3o \u00E9 necess\u00E1rio a inclus\u00E3o de todos os dados para a realiza\u00E7\u00E3o da pesquisa.");
		lblNoNecessrio.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNoNecessrio.setBounds(20, 135, 406, 23);
		panel.add(lblNoNecessrio);

		btnVer = new JButton("Ver");
		btnVer.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVer.setBounds(262, 510, 89, 23);
		panel.add(btnVer);
		
		EventoBotaoVer acaoBotaoVer = new EventoBotaoVer();
		btnVer.addActionListener(acaoBotaoVer);

	}
	public void setComprador(Comprador c) {
		this.c = c;
	}
	
	public void setVisible(boolean b) {
		if(b == true)
			setVisible(b);
		else
			setVisible(b);
	}
	
	
	private class EventoBotaoPesquisar implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			List<Produto> produtos = new ArrayList<>();
			double de;
			if (textFieldDe.equals("") == false){
				de = Double.parseDouble(textFieldDe.getSelectedText());
			} else de = 0.0;
			double ate; 
			if (textFieldAte.equals("") == false){
				ate = Double.parseDouble(textFieldAte.getSelectedText());
			} else ate = 0.0;
			filtro = new Filtro(textFieldNome.getSelectedText(), (String) comboBox.getSelectedItem(), de, ate, textFieldCidade.getSelectedText());		
			try {
				produtos = fachada.buscarProdutos(filtro);
				produtos = fachada.organizarProdutos(produtos);
				carregarTabela(modelo, produtos);
			} catch (NaoEncontradoProdutoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (NullPointerException | IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, "Argumento inválido");
			}

		}
	}

	private class EventoBotaoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			setVisible(false);
			TelaComprador_Principal telaComprador_Principal = new TelaComprador_Principal(c);
			telaComprador_Principal.setVisible(true);
			
		}
	}

	private class EventoBotaoFavoritar implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			int linhaSelecionada = table.getSelectedRow();
			String nomeProduto;
			String nomeVendedor; //nome usuario
			Vendedor v = null;
			Produto p = null;

			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null,
						"Nenhum produto selecionado! Selecione um para favoritar.");
			} else {
				nomeProduto = (String) table.getValueAt(linhaSelecionada, 0);
				nomeVendedor = (String) table.getValueAt(linhaSelecionada, 4);
				if (!nomeVendedor.equals("") && !nomeProduto.equals("")){
					try {
						v = fachada.retornarVendedor(nomeVendedor);
					} catch (NaoEncontradoVendedorException e) {
						JOptionPane.showMessageDialog(null,
								"Nenhum vendedor encontrado!");
					}
					try {
						p = fachada.retornarProduto(nomeProduto, v, null);
					} catch (NaoEncontradoProdutoException e) {
						JOptionPane.showMessageDialog(null,
								"Nenhum produto encontrado, sorry!");
					}
				}
					//como faço para passar o produto para o comprador correto, como pegar a instancia do comprador
				//que esta pesquisando?
				fachada.adicionarAosFavoritos(c, p);
				JOptionPane.showMessageDialog(null,
						"Produto adicionado com sucesso em seus favoritos!");
			}
		}
	}

	private class EventoBotaoVer implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			int linhaSelecionada = table.getSelectedRow();
			Produto p = null;
			Vendedor v = null;
			String nomeProduto;
			String nomeVendedor;
			
			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null,
						"Nenhum produto selecionado! Selecione um produto para favoritar.");
			} else {
				nomeProduto = (String) table.getValueAt(linhaSelecionada,0);
				nomeVendedor = (String) table.getValueAt(linhaSelecionada, 4);
				try {
					v = fachada.retornarVendedor(nomeVendedor);
				} catch (NaoEncontradoVendedorException e1) {
					JOptionPane.showMessageDialog(null,
							e1.getMessage());
				}
				try {
					p = fachada.retornarProduto(nomeProduto, v, null);
				} catch (NaoEncontradoProdutoException e) {
					JOptionPane.showMessageDialog(null,
							e.getMessage());
				}
				Produto prod = null;
				try {
					prod = fachada.retornarProduto(p.getNome(), v, null);
				} catch (NaoEncontradoProdutoException e) {
					JOptionPane.showMessageDialog(null,
							e.getMessage());
				}
				dispose();
				telaExibirProduto = new TelaExibirInfoProduto_Comprador(prod);
				telaExibirProduto.setVisible(true);
			}
		}
	}

	public static void carregarTabela(DefaultTableModel modelo, List<Produto> produtos) {
		if (produtos != null) {
			for (Produto p : produtos) {
				modelo.addRow(new String[] {
						p.getNome(),  p.getCategoria(), "" + p.getItensNoEstoque(), "" + p.getPreco(),
						p.getVendedor().getNomeUsuario()});
			}

		}

	}
}
