package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaVendedor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendedor window = new TelaVendedor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		lblPerfil.setBounds(22, 21, 60, 21);
		frame.getContentPane().add(lblPerfil);
		
		JLabel lblBemVindo = new JLabel("Bem vindo");
		lblBemVindo.setBounds(22, 74, 60, 14);
		frame.getContentPane().add(lblBemVindo);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setBounds(80, 74, 46, 14);
		frame.getContentPane().add(lblUser);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(22, 216, 60, 21);
		frame.getContentPane().add(btnSair);
		
		JLabel lblVocTem = new JLabel("Voc\u00EA tem ");
		lblVocTem.setBounds(22, 106, 60, 14);
		frame.getContentPane().add(lblVocTem);
		
		JLabel lblNDeProdutos = new JLabel("N\u00BA de Produtos");
		lblNDeProdutos.setBounds(80, 106, 73, 14);
		frame.getContentPane().add(lblNDeProdutos);
		
		JLabel lblVenda = new JLabel("\u00E0 venda");
		lblVenda.setBounds(163, 106, 46, 14);
		frame.getContentPane().add(lblVenda);
		
		JLabel lblXpDisponvel = new JLabel("XP dispon\u00EDvel:");
		lblXpDisponvel.setBounds(22, 141, 73, 14);
		frame.getContentPane().add(lblXpDisponvel);
		
		JLabel lblXp = new JLabel("XP");
		lblXp.setBounds(90, 141, 46, 14);
		frame.getContentPane().add(lblXp);
		
		JButton btnCompreMais = new JButton("Compre mais!");
		btnCompreMais.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCompreMais.setBounds(130, 137, 89, 23);
		frame.getContentPane().add(btnCompreMais);
		
		JLabel lblCrieUmAnncio = new JLabel("Crie um an\u00FAncio!");
		lblCrieUmAnncio.setBounds(296, 71, 89, 21);
		frame.getContentPane().add(lblCrieUmAnncio);
		
		JButton btnAnunciar = new JButton("Anunciar");
		btnAnunciar.setBounds(296, 97, 89, 23);
		frame.getContentPane().add(btnAnunciar);
		
		JLabel lblEditeSeusAnncios = new JLabel(" Edite seus an\u00FAncios");
		lblEditeSeusAnncios.setBounds(22, 175, 97, 14);
		frame.getContentPane().add(lblEditeSeusAnncios);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEditar.setBounds(130, 171, 89, 23);
		frame.getContentPane().add(btnEditar);
	}

}
