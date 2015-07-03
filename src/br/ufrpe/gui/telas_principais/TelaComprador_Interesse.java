package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.SystemColor;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaComprador_Interesse {
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private Comprador c;
	Fachada fachada;
	/**
	 * Create the application.
	 */
	public TelaComprador_Interesse(Comprador c) {
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
		frmMeuPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 690, 369);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMeuPerfil.dispose();
				TelaComprador_Principal telaComprador_Principal = new TelaComprador_Principal(null);
				telaComprador_Principal.setVisible(true);
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

		carregarTabela(modelo, c.getProdutosInteressantes());

		JLabel lblNewLabel = new JLabel("Produtos de interesse");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 91, 200, 29);
		panel.add(lblNewLabel);

		JLabel lblVoceEsta = new JLabel("Voc\u00EA está interessado em");
		lblVoceEsta.setBounds(20, 69, 168, 17);
		panel.add(lblVoceEsta);
		lblVoceEsta.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel label = new JLabel("qtd");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(185, 69, 44, 17);
		panel.add(label);
		label.setText("" + c.getQuantProdInteresses());
		label.setFont(new Font("Gisha", Font.BOLD, 13));

		JLabel lblProdutos = new JLabel("produto(s)");
		lblProdutos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblProdutos.setBounds(246, 69, 84, 17);
		panel.add(lblProdutos);

		btnNewButton_1 = new JButton("Não tenho mais interesse");
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(384, 317, 210, 23);
		panel.add(btnNewButton_1);
		
		EventoNaoTenhoMaisInteresse evento = new EventoNaoTenhoMaisInteresse();
		btnNewButton_1.addActionListener(evento);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 18));
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setBounds(26, 23, 200, 38);
		lblUser.setText(c.getNomeUsuario());
		panel.add(lblUser);
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	private void setComprador(Comprador c) {
		this.c = c;		
	}

	
	public class EventoNaoTenhoMaisInteresse implements ActionListener{

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
                     fachada.removerDosInteresses(c, prod);
                     prod.getCompradoresInteressados().remove(c);
                     frmMeuPerfil.dispose();
                     TelaComprador_Principal t = new TelaComprador_Principal(c);
                     t.setVisible(true);

             }
		}
		
	}
	public void setVisible(boolean b) {
		if(b == true)
			frmMeuPerfil.setVisible(b);
		else
			frmMeuPerfil.setVisible(b);
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
