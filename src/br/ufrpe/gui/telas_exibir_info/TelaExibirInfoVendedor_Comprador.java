package br.ufrpe.gui.telas_exibir_info;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

import br.ufrpe.negocio.classes_basicas.Vendedor;

public class TelaExibirInfoVendedor_Comprador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmConheaOVendedor;
	
	Vendedor v;


	/**
	 * Create the application.
	 */
	public TelaExibirInfoVendedor_Comprador(Vendedor v) {
		initialize(v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vendedor v) {
		setVendedor(v);
		frmConheaOVendedor = new JFrame();
		frmConheaOVendedor.setResizable(false);
		frmConheaOVendedor.setTitle("Conhe\u00E7a o vendedor");
		frmConheaOVendedor.getContentPane().setBackground(SystemColor.activeCaption);
		frmConheaOVendedor.setBounds(100, 100, 438, 288);
		frmConheaOVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConheaOVendedor.getContentPane().setLayout(null);;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frmConheaOVendedor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInformaesDoVendedor = new JLabel("SOBRE O VENDEDOR");
		lblInformaesDoVendedor.setBounds(10, 29, 310, 35);
		panel.add(lblInformaesDoVendedor);
		lblInformaesDoVendedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformaesDoVendedor.setFont(new Font("Gisha", Font.BOLD, 22));
		
		JLabel lblNomeDoVendedor = new JLabel("NOME DO VENDEDOR");
		lblNomeDoVendedor.setBounds(31, 82, 221, 20);
		lblNomeDoVendedor.setText(v.getNome());
		panel.add(lblNomeDoVendedor);
		lblNomeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnVoltar = new JButton("Desistir da Compra");
		btnVoltar.setBounds(50, 227, 152, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblEmailDoVendedor = new JLabel("E-MAIL DO VENDEDOR");
		lblEmailDoVendedor.setBounds(31, 144, 159, 14);
		lblEmailDoVendedor.setText(v.getContato().getEmail());
		panel.add(lblEmailDoVendedor);
		lblEmailDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblTelefoneDoVendedor = new JLabel("TELEFONE DO VENDEDOR");
		lblTelefoneDoVendedor.setBounds(31, 177, 190, 14);
		lblTelefoneDoVendedor.setText(v.getContato().getTelefone());
		panel.add(lblTelefoneDoVendedor);
		lblTelefoneDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblCidadeDoVendedor = new JLabel("CIDADE DO VENDEDOR");
		lblCidadeDoVendedor.setBounds(30, 113, 163, 14);
		lblCidadeDoVendedor.setText(v.getContato().getCidade());
		panel.add(lblCidadeDoVendedor);
		lblCidadeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnContinuoInteressado = new JButton("Continuo interessado!");
		btnContinuoInteressado.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnContinuoInteressado.setBounds(212, 227, 172, 23);
		panel.add(btnContinuoInteressado);
	}

	private void setVendedor(Vendedor v) {
			this.v = v;
		
	}

}
