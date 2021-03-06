package br.ufrpe.gui.telas_editar;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.QuantidadeMaximaItensUltrapassadaException;

import javax.swing.SpinnerNumberModel;

public class TelaEditarProduto{
	private JFrame frame;
	private Vendedor v;
	private Produto p;
	private Fachada f;
	private TelaVendedor telaVendedor;
	public TelaEditarProduto(Produto p, Vendedor v) {
		setProduto(p);
		setVendedor(v);
		f = Fachada.getInstance();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(490,355);
		frame.setTitle("Atualiza\u00E7\u00E3o de informa\u00E7\u00F5es sobre o produto");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 486, 328);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnConfirmar = new JButton("Confirmar");
		EventoEditar e1 = new EventoEditar();
		btnConfirmar.addActionListener(e1);
		
		btnConfirmar.setBounds(261, 272, 95, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));

		comboBoxCategoria = new JComboBox<>();
		comboBoxCategoria.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxCategoria.setBounds(95, 90, 172, 25);
		panel.add(comboBoxCategoria);
		
		comboBoxCategoria.addItem(" ");
		comboBoxCategoria.addItem("Auto");
		comboBoxCategoria.addItem("Roupas");
		comboBoxCategoria.addItem("Celulares");
		comboBoxCategoria.addItem("M�veis");
		comboBoxCategoria.addItem("Livros e M�dias Digitais");
		comboBoxCategoria.addItem("Eletrodom�stico");
		comboBoxCategoria.addItem("Eletroport�teis");
		comboBoxCategoria.addItem("Eletroeletr�nicos");
		comboBoxCategoria.addItem("Info");
		comboBoxCategoria.addItem("Games e Console");
		comboBoxCategoria.addItem("Cama, Mesa e Banho");
		comboBoxCategoria.addItem("Casa e Jardim");
		comboBoxCategoria.addItem("TV e �udio");
		comboBoxCategoria.addItem("Instrumentos Musicais");
		comboBoxCategoria.addItem("Brinquedos");
		comboBoxCategoria.addItem("Beleza e Sa�de");

		JButton btnVoltar = new JButton("Voltar");
		EventoVoltar e = new EventoVoltar();
		btnVoltar.addActionListener(e);
		
		
		btnVoltar.setBounds(127, 272, 67, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(25, 131, 60, 17);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(308, 60, 36, 17);
		panel.add(lblPreo);
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 13));

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinner.setFont(new Font("Gisha", Font.PLAIN, 13));
		spinner.setBounds(378, 90, 78, 25);
		panel.add(spinner);

		JLabel lblNueoueNecessuerio = new JLabel("N\u00E3o \u00E9 necess\u00E1rio a inclus\u00E3o de todos os dados para a conclus\u00E3o da atualiza\u00E7\u00E3o.");
		lblNueoueNecessuerio.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNueoueNecessuerio.setBounds(26, 227, 399, 34);
		panel.add(lblNueoueNecessuerio);

		textField = new JTextField();
		textField.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField.setBounds(74, 57, 208, 22);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 60, 39, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblAtualizeSeuProduto = new JLabel("Atualize seu produto");
		lblAtualizeSeuProduto.setBounds(127, 21, 172, 22);
		panel.add(lblAtualizeSeuProduto);
		lblAtualizeSeuProduto.setFont(new Font("Gisha", Font.PLAIN, 18));

		textArea = new JTextArea("");
		textArea.setFont(new Font("Gisha", Font.PLAIN, 13));
		textArea.setBounds(100, 152, 356, 68);
		panel.add(textArea);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_2.setBounds(368, 57, 82, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(25, 90, 85, 36);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(297, 93, 82, 28);
		panel.add(lblNewLabel_1);

		}

		private void setVendedor(Vendedor v) {
			this.v = v;
		}
		private void setProduto(Produto p) {
			this.p = p;
		}
		
		
		public class EventoVoltar implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TelaVendedor telaVendedor = new TelaVendedor(v);
				telaVendedor.setVisible(true);
			}
		}
		
		public class EventoEditar implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Produto pd = new Produto();
				try{
					
					if (p.getItensNoEstoque() == p.getQuantidade()){
						if (!textField.getText().equals("")) pd.setNome(textField.getText());
						else pd.setNome(p.getNome());
						if(!textField_2.getText().equals("")) pd.setPreco(Double.parseDouble(textField_2.getText()));
						else pd.setPreco(p.getPreco());

						if(!textArea.getText().equals(""))	pd.setDescricao(textArea.getText());
						else pd.setDescricao(p.getDescricao());

						if (!(comboBoxCategoria.getSelectedItem().equals("")))	pd.setCategoria((String)comboBoxCategoria.getSelectedItem());
						else pd.setCategoria(p.getCategoria());
						if (!spinner.getValue().equals("")){
							try {
								pd.setQuantidade((Integer) spinner.getValue());
							} catch (QuantidadeMaximaItensUltrapassadaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						} else
							try {
								pd.setQuantidade(p.getQuantidade());
							} catch (QuantidadeMaximaItensUltrapassadaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						f.removerProduto(p);
						f.cadastrarProduto(pd, v);
						f.salvarProduto();
						setProduto(pd);
						frame.dispose();
						telaVendedor = new TelaVendedor(v);
						telaVendedor.setVisible(true);
						JOptionPane.showMessageDialog(null, "Atualiza��o feita com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Voc� j� vendeu um produto, infelizmente n�o pode mais alterar mais nada quanto ao produto.");
					}
						
					} catch (NaoEncontradoProdutoException | IllegalArgumentException | ProdutoJaCadastradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} 		


				}
		}

		private JTextField textField;
		private JTextArea textArea;
		private JTextField textField_2;
		private JButton btnConfirmar;
		private JPanel panel;
		private JSpinner spinner;
		private JComboBox<String> comboBoxCategoria;
		
		public void setVisible(boolean b) {
			if (b == true) frame.setVisible(b);
			else frame.setVisible(b);
		}
	}
