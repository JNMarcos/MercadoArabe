package br.ufrpe.gui.telas_principais;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaConfirmaCompraXP {

	private JFrame frmConfirmarCompraXps;
	private JTextField textField_User;
	private JPasswordField passwordField;
	private JFormattedTextField formattedTextFieldCpf;
	private MaskFormatter maskCpf;


	/**
	 * Create the application.
	 */
	public TelaConfirmaCompraXP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfirmarCompraXps = new JFrame();
		frmConfirmarCompraXps.setTitle("Confirmar Compra XPs");
		frmConfirmarCompraXps.getContentPane().setBackground(SystemColor.activeCaption);
		frmConfirmarCompraXps.setBounds(100, 100, 450, 300);
		frmConfirmarCompraXps.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConfirmarCompraXps.getContentPane().setLayout(null);
		
		JLabel lblConfirmeSeusXps = new JLabel("Confirme seus XPs");
		lblConfirmeSeusXps.setFont(new Font("Gisha", Font.PLAIN, 18));
		lblConfirmeSeusXps.setBounds(139, 27, 148, 22);
		frmConfirmarCompraXps.getContentPane().add(lblConfirmeSeusXps);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(106, 76, 33, 14);
		lblCpf.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmConfirmarCompraXps.getContentPane().add(lblCpf);
		
		formattedTextFieldCpf = new JFormattedTextField();
		formattedTextFieldCpf.setToolTipText("");
		formattedTextFieldCpf.setFont(new Font("Gisha", Font.PLAIN, 13));
		formattedTextFieldCpf.setBounds(149, 72, 148, 23);
		//maskCpf = new MaskFormatter("###.###.###-##"); exception
		maskCpf.setValidCharacters("1234567890");
		maskCpf.install(formattedTextFieldCpf);
		frmConfirmarCompraXps.getContentPane().add(formattedTextFieldCpf);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(85, 111, 54, 14);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmConfirmarCompraXps.getContentPane().add(lblUsurio);
		
		textField_User = new JTextField();
		textField_User.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_User.setBounds(149, 107, 148, 23);
		frmConfirmarCompraXps.getContentPane().add(textField_User);
		textField_User.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(93, 144, 46, 14);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmConfirmarCompraXps.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 141, 148, 23);
		frmConfirmarCompraXps.getContentPane().add(passwordField);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(224, 192, 91, 23);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmConfirmarCompraXps.getContentPane().add(btnConfirmar);
		
		EventoBtnConfirmar acaoBtnConfirmar = new EventoBtnConfirmar();
		btnConfirmar.addActionListener(acaoBtnConfirmar);
		
		JButton btnVoltar = new JButton("< Voltar");
		btnVoltar.setBounds(125, 192, 89, 23);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		frmConfirmarCompraXps.getContentPane().add(btnVoltar);
		
		EventoBtnVoltar acaoBtnCancelar = new EventoBtnVoltar();
		btnVoltar.addActionListener(acaoBtnCancelar);
	}
	
	private class EventoBtnConfirmar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			
		}
	}
	
	private class EventoBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			TelaConfirmaCompraXP.dispose();	
			TelaCompraXP telaCompraXP = new TelaCompraXP();
			//telaCompraXP.setVisible(true);
		}
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
