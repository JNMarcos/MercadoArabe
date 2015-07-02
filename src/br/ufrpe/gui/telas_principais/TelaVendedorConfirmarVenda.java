package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVendedorConfirmarVenda {
	private JFrame frmConfirmarInteresseNo;
	private JPanel panel;
	private JSpinner spinner;
	private JButton btnConfirmar;
	private JButton btnVoltar;

	/**
	 * Create the application.
	 */
	public TelaVendedorConfirmarVenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfirmarInteresseNo = new JFrame();
		frmConfirmarInteresseNo.setResizable(false);
		frmConfirmarInteresseNo.setTitle("Confirmar venda do produto");
		frmConfirmarInteresseNo.getContentPane().setBackground(SystemColor.activeCaption);
		frmConfirmarInteresseNo.setBounds(100, 100, 538, 149);
		frmConfirmarInteresseNo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfirmarInteresseNo.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 534, 120);
		frmConfirmarInteresseNo.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Quantos itens desse produto voc\u00EA deseja vender ao comprador?");
		lblUsurio.setBounds(26, 28, 382, 17);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(275, 73, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnVoltar = new JButton("Voltar ");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendedorConfirmarVenda.dispose();
				TelaVendedorConfirmarVenda TelaExibirInfoProduto_Vendedor = new TelaVendedorConfirmarVenda();
				TelaExibirInfoProduto_Vendedor.setvisible(true);
			}
		});
		btnVoltar.setBounds(182, 73, 71, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Gisha", Font.PLAIN, 13));
		spinner.setBounds(426, 26, 77, 20);
		panel.add(spinner);
	}

	protected void setvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

}
