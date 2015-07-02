package br.ufrpe.gui.telas_principais;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import br.ufrpe.gui.telas_exibir_info.TelaExibirInfoComprador;
import br.ufrpe.negocio.classes_basicas.Comprador;

public class TelaComprador_Principal {
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private JButton btnSair;
	private JButton btnProdutosInteresse;
	private JButton btnVerFavoritos;
	private JButton btnPesquisar;
	private TelaComprador_Favoritos telaComprFav;
	private TelaComprador_Interesse telaComprInt;
	private TelaPesquisarProdutos telaPesqProd;
	private TelaExibirInfoComprador telaExibirInfoComprador;
	
	private Comprador comprador;
	
	
	/**
	 * Create the application.
	 */
	public TelaComprador_Principal(Comprador c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Comprador c) {
		frmMeuPerfil = new JFrame();
		frmMeuPerfil.setResizable(false);
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 487);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		telaPesqProd = new TelaPesquisarProdutos(c);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 690, 458);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		table.setBounds(25, 216, 630, 160);
		panel.add(table);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setBounds(14, 33, 114, 29);
		panel.add(lblPerfil);
		lblPerfil.setFont(new Font("Gisha", Font.BOLD, 24));
		
		btnPesquisar = new JButton("Pesquisar!");
		btnPesquisar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnPesquisar.setBounds(510, 176, 128, 29);
		panel.add(btnPesquisar);
		
		EventoBotaoPesquisar acaoBtnPesquisar = new EventoBotaoPesquisar();
		btnPesquisar.addActionListener(acaoBtnPesquisar);
		
		JLabel lblBemVindo = new JLabel("Bem-vindo,");
		lblBemVindo.setBounds(14, 73, 65, 17);
		panel.add(lblBemVindo);
		lblBemVindo.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Meus produtos");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 181, 200, 29);
		panel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setBounds(89, 73, 156, 17);
		lblUser.setText(c.getNomeUsuario());
		panel.add(lblUser);
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblVocTem = new JLabel("Voc\u00EA comprou");
		lblVocTem.setBounds(14, 101, 97, 17);
		panel.add(lblVocTem);
		lblVocTem.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtd.setBounds(99, 101, 67, 17);
		if(c.getProdAdquiridos() == null)
			lblQtd.setText("00");
		else
			lblQtd.setText("" + c.getProdAdquiridos());
		lblQtd.setFont(new Font("Gisha", Font.BOLD, 13));
		panel.add(lblQtd);
		
		JLabel lblVenda = new JLabel("produto(s)");
		lblVenda.setBounds(176, 101, 104, 17);
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA est\u00E1 interessado na compra de");
		lblXpDisponvel.setBounds(14, 129, 215, 17);
		panel.add(lblXpDisponvel);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel label = new JLabel("qtd");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(242, 129, 48, 17);
		if(c.getProdInteresses() == null)
			label.setText("00");
		else
			label.setText("" + c.getProdInteresses());
		panel.add(label);
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel lblProdutos = new JLabel("produto(s)");
		lblProdutos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblProdutos.setBounds(300, 129, 74, 17);
		panel.add(lblProdutos);
		
		//botoes
		btnSair = new JButton("Sair");
		btnSair.setForeground(Color.BLUE);
		btnSair.setBorder(null);
		btnSair.setContentAreaFilled(false);
		btnSair.setBackground(null);
		btnSair.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnSair.setBounds(615, 11, 55, 25);
		panel.add(btnSair);
		
		EventoBotaoSair acaoBtnSair = new EventoBotaoSair();
		btnSair.addActionListener(acaoBtnSair);
	
		btnVerFavoritos = new JButton("Ver favoritos");
		btnVerFavoritos.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVerFavoritos.setBounds(56, 402, 163, 23);
		panel.add(btnVerFavoritos);
		
		EventoBotaoVerFavoritos acaoBtnVerFavoritos = new EventoBotaoVerFavoritos();
		btnVerFavoritos.addActionListener(acaoBtnVerFavoritos);
		
		btnProdutosInteresse = new JButton("Ver produtos de interesse");
		btnProdutosInteresse.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnProdutosInteresse.setBounds(415, 402, 210, 23);
		panel.add(btnProdutosInteresse);
		
		JButton btnMeusDados = new JButton("Meus dados");
		btnMeusDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMeuPerfil.dispose();
				telaExibirInfoComprador = new TelaExibirInfoComprador(comprador);
				telaExibirInfoComprador.setVisible(true);
			}
		});
		btnMeusDados.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnMeusDados.setBounds(259, 403, 115, 23);
		panel.add(btnMeusDados);
		
		EventoBotaoProdutosInteresse acaoBtnProdutosInteresse = new EventoBotaoProdutosInteresse();
		btnProdutosInteresse.addActionListener(acaoBtnProdutosInteresse);
		
	}
	
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	
	public void setVisible(boolean b) {
		if(b == true)
			frmMeuPerfil.setVisible(b);
		else
			frmMeuPerfil.setVisible(b);
	}
	
	private class EventoBotaoVerFavoritos implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmMeuPerfil.dispose();
			telaComprFav = new TelaComprador_Favoritos(comprador);
			telaComprFav.setVisible(true);
		}
	}
	
	private class EventoBotaoProdutosInteresse implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmMeuPerfil.dispose();
			telaComprInt = new TelaComprador_Interesse(comprador);
			telaComprInt.setVisible(true);
		}
	}
	
	private class EventoBotaoPesquisar implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			frmMeuPerfil.dispose();
			telaPesqProd = new TelaPesquisarProdutos(comprador);
			telaPesqProd.setVisible(true);
		}
	}
	
	private class EventoBotaoSair implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmMeuPerfil.dispose();
		}
	}
}
