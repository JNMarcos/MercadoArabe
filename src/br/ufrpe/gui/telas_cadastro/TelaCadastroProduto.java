package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;
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
	private JFormattedTextField formattedTextField;
	private JButton btnOk;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto window = new TelaCadastroProduto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

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
		comboBoxCategoria.addItem("M�veis");
		comboBoxCategoria.addItem("Livros e M�dias Digitais");
		comboBoxCategoria.addItem("Eletrodom�stico");
		comboBoxCategoria.addItem("Eletroport�teis");
		comboBoxCategoria.addItem("Eletroeletro�nicos");
		comboBoxCategoria.addItem("Info");
		comboBoxCategoria.addItem("Games e Console");
		comboBoxCategoria.addItem("Cama, Mesa e Banho");
		comboBoxCategoria.addItem("Casa e Jardim");
		comboBoxCategoria.addItem("TV e �udio");
		comboBoxCategoria.addItem("Instrumentos Musicais");
		comboBoxCategoria.addItem("Brinquedos");
		comboBoxCategoria.addItem("Beleza e Sa�de");
		
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
		
		//adi��o dos conteineres ao frame
		conteiner.add(painel1);
		conteiner.setEnabledAt(0, true);
		
		
		
		//tem que VER COMO POR MAIS TIPOS DE FORMATOS
		formattedTextField = new JFormattedTextField("");
		try {
			MaskFormatter formato1 = new MaskFormatter("R$ ###.###,##");
			MaskFormatter formato2 = new MaskFormatter("R$ ##.###,##");
			MaskFormatter formato3 = new MaskFormatter("R$ #.###,##");
			MaskFormatter formato4 = new MaskFormatter("R$ ###,##");
			MaskFormatter formato5 = new MaskFormatter("R$ ##,##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formattedTextField.setBounds(70, 111, 81, 23);
		painel1.add(formattedTextField);
		conteiner.setTitleAt(0, "Informa\u00E7\u00F5es");//ver o que � esse zero
		conteiner.add(painel2);
		
		btnOk = new JButton("OK");
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
}
