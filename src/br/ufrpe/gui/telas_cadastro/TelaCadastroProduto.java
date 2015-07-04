package br.ufrpe.gui.telas_cadastro;

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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.QuantidadeMaximaItensUltrapassadaException;

public class TelaCadastroProduto{

	private JFrame frame;
	private JTabbedPane conteiner;
	private JPanel painel1;
	private JPanel painel2;
	private JLabel lblNome;
	private JLabel lblCategoria;
	private JLabel lblQuantidade;
	private JLabel lblPreco;
	private JLabel lblDescricao;

	private JTextField textFieldNome;
	private JTextArea textDescricao;
	private JComboBox<String> comboBoxCategoria;
	private JComboBox<String> comboBoxQuant;
	private JButton btnOk;
	private JTextField preco;
	private Vendedor v;
	private Produto p;
	private Fachada fachada;

	/**
	 * Create the application.
	 */
	public TelaCadastroProduto(Vendedor v) {
		initialize(v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vendedor v) {
		setVendedor(v);
		p = new Produto();
		fachada = Fachada.getInstance();
		frame = new JFrame("Cadastro de Produtos");
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 500, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		conteiner = new JTabbedPane();
		conteiner.setFont(new Font("Gisha", Font.PLAIN, 14));
		conteiner.setSize(500, 244);
		painel1 = new JPanel();
		painel2 = new JPanel();
		painel1.setLayout(null);
		painel2.setLayout(null);

		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(23, 11, 57, 17);
		lblDescricao.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel2.add(lblDescricao);


		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel1.add(lblNome);
		lblNome.setBounds(16, 26, 36, 17);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(57, 23, 415, 23);
		textFieldNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldNome.setColumns(20);
		painel1.add(textFieldNome);

		comboBoxQuant = new JComboBox<String>();
		comboBoxQuant.setMaximumRowCount(4);
		comboBoxQuant.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxQuant.setBounds(409, 64, 63, 20);

		comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.setMaximumRowCount(14);
		comboBoxCategoria.setBounds(83, 62, 187, 23);
		comboBoxCategoria.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxCategoria.addItem(" ");
		comboBoxCategoria.addItem("Auto");
		comboBoxCategoria.addItem("Roupas");
		comboBoxCategoria.addItem("Celulares");
		comboBoxCategoria.addItem("Móveis");
		comboBoxCategoria.addItem("Livros e Mídias Digitais");
		comboBoxCategoria.addItem("Eletrodoméstico");
		comboBoxCategoria.addItem("Eletroportáteis");
		comboBoxCategoria.addItem("Eletroeletroônicos");
		comboBoxCategoria.addItem("Info");
		comboBoxCategoria.addItem("Games e Console");
		comboBoxCategoria.addItem("Cama, Mesa e Banho");
		comboBoxCategoria.addItem("Casa e Jardim");
		comboBoxCategoria.addItem("TV e Áudio");
		comboBoxCategoria.addItem("Instrumentos Musicais");
		comboBoxCategoria.addItem("Brinquedos");
		comboBoxCategoria.addItem("Beleza e Saúde");

		preco = new JTextField();
		preco.setFont(new Font("Gisha", Font.PLAIN, 13));
		preco.setBounds(62, 112, 105, 20);
		painel1.add(preco);
		preco.setColumns(10);

		painel1.add(comboBoxCategoria);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(16, 65, 57, 17);
		lblCategoria.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel1.add(lblCategoria);

		lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(16, 111, 36, 23);
		lblPreco.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel1.add(lblPreco);

		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(327, 53, 70, 41);
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel1.add(lblQuantidade);
		
		comboBoxQuant.addItem(" ");
		comboBoxQuant.addItem("1");
		comboBoxQuant.addItem("2");
		comboBoxQuant.addItem("3");
		painel1.add(comboBoxQuant);

		textDescricao = new JTextArea("");
		textDescricao.setFont(new Font("Gisha", Font.PLAIN, 14));
		textDescricao.setBounds(23, 33, 353, 139);
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel2.add(textDescricao);

		//adição dos conteineres ao frame
		conteiner.add(painel1);
		conteiner.setEnabledAt(0, true);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//vai pra proxima aba se n houver nenhum espaço em braco
				if(textFieldNome.getText().equals("") || preco.getText().equals("") || (comboBoxCategoria.getSelectedIndex() == 0 ||
						comboBoxQuant.getSelectedIndex() == 0)) {
					
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!");
				}
				else {
					p.setNome(textFieldNome.getText());
					p.setPreco(Double.parseDouble(preco.getText()));
					p.setCategoria((String) comboBoxCategoria.getSelectedItem());
					conteiner.setSelectedIndex(1);
				}
					
			}
		});
		btnContinuar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnContinuar.setBounds(297, 159, 89, 23);
		painel1.add(btnContinuar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto.dispose();
				TelaVendedor telaVendedor = new TelaVendedor(v);
				telaVendedor.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVoltar.setBounds(126, 160, 89, 23);
		painel1.add(btnVoltar);
		conteiner.setTitleAt(0, "Informa\u00E7\u00F5es");//ver o que é esse zero
		conteiner.add(painel2);

		btnOk = new JButton("Cadastrar");
		btnOk.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnOk.setBounds(386, 84, 89, 23);
		painel2.add(btnOk);
		
		EventoCadastrarProduto btnCadastrarProduto = new EventoCadastrarProduto();
		btnOk.addActionListener(btnCadastrarProduto);
		
		conteiner.setTitleAt(1, "Descri\u00E7\u00E3o");
		frame.getContentPane().add(conteiner);


	}

	private void setVendedor(Vendedor v) {
		this.v  = v;
		
	}

	public class EventoCadastrarProduto implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if(textFieldNome.equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Nome' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			} else if (comboBoxCategoria.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Categoria' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			} else if (comboBoxQuant.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Quantidade' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
			} else if (preco.equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Preço' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			} else if (textDescricao.equals("")) {
				JOptionPane.showMessageDialog(null, "O campo 'Descrição' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			}else{
				p.setCategoria((String) comboBoxCategoria.getSelectedItem());
				p.setCompradoresInteressados(null);
				p.setDescricao(textDescricao.getText());
				p.setEstado(false);
				int quantidadeItens = Integer.parseInt((String)comboBoxQuant.getSelectedItem());
				try {
					p.setQuantidade(quantidadeItens);
				} catch (QuantidadeMaximaItensUltrapassadaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				p.setItensNoEstoque(quantidadeItens);
				p.setPontos(0);
				p.setPreco(Double.parseDouble(preco.getText()));
				p.setVendedor(v);
				try {
					fachada.cadastrarProduto(p, v);
				} catch (ProdutoJaCadastradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	protected static void dispose() {
		// TODO Auto-generated method stub

	}

	public void setVisible(boolean b) {
	 if(b == true) frame.setVisible(b);
	 else frame.setVisible(b);
	}
}
