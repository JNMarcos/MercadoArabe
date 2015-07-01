package br.ufrpe.gui.telas_exibir_info;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ufrpe.negocio.classes_basicas.Comprador;

public class TelaExibirInfoComprador {
	Comprador c;
	
	private JFrame frmConheaOVendedor;
	public TelaExibirInfoComprador(Comprador c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Comprador c) {
		setComprador(c);
		frmConheaOVendedor = new JFrame();
		frmConheaOVendedor.setTitle("Veja seus dados cadastrais");
		frmConheaOVendedor.getContentPane().setBackground(SystemColor.activeCaption);
		frmConheaOVendedor.setBounds(100, 100, 450, 219);
		frmConheaOVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConheaOVendedor.getContentPane().setLayout(null);;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 181);
		frmConheaOVendedor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInformaesDoVendedor = new JLabel("SOBRE");
		lblInformaesDoVendedor.setBounds(10, 29, 108, 35);
		panel.add(lblInformaesDoVendedor);
		lblInformaesDoVendedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformaesDoVendedor.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblNomeDoVendedor = new JLabel("NOME");
		lblNomeDoVendedor.setBounds(31, 82, 323, 20);
		panel.add(lblNomeDoVendedor);
		lblNomeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(51, 141, 152, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnContinuoInteressado = new JButton("Editar informa\u00E7\u00F5es");
		btnContinuoInteressado.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnContinuoInteressado.setBounds(223, 141, 172, 23);
		panel.add(btnContinuoInteressado);
		
		JLabel lblNewLabel_5 = new JLabel("SENHA");
		lblNewLabel_5.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(31, 103, 200, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("USERNAME");
		lblNewLabel_4.setBounds(91, 32, 288, 29);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Gisha", Font.BOLD, 22));
	}
	
	public void setComprador(Comprador c){
		this.c = c;
	}
}
