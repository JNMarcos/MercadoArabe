package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TelaCompraXP {

	private JFrame frmCompraDeXps;

	/**
	 * Create the application.
	 */
	public TelaCompraXP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCompraDeXps = new JFrame();
		frmCompraDeXps.setTitle("Compra de XPs");
		frmCompraDeXps.getContentPane().setFont(new Font("Gisha", Font.PLAIN, 13));
		frmCompraDeXps.getContentPane().setBackground(SystemColor.activeCaption);
		frmCompraDeXps.setBounds(100, 100, 450, 300);
		frmCompraDeXps.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCompraDeXps.getContentPane().setLayout(null);
		
		JLabel lblCompreXp = new JLabel("Compre XP!");
		lblCompreXp.setFont(new Font("Gisha", Font.PLAIN, 18));
		lblCompreXp.setBounds(161, 11, 112, 29);
		frmCompraDeXps.getContentPane().add(lblCompreXp);
		
		JLabel lblTextoQtd = new JLabel("Selecione a quantidade desejada de XPs");
		lblTextoQtd.setFont(new Font("Gisha", Font.PLAIN, 14));
		lblTextoQtd.setBounds(93, 62, 262, 25);
		frmCompraDeXps.getContentPane().add(lblTextoQtd);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("500 XP");
		rdbtnNewRadioButton.setFont(new Font("Gisha", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(102, 125, 78, 23);
		frmCompraDeXps.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("1000 XP");
		rdbtnNewRadioButton_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_1.setBounds(182, 125, 78, 23);
		frmCompraDeXps.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnXp = new JRadioButton("3000 XP");
		rdbtnXp.setFont(new Font("Gisha", Font.PLAIN, 13));
		rdbtnXp.setBackground(SystemColor.activeCaption);
		rdbtnXp.setBounds(262, 125, 78, 23);
		frmCompraDeXps.getContentPane().add(rdbtnXp);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(220, 205, 89, 23);
		btnContinuar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmCompraDeXps.getContentPane().add(btnContinuar);
		
		EventoBtnContinuar acaoBtnContinuar = new EventoBtnContinuar();
		btnContinuar.addActionListener(acaoBtnContinuar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(121, 205, 89, 23);
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmCompraDeXps.getContentPane().add(btnCancelar);
		
		EventoBtnCancelar acaoBtnCancelar = new EventoBtnCancelar();
		btnCancelar.addActionListener(acaoBtnCancelar);
	}

	private class EventoBtnContinuar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			
		}
	}
	
	private class EventoBtnCancelar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			TelaCompraXP.dispose();
			TelaVendedor telaVendedor = new TelaVendedor(null);
			telaVendedor.setvisible(true);
			
		}
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
