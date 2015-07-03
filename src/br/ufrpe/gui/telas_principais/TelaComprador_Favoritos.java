package br.ufrpe.gui.telas_principais;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;

public class TelaComprador_Favoritos {
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton_1;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnNewButton;
	private Comprador c;
	private Fachada fachada;
	/**
	 * Create the application.
	 */
	public TelaComprador_Favoritos(Comprador c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Comprador c) {
		setComprador(c);
		
		fachada = Fachada.getInstance();
		frmMeuPerfil = new JFrame();
		frmMeuPerfil.setResizable(false);
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 398);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 690, 369);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaComprador_Favoritos.dispose();
				TelaComprador_Favoritos TelaComprador_Favoritos = new TelaComprador_Favoritos(c);
				TelaComprador_Favoritos.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(77, 317, 163, 23);
		panel.add(btnNewButton);
		
		modelo.setRowCount(0);
		modelo.addColumn("Nome");
		modelo.addColumn("Categoria");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço");
		modelo.addColumn("Vendedor");

		table = new JTable(modelo);
		table.setFont(new Font("Gisha", Font.PLAIN, 13));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 131, 630, 160);
		panel.add(barraRolagem);

		carregarTabela(modelo, c.getFavoritos());
	

		
		JLabel lblNewLabel = new JLabel("Produtos favoritos");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 91, 200, 29);
		panel.add(lblNewLabel);
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA tem");
		lblXpDisponvel.setBounds(21, 69, 74, 17);
		panel.add(lblXpDisponvel);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel label = new JLabel("qtd");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(83, 69, 44, 17);
		panel.add(label);
		label.setText("" + c.getQuantProdFavoritos());
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel lblProdutos = new JLabel("produto(s) favorito(s)");
		lblProdutos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblProdutos.setBounds(136, 69, 146, 17);
		panel.add(lblProdutos);
		
		btnNewButton_1 = new JButton("Remover dos favoritos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(384, 317, 210, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(26, 23, 200, 38);
		lblNewLabel_1.setText(c.getNomeUsuario());
		panel.add(lblNewLabel_1);
	}
	
	private void setComprador(Comprador c) {
		this.c = c;
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		if(b == true)
			frmMeuPerfil.setVisible(b);
		else
			frmMeuPerfil.setVisible(b);
	}
	
	public class EventoDesfavoritar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			 int linha_selecionada = table.getSelectedRow();
             String nomeProd = null;
             String nomeVend = null;
             Produto prod = null;
             Vendedor vend = null;

             if (table.getSelectedRow() < 0) {
                     JOptionPane.showMessageDialog(null,
                                     "Nenhum produto selecionado!");
             } else {
                     nomeProd = (String) table.getValueAt(linha_selecionada, 0);
                     nomeVend = (String) table.getValueAt(linha_selecionada, 4);
                     try {
						vend = fachada.retornarVendedor(nomeVend);
					} catch (IllegalArgumentException e2) {
						JOptionPane.showMessageDialog(null, "Argumento inválido", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					} catch (NaoEncontradoVendedorException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

					}
                     try {
						prod = fachada.retornarProduto(nomeProd, vend, null);
					} catch (IllegalArgumentException e1) {
						JOptionPane.showMessageDialog(null, "Argumento inválido", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

					} catch (NaoEncontradoProdutoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

					}
                     fachada.removerDosFavoritos(c, prod);
                     frmMeuPerfil.dispose();
                     TelaComprador_Principal t = new TelaComprador_Principal(c);
                     t.setVisible(true);

             }
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
							p.getPreco(), p.getVendedor().getNomeUsuario()});
				}
			}
		}

	}

}
