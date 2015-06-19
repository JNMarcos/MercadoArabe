package br.ufrpe.gui.telas_principais;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TelaCompraXP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompraXP window = new TelaCompraXP();
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
	public TelaCompraXP() {
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
		
		JLabel lblCompreXp = new JLabel("Compre XP!");
		lblCompreXp.setFont(new Font("Gisha", Font.PLAIN, 18));
		lblCompreXp.setBounds(142, 24, 112, 29);
		frame.getContentPane().add(lblCompreXp);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(68, 227, 89, 23);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnVoltar);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(266, 227, 89, 23);
		btnContinuar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frame.getContentPane().add(btnContinuar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("500 XP");
		rdbtnNewRadioButton.setBounds(134, 76, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("1000 XP");
		rdbtnNewRadioButton_1.setBounds(134, 116, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnXp = new JRadioButton("3000 XP");
		rdbtnXp.setBounds(134, 166, 109, 23);
		frame.getContentPane().add(rdbtnXp);
	}
}
