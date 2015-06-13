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
		lblPerfil.setFont(new Font("Gisha", Font.BOLD, 24));
		lblPerfil.setBounds(22, 21, 118, 35);
		frame.getContentPane().add(lblPerfil);
		
		JLabel lblBemVindo = new JLabel("Bem-vindo,");
		lblBemVindo.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblBemVindo.setBounds(22, 74, 73, 15);
		frame.getContentPane().add(lblBemVindo);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 14));
		lblUser.setBounds(92, 75, 46, 14);
		frame.getContentPane().add(lblUser);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnSair.setBounds(353, 213, 60, 21);
		frame.getContentPane().add(btnSair);
		
		JLabel lblVocTem = new JLabel("Voc\u00EA tem ");
		lblVocTem.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblVocTem.setBounds(22, 106, 60, 14);
		frame.getContentPane().add(lblVocTem);
		
		JLabel lblVenda = new JLabel("produtos \u00E0 venda");
		lblVenda.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblVenda.setBounds(121, 106, 109, 15);
		frame.getContentPane().add(lblVenda);
		
		JLabel lblXpDisponvel = new JLabel("XPs dispon\u00EDvel:");
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblXpDisponvel.setBounds(22, 131, 98, 21);
		frame.getContentPane().add(lblXpDisponvel);
		
		JButton btnCompreMais = new JButton("Compre mais!");
		btnCompreMais.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnCompreMais.setBounds(32, 163, 140, 22);
		frame.getContentPane().add(btnCompreMais);
		
		JButton btnAnunciar = new JButton("Anuncie");
		btnAnunciar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnAnunciar.setBounds(303, 130, 89, 23);
		frame.getContentPane().add(btnAnunciar);
		
		JLabel lblEditeSeusAnncios = new JLabel("        Seus an\u00FAncios");
		lblEditeSeusAnncios.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblEditeSeusAnncios.setBounds(275, 72, 134, 19);
		frame.getContentPane().add(lblEditeSeusAnncios);
		
		JButton btnEditar = new JButton("Edite");
		btnEditar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnEditar.setBounds(303, 102, 89, 23);
		frame.getContentPane().add(btnEditar);
		
		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setFont(new Font("Gisha", Font.BOLD, 13));
		lblQtd.setBounds(88, 106, 32, 15);
		frame.getContentPane().add(lblQtd);
		
		JLabel label = new JLabel("qtd");
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		label.setBounds(122, 132, 46, 14);
		frame.getContentPane().add(label);
	}
}
