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

public class TelaVendedor {

	private JFrame frmMeuPerfil;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendedor window = new TelaVendedor();
					window.frmMeuPerfil.setVisible(true);
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
		frmMeuPerfil = new JFrame();
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 426);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 680, 387);
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
		
		JButton btnSair = new JButton("Sair");
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
		
		JLabel lblVocTem = new JLabel("Voc\u00EA tem ");
		lblVocTem.setBounds(14, 101, 59, 17);
		panel.add(lblVocTem);
		lblVocTem.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblVenda = new JLabel("produtos \u00E0 venda");
		lblVenda.setBounds(121, 101, 104, 17);
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA tem");
		lblXpDisponvel.setBounds(14, 132, 87, 17);
		panel.add(lblXpDisponvel);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnCompreMais = new JButton("Quero mais XPs!");
		btnCompreMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVendedor.dispose();
				TelaVendedor TelaCompraXP = new TelaVendedor();
				TelaCompraXP.setvisible(true);
				
			}
		});
		btnCompreMais.setBounds(174, 129, 145, 25);
		panel.add(btnCompreMais);
		btnCompreMais.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblQtd = new JLabel("qtd");
		lblQtd.setBounds(83, 101, 21, 17);
		panel.add(lblQtd);
		lblQtd.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel label = new JLabel("qtd");
		label.setBounds(83, 132, 21, 17);
		panel.add(label);
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel lblXps = new JLabel("XPs");
		lblXps.setForeground(Color.RED);
		lblXps.setFont(new Font("Gisha", Font.BOLD, 13));
		lblXps.setBounds(121, 126, 44, 29);
		panel.add(lblXps);
	}

	public void setvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
