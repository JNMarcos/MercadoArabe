package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.ufrpe.gui.telas_exibir_info.TelaExibirInfoProduto_Vendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;

public class TelaVendedorConfirmarVenda {
	private JFrame frmConfirmarInteresseNo;
	private JPanel panel;
	private JButton btnConfirmar;
	private JButton btnVoltar;
	private Vendedor v;
	private Comprador c;
	private Produto p;
	private Fachada fachada;
	
	/**
	 * Create the application.
	 */
	public TelaVendedorConfirmarVenda(Vendedor v, Comprador c, Produto p) {
		initialize(v, c, p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vendedor v, Comprador c, Produto p) {
		setVendedor(v);
		setComprador(c);
		setProduto(p);
		fachada = Fachada.getInstance();
		frmConfirmarInteresseNo = new JFrame();
		frmConfirmarInteresseNo.setResizable(false);
		frmConfirmarInteresseNo.setTitle("Confirmar venda do produto");
		frmConfirmarInteresseNo.getContentPane().setBackground(SystemColor.activeCaption);
		frmConfirmarInteresseNo.setBounds(100, 100, 538, 149);
		frmConfirmarInteresseNo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConfirmarInteresseNo.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 534, 120);
		frmConfirmarInteresseNo.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Voc\u00EA deseja confirmar a venda?");
		lblUsurio.setBounds(26, 28, 382, 17);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(275, 73, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		EventoConfirmarVenda evento = new EventoConfirmarVenda();
		btnConfirmar.addActionListener(evento);
		
		btnVoltar = new JButton("Voltar ");
		EventoVoltar e = new EventoVoltar();
		btnVoltar.addActionListener(e);
		btnVoltar.setBounds(182, 73, 71, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
	}

	private void setProduto(Produto p) {
		this.p = p;	
	}

	private void setComprador(Comprador c) {
		this.c = c;			
	}

	private void setVendedor(Vendedor v) {
		this.v = v;
	}

	public class EventoConfirmarVenda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fachada.venderProduto(p, v, c);
			} catch (NaoEncontradoProdutoException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
			} catch (NaoEncontradoVendedorException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
			} catch (NaoEncontradoCompradorException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException e1){
				JOptionPane.showMessageDialog(null, "Não se pode realizar a venda!", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

			}
			JOptionPane.showMessageDialog(null, "Venda feita com sucesso!");
			frmConfirmarInteresseNo.dispose();
			TelaExibirInfoProduto_Vendedor TelaExibirInfoProduto_Vendedor = new TelaExibirInfoProduto_Vendedor(p, v);
			TelaExibirInfoProduto_Vendedor.setVisible(true);
			
			
		}
		
	}
	
	public class EventoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TelaVendedorConfirmarVenda.dispose();
			TelaExibirInfoProduto_Vendedor TelaExibirInfoProduto_Vendedor = new TelaExibirInfoProduto_Vendedor(p, v);
			TelaExibirInfoProduto_Vendedor.setVisible(true);
		}
	}
	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		if(b == true)
			frmConfirmarInteresseNo.setVisible(b);
		else
			frmConfirmarInteresseNo.setVisible(b);	
	}

}
