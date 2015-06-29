package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import br.ufrpe.gui.telas_principais.TelaCompradorConfirmarInteresse;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class TelaCompradorConfirmarInteresse {
	private JFrame frmConfirmarInteresseNo;
	private JPanel panel;
	private JSpinner spinner;
	private JButton btnConfirmar;
	private JButton btnVoltar;

	/**
	 * Create the application.
	 */
	public TelaCompradorConfirmarInteresse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfirmarInteresseNo = new JFrame();
		frmConfirmarInteresseNo.setTitle("Confirmar interesse no produto");
		frmConfirmarInteresseNo.setResizable(false);
		frmConfirmarInteresseNo.getContentPane().setBackground(SystemColor.activeCaption);
		frmConfirmarInteresseNo.setBounds(100, 100, 450, 149);
		frmConfirmarInteresseNo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfirmarInteresseNo.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 444, 186);
		frmConfirmarInteresseNo.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Quantos itens voc\u00EA deseja desse produto?");
		lblUsurio.setBounds(26, 28, 339, 17);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(225, 73, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnVoltar = new JButton("Voltar ");
		btnVoltar.setBounds(131, 73, 71, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Gisha", Font.PLAIN, 13));
		spinner.setBounds(324, 27, 77, 20);
		panel.add(spinner);
	}
}
