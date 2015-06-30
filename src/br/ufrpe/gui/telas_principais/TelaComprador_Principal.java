package br.ufrpe.gui.telas_principais;

import java.awt.Color;
import java.awt.EventQueue;
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

import br.ufrpe.negocio.classes_basicas.Comprador;

public class TelaComprador_Principal {
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private JButton btnSair;
	private JButton btnProdutosInteresse;
	private JButton btnVerFavoritos;
	private Comprador comprador;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaComprador_Principal window = new TelaComprador_Principal();
//					window.frmMeuPerfil.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the application.
	 */
	public TelaComprador_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuPerfil = new JFrame();
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 487);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 680, 448);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		table.setCellSelectionEnabled(true);
		table.setBounds(25, 216, 630, 160);
		panel.add(table);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setBounds(14, 33, 114, 29);
		panel.add(lblPerfil);
		lblPerfil.setFont(new Font("Gisha", Font.BOLD, 24));
		
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
		panel.add(lblUser);
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblVocTem = new JLabel("Voc\u00EA comprou");
		lblVocTem.setBounds(14, 101, 97, 17);
		panel.add(lblVocTem);
		lblVocTem.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblVenda = new JLabel("produto(s)");
		lblVenda.setBounds(176, 101, 104, 17);
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA est\u00E1 interessado na compra de");
		lblXpDisponvel.setBounds(14, 129, 215, 17);
		panel.add(lblXpDisponvel);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtd.setBounds(99, 101, 67, 17);
		panel.add(lblQtd);
		lblQtd.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel label = new JLabel("qtd");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(242, 129, 48, 17);
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
		btnVerFavoritos.setBounds(89, 402, 163, 23);
		panel.add(btnVerFavoritos);
		
		EventoBotaoVerFavoritos acaoBtnVerFavoritos = new EventoBotaoVerFavoritos();
		btnVerFavoritos.addActionListener(acaoBtnVerFavoritos);
		
		btnProdutosInteresse = new JButton("Ver produtos de interesse");
		btnProdutosInteresse.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnProdutosInteresse.setBounds(391, 402, 210, 23);
		panel.add(btnProdutosInteresse);
		
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
			
		}
	}
	
	private class EventoBotaoProdutosInteresse implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			
		}
	}
	
	private class EventoBotaoSair implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frmMeuPerfil.dispose();
		}
	}
}
