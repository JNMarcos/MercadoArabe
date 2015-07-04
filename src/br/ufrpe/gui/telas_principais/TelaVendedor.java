package br.ufrpe.gui.telas_principais;

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

import br.ufrpe.gui.telas_cadastro.TelaCadastroProduto;
import br.ufrpe.gui.telas_exibir_info.TelaExibirInfoProduto_Vendedor;
import br.ufrpe.gui.telas_exibir_info.TelaExibirInfoVendedor_Vendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;

public class TelaVendedor {

	private JFrame frmMeuPerfil;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private TelaInicio telaInicio;
	private Vendedor v;
	private TelaExibirInfoVendedor_Vendedor telaExibeInfoVendedor;
	JButton btnNovoProduto;
	Fachada fachada;

	/**
	 * Create the application.
	 */
	public TelaVendedor(Vendedor v) {
		initialize(v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vendedor v) {
		frmMeuPerfil = new JFrame();
		fachada = Fachada.getInstance();
		frmMeuPerfil.setResizable(false);
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 493);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		this.setVendedor(v);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 690, 464);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		modelo.setRowCount(0);
		modelo.addColumn("Nome");
		modelo.addColumn("Categoria");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço");
		
		table = new JTable(modelo);
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(34, 230, 630, 160);
		panel.add(barraRolagem);
		
		List<Produto> produtos = fachada.retornarProdutosDoVendedor(v);
		carregarTabela(modelo, produtos);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setBounds(14, 33, 114, 29);
		lblPerfil.setFont(new Font("Gisha", Font.BOLD, 24));
		panel.add(lblPerfil);
		
		JLabel lblNewLabel = new JLabel("Meus produtos");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 181, 200, 29);
		panel.add(lblNewLabel);
		
		JLabel lblBemVindo = new JLabel("Bem-vindo,");
		lblBemVindo.setBounds(14, 73, 65, 17);
		lblBemVindo.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblBemVindo);
		
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setBounds(89, 73, 156, 17);
		lblUser.setText(v.getNomeUsuario());
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblUser);
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.BLUE);
		btnSair.setBorder(null);
		btnSair.setContentAreaFilled(false);
		btnSair.setBackground(null);
		btnSair.setBounds(615, 11, 55, 25);
		btnSair.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnSair);
		
		EventoBotaoSair acaoBtnSair = new EventoBotaoSair();
		btnSair.addActionListener(acaoBtnSair);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVer.setBounds(293, 401, 89, 23);
		panel.add(btnVer);
		
		EventoBotaoVer acaoBtnVer = new EventoBotaoVer();
		btnVer.addActionListener(acaoBtnVer);
		
		JLabel lblVocTem = new JLabel("Voc\u00EA tem ");
		lblVocTem.setBounds(14, 101, 59, 17);
		lblVocTem.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblVocTem);
		
		JLabel lblVenda = new JLabel("produtos \u00E0 venda");
		lblVenda.setBounds(121, 101, 104, 17);
		lblVenda.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblVenda);
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA tem");
		lblXpDisponvel.setBounds(14, 132, 87, 17);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(lblXpDisponvel);

		/*
		JButton btnCompreMais = new JButton("Quero mais XPs!");
		btnCompreMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVendedor.dispose();
				TelaVendedor TelaCompraXP = new TelaVendedor();
				TelaCompraXP.setvisible(true);
				
			}
		});
		
		btnCompreMais.setBounds(174, 129, 145, 25);
		panel.add(btnCompreMais);
		btnCompreMais.setFont(new Font("Gisha", Font.PLAIN, 13));
		*/
		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setBounds(83, 101, 21, 17);
		lblQtd.setText("" + v.getQtdProdutosAVenda());
		lblQtd.setFont(new Font("Gisha", Font.BOLD, 13));
		panel.add(lblQtd);
		
		JLabel label = new JLabel("qtd");
		label.setBounds(83, 132, 21, 17);
		label.setText("" + v.getXp().getPontos());
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		panel.add(label);
		
		JLabel lblXps = new JLabel("XPs");
		lblXps.setForeground(Color.RED);
		lblXps.setFont(new Font("Gisha", Font.BOLD, 13));
		lblXps.setBounds(121, 126, 44, 29);
		panel.add(lblXps);
		
		btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.setFont(new Font("Gisha", Font.PLAIN, 13));
		Evento e = new Evento();
		btnNovoProduto.addActionListener(e);
		btnNovoProduto.setBounds(514, 186, 143, 23);
		panel.add(btnNovoProduto);
		
		JButton btnMeuPerfil = new JButton("Meu Perfil");
		btnMeuPerfil.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnMeuPerfil.setBounds(530, 98, 114, 23);
		panel.add(btnMeuPerfil);
		
		EventoMeuPerfil acaoMeuperfil = new EventoMeuPerfil();
		btnMeuPerfil.addActionListener(acaoMeuperfil);
	}
	
	public void setVendedor(Vendedor v) {
		this.v = v;
	}
	
	public void setVisible(boolean b) {
		if(b == true)
			frmMeuPerfil.setVisible(b);
		else
			frmMeuPerfil.setVisible(b);
	}
	
	private class EventoMeuPerfil implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmMeuPerfil.dispose();
			telaExibeInfoVendedor = new TelaExibirInfoVendedor_Vendedor(v);
			telaExibeInfoVendedor.setVisible(true);
		}
	}
	
	private class Evento implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frmMeuPerfil.dispose();
			TelaCadastroProduto tela = new TelaCadastroProduto(v);
			tela.setVisible(true);
		}
	} 
	
	private class EventoBotaoVer implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			int linha_selecionada = table.getSelectedRow();
            String nomeProd = null;
            Produto prod = null;

            if (table.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null,
                                    "Nenhum produto selecionado!");
            } else {
                    nomeProd = (String) (table.getValueAt(linha_selecionada, 0));
                    try {
						prod = fachada.retornarProduto(nomeProd, v, fachada.retornarListaProdutos());
					}  catch (NaoEncontradoProdutoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

					}
                    
                    frmMeuPerfil.dispose();
                    TelaExibirInfoProduto_Vendedor t = new TelaExibirInfoProduto_Vendedor(prod, v);
                    t.setVisible(true);
		}
	}
	}
	private class EventoBotaoSair implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmMeuPerfil.dispose();
			telaInicio = new TelaInicio();
			telaInicio.setVisible(true);
		}
	}
	public static void carregarTabela(DefaultTableModel modelo, List<Produto> produtos){
		modelo.setRowCount(0);

		if (produtos != null) {

			for (Produto p : produtos) {
				if (p == null) {
					break;
				} else { 
					modelo.addRow(new Object[] {
							p.getNome(),
							p.getCategoria(),
							p.getItensNoEstoque(), 
							p.getPreco()});
				}
			}
		}

	}
}
