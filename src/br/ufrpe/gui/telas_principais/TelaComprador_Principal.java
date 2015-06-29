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

public class TelaComprador_Principal extends JFrame{
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private JButton btnSair;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private static final long serialVersionUID = 1L;

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
		frmMeuPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 680, 448);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Ver favoritos");
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(89, 402, 163, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		table.setCellSelectionEnabled(true);
		table.setBounds(25, 216, 630, 160);
		panel.add(table);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setBounds(14, 33, 114, 29);
		panel.add(lblPerfil);
		lblPerfil.setFont(new Font("Gisha", Font.BOLD, 24));
		
		JLabel lblNewLabel = new JLabel("Meus produtos");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 181, 200, 29);
		panel.add(lblNewLabel);
		
		JLabel lblBemVindo = new JLabel("Bem-vindo,");
		lblBemVindo.setBounds(14, 73, 65, 17);
		panel.add(lblBemVindo);
		lblBemVindo.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setBounds(89, 73, 156, 17);
		panel.add(lblUser);
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 14));
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendedor.dispose();
				TelaVendedor TelaInicio = new TelaVendedor();
				TelaInicio.setvisible(true);
			}
		});
		btnSair.setForeground(Color.BLUE);
		btnSair.setBorder(null);
		btnSair.setContentAreaFilled(false);
		btnSair.setBackground(null);
		btnSair.setBounds(615, 11, 55, 25);
		panel.add(btnSair);
		btnSair.setFont(new Font("Gisha", Font.PLAIN, 13));
		
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
		
		btnNewButton_1 = new JButton("Ver produtos de interesse");
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(391, 402, 210, 23);
		panel.add(btnNewButton_1);
	}
}
