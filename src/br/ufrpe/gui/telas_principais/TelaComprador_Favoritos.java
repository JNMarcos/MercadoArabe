package br.ufrpe.gui.telas_principais;

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

public class TelaComprador_Favoritos {
	private JFrame frmMeuPerfil;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private Comprador c;
	/**
	 * Create the application.
	 */
	public TelaComprador_Favoritos(Comprador c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Comprador c) {
		setComprador(c);
		frmMeuPerfil = new JFrame();
		frmMeuPerfil.setResizable(false);
		frmMeuPerfil.setTitle("Meu Perfil");
		frmMeuPerfil.getContentPane().setBackground(SystemColor.activeCaption);
		frmMeuPerfil.setBounds(100, 100, 696, 398);
		frmMeuPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuPerfil.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 690, 369);
		frmMeuPerfil.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaComprador_Favoritos.dispose();
				TelaComprador_Favoritos TelaComprador_Favoritos = new TelaComprador_Favoritos(c);
				TelaComprador_Favoritos.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton.setBounds(77, 317, 163, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		table.setCellSelectionEnabled(true);
		table.setBounds(20, 131, 630, 160);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Produtos favoritos");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 91, 200, 29);
		panel.add(lblNewLabel);
		
		JLabel lblXpDisponvel = new JLabel("Voc\u00EA tem");
		lblXpDisponvel.setBounds(21, 69, 74, 17);
		panel.add(lblXpDisponvel);
		lblXpDisponvel.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel label = new JLabel("qtd");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(83, 69, 44, 17);
		panel.add(label);
		label.setText("" + c.getProdFavoritos());
		label.setFont(new Font("Gisha", Font.BOLD, 13));
		
		JLabel lblProdutos = new JLabel("produto(s) favorito(s)");
		lblProdutos.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblProdutos.setBounds(136, 69, 146, 17);
		panel.add(lblProdutos);
		
		btnNewButton_1 = new JButton("Remover dos favoritos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnNewButton_1.setBounds(384, 317, 210, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(26, 23, 200, 38);
		lblNewLabel_1.setText(c.getNomeUsuario());
		panel.add(lblNewLabel_1);
	}
	
	private void setComprador(Comprador c) {
		this.c = c;
		
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		if(b == true)
			frmMeuPerfil.setVisible(b);
		else
			frmMeuPerfil.setVisible(b);
	}

}
