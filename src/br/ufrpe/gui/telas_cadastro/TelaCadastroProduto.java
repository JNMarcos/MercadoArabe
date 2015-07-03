package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JLabel lblImagem;

	private JTextField textFieldNome;
	private JTextArea textDescricao;
	private JComboBox<String> comboBoxCategoria;
	private JComboBox<String> comboBoxQuant;
	private JButton btnOk;
	private JButton btnNewButton;
	private JTextField Preco;
	private Produto p;
	private Fachada fachada;

	/**
	 * Create the application.
	 */
	public TelaCadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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


		lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(23, 10, 47, 17);
		lblImagem.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel2.add(lblImagem);

		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(23, 38, 57, 17);
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
		comboBoxQuant.addItem("1");
		comboBoxQuant.addItem("2");
		comboBoxQuant.addItem("3");

		comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.setMaximumRowCount(14);
		comboBoxCategoria.setBounds(83, 62, 187, 23);
		comboBoxCategoria.setFont(new Font("Gisha", Font.PLAIN, 13));
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

		Preco = new JTextField();
		Preco.setFont(new Font("Gisha", Font.PLAIN, 13));
		Preco.setBounds(62, 112, 105, 20);
		painel1.add(Preco);
		Preco.setColumns(10);

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

		comboBoxQuant.addItem("1");
		comboBoxQuant.addItem("2");
		comboBoxQuant.addItem("3");
		painel1.add(comboBoxQuant);

		textDescricao = new JTextArea("");
		textDescricao.setFont(new Font("Gisha", Font.PLAIN, 14));
		textDescricao.setBounds(23, 66, 353, 106);
		lblQuantidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		painel2.add(textDescricao);

		//adição dos conteineres ao frame
		conteiner.add(painel1);
		conteiner.setEnabledAt(0, true);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinuar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnContinuar.setBounds(297, 159, 89, 23);
		painel1.add(btnContinuar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto.dispose();
				TelaVendedor telaVendedor = new TelaVendedor(null);
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
		btnOk.setBounds(386, 110, 89, 23);
		painel2.add(btnOk);

		btnNewButton = new JButton("Selecionar");
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(80, 8, 126, 23);
		painel2.add(btnNewButton);
		conteiner.setTitleAt(1, "Descri\u00E7\u00E3o");
		frame.getContentPane().add(conteiner);


	}

	public class EventoCadastrarProduto implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if(textFieldNome.equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Nome' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			} else if (comboBoxCategoria.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Categoria' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			} else if (comboBoxQuant.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Quantidade' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
			} else if (Preco.equals("")){
				JOptionPane.showMessageDialog(null, "O campo 'Preço' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			} else{
				fachad
			}
		}

	}

	protected static void dispose() {
		// TODO Auto-generated method stub

	}
}
