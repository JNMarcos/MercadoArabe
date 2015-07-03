package br.ufrpe.gui.telas_exibir_info;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ufrpe.gui.telas_editar.TelaEditarComprador;
import br.ufrpe.gui.telas_principais.TelaComprador_Principal;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;

public class TelaExibirInfoComprador {
	private Comprador c;
	private Fachada f;
	
	private JFrame frmConheaOVendedor;
	private TelaComprador_Principal telaCompradorPrincipal;
			
	public TelaExibirInfoComprador(Comprador c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Comprador c) {
		setComprador(c);
		f = Fachada.getInstance();
		frmConheaOVendedor = new JFrame();
		frmConheaOVendedor.setResizable(false);
		frmConheaOVendedor.setTitle("Veja seus dados cadastrais");
		frmConheaOVendedor.getContentPane().setBackground(SystemColor.activeCaption);
		frmConheaOVendedor.setBounds(100, 100, 438, 210);
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
		lblNomeDoVendedor.setText(c.getNome());
		lblNomeDoVendedor.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnVoltar = new JButton("Voltar");
		EventoEditar e1 = new EventoEditar();
		btnVoltar.addActionListener(e1);
		btnVoltar.setBounds(51, 141, 152, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JButton btnContinuoInteressado = new JButton("Editar informa\u00E7\u00F5es");
		EventoEditar e = new EventoEditar();
		btnContinuoInteressado.addActionListener(e);
		btnContinuoInteressado.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnContinuoInteressado.setBounds(223, 141, 172, 23);
		panel.add(btnContinuoInteressado);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblSenha.setBounds(31, 103, 200, 27);
		lblSenha.setText(c.getSenha());
		panel.add(lblSenha);
		
		JLabel lblUser = new JLabel("USERNAME");
		lblUser.setBounds(91, 32, 288, 29);
		panel.add(lblUser);
		lblUser.setText(c.getNomeUsuario());
		lblUser.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 22));
	}
	
	public void setVisible(boolean b) {
		if(b == true)
			frmConheaOVendedor.setVisible(b);
		else
			frmConheaOVendedor.setVisible(b);
	}

	public void setComprador(Comprador c){
		this.c = c;
	}
	
	public class EventoEditar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frmConheaOVendedor.dispose();
			TelaEditarComprador telaEditarComprador = new TelaEditarComprador(c);
			telaEditarComprador.setVisible(true);
		}
	}
	
	public class EventoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frmConheaOVendedor.dispose();
			telaCompradorPrincipal = new TelaComprador_Principal(c);
			telaCompradorPrincipal.setVisible(true);
		}
	}
}
