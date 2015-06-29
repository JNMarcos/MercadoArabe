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
import javax.swing.SwingConstants;

import br.ufrpe.gui.telas_cadastro.TelaCadastroComprador;
import br.ufrpe.gui.telas_cadastro.TelaCadastroVendedor;
import br.ufrpe.gui.telas_login.TelaLoginComprador;
import br.ufrpe.gui.telas_login.TelaLoginVendedor;

public class TelaInicio {

	private JFrame frame;
	private JButton btnComprador;
	private JButton btnVendedor;
	private JButton btnCadComprador;
	private JButton btnCadVendedor;
	private TelaCadastroComprador telaCadComprador;
	private TelaCadastroVendedor telaCadVendedor;
	private TelaLoginVendedor telaLoginVendedor;
	private TelaLoginComprador telaLoginComprador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio window = new TelaInicio();
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
	public TelaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Mercado �rabe");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//labels
		JLabel lblMercadorabe = new JLabel("Mercado \u00C1rabe");
		lblMercadorabe.setBounds(77, 33, 282, 53);
		panel.add(lblMercadorabe);
		lblMercadorabe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercadorabe.setFont(new Font("Gisha", Font.BOLD, 34));

		JLabel lblEntre = new JLabel("Entrar como");
		lblEntre.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblEntre.setBounds(32, 109, 83, 25);
		panel.add(lblEntre);

		//buttons
		btnComprador = new JButton("Comprador");
		btnComprador.setBounds(77, 146, 105, 25);
		btnComprador.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnComprador);

		EventoBotaoLoginComprador acaoLoginComprador = new EventoBotaoLoginComprador();
		btnComprador.addActionListener(acaoLoginComprador);
		telaLoginComprador = new TelaLoginComprador();

		//Logar vendedor
		btnVendedor = new JButton("Vendedor");
		btnVendedor.setBounds(268, 146, 105, 25);
		btnVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnVendedor);

		EventoBotaoLoginVendedor acaoLoginVendedor = new EventoBotaoLoginVendedor();
		btnVendedor.addActionListener(acaoLoginVendedor);
		telaLoginVendedor = new TelaLoginVendedor();

		btnCadComprador = new JButton("Cadastre-se");
		btnCadComprador.setBounds(77, 187, 101, 23);
		btnCadComprador.setBackground(null);
		btnCadComprador.setBorder(null);
		btnCadComprador.setContentAreaFilled(false);
		btnCadComprador.setForeground(new Color(0, 0, 204));
		btnCadComprador.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadComprador);

		//evento
		EventoBotaoCadastrarComprador acaoBtnCadComprador = new EventoBotaoCadastrarComprador();
		btnCadComprador.addActionListener(acaoBtnCadComprador);
		telaCadComprador = new TelaCadastroComprador();

		btnCadVendedor = new JButton("Cadastre-se");
		btnCadVendedor.setBackground(null);
		btnCadVendedor.setBorder(null);
		btnCadVendedor.setContentAreaFilled(false);
		btnCadVendedor.setForeground(new Color(0, 0, 204));
		btnCadVendedor.setBounds(268, 185, 103, 25);
		btnCadVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadVendedor);

		//addEvento
	}

	private class EventoBotaoCadastrarComprador implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			telaCadComprador.setVisible(true);
		}
	}


	private class EventoBotaoLoginVendedor implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			telaLoginVendedor.setVisible(true);
		}
	}

	private class EventoBotaoLoginComprador implements ActionListener { 
		public void actionPerformed(ActionEvent evento) {
			telaLoginComprador.setVisible(true);
		}
	}

	private class EventoBotaoCadastrarComprador implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			telaCadComprador.setVisible(true);
		}
	}

	private class EventoBotaoCadastrarVendedor implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			telaCadVendedor.setVisible(true);
		}
	}
}
