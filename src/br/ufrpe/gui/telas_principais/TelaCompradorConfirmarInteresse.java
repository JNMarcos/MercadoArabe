package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufrpe.gui.telas_exibir_info.TelaExibirInfoProduto_Comprador;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;

public class TelaCompradorConfirmarInteresse {
	private JFrame frmConfirmarInteresseNo;
	private JPanel panel;
	private JButton btnConfirmar;
	private JButton btnVoltar;
	private Comprador c;
	private Produto p;
	private Fachada f;

	/**
	 * Create the application.
	 */
	public TelaCompradorConfirmarInteresse(Comprador c, Produto p) {
		initialize(c, p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Comprador c, Produto p) {
		setComprador(c);
		setProduto(p);

		f = Fachada.getInstance();
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

		JLabel lblUsurio = new JLabel("Voc\u00EA est\u00E1 interessado pelo produto?");
		lblUsurio.setBounds(26, 28, 339, 17);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(225, 73, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));

		EventoConfirmarInteresse evento = new EventoConfirmarInteresse();
		btnConfirmar.addActionListener(evento);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(131, 73, 71, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		EventoBotaoVoltar evento1 = new EventoBotaoVoltar();
		btnVoltar.addActionListener(evento1);
	}

	private void setProduto(Produto p) {
		// TODO Auto-generated method stub
		this.p = p;
	}

	private void setComprador(Comprador c) {
		// TODO Auto-generated method stub
		this.c = c;
	}

	public class EventoConfirmarInteresse implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			p.adicionarInteressados(c);
			f.adicionarAosInteresses(c, p);
		}

	}

	private class EventoBotaoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			setVisible(false);
			TelaExibirInfoProduto_Comprador tela = new TelaExibirInfoProduto_Comprador(p);
			tela.setVisible(true);

		}

		private void setVisible(boolean b) {
			// TODO Apublic void setVisible(boolean b) {
			if(b == true)
				frmConfirmarInteresseNo.setVisible(b);
			else
				frmConfirmarInteresseNo.setVisible(b);
		}

	}
}

