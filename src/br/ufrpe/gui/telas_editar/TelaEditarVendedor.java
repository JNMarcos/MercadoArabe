package br.ufrpe.gui.telas_editar;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Contato;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarVendedor extends JFrame{
	private Vendedor v;
	private Contato c;
	private Fachada fachada;
	public TelaEditarVendedor(Vendedor v) {
		setVendedor(v);
		fachada = Fachada.getInstance();
		setResizable(false);
		setSize(530,340);
		setTitle("Atualiza\u00E7\u00E3o de informa\u00E7\u00F5es cadastrais");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 551, 315);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Logradouro");
		lblNewLabel_4.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(30, 73, 78, 43);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_1 = new JLabel("Bairro");
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(237, 105, 46, 43);
		panel.add(lblNewLabel_1);

		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setBounds(30, 164, 84, 14);
		panel.add(lblNovaSenha);
		lblNovaSenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblConfirmeASenha = new JLabel("Telefone");
		lblConfirmeASenha.setBounds(30, 54, 61, 14);
		panel.add(lblConfirmeASenha);
		lblConfirmeASenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		email = new JTextField();
		email.setBounds(331, 51, 185, 20);
		panel.add(email);
		email.setFont(new Font("Gisha", Font.PLAIN, 13));
		email.setColumns(10);

		JButton btnConfirmar = new JButton(" Confirmar");
		btnConfirmar.setBounds(296, 268, 104, 23);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));

		EventoAtualizarComprador btnConfirmarEdicao = new EventoAtualizarComprador();
		btnConfirmar.addActionListener(btnConfirmarEdicao);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(275, 54, 46, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblConfSenha = new JLabel("Confirme senha");
		lblConfSenha.setBounds(30, 202, 97, 14);
		panel.add(lblConfSenha);
		lblConfSenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		telefone = new JTextField();
		telefone.setBounds(101, 51, 146, 20);
		panel.add(telefone);
		telefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		telefone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Apenas \u00E9 necess\u00E1rio preencher os dados que foram alterado.");
		lblNewLabel_3.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(30, 222, 486, 35);
		panel.add(lblNewLabel_3);

		cidade = new JTextField();
		cidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		cidade.setBounds(101, 116, 127, 22);
		panel.add(cidade);
		cidade.setColumns(10);

		JLabel lblAtualizeSuasInforme = new JLabel("Atualize suas informa\u00E7\u00F5es de contato e credenciais");
		lblAtualizeSuasInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizeSuasInforme.setBounds(30, 11, 487, 20);
		panel.add(lblAtualizeSuasInforme);
		lblAtualizeSuasInforme.setFont(new Font("Gisha", Font.PLAIN, 18));

		bairro = new JTextField();
		bairro.setBounds(284, 116, 116, 22);
		panel.add(bairro);
		bairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		bairro.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBox.setBounds(437, 116, 79, 20);
		panel.add(comboBox);
		
		String[] arrayUF = {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", 
				"RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		for(int i = 0; i < 28; i++)
			comboBox.addItem(arrayUF[i]);
		panel.add(comboBox);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoltar.setBounds(152, 268, 108, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));

		novaSenhaConfirmar = new JPasswordField("");
		novaSenhaConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		novaSenhaConfirmar.setBounds(137, 193, 146, 23);
		panel.add(novaSenhaConfirmar);

		novaSenha = new JPasswordField();
		novaSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		novaSenha.setBounds(136, 158, 148, 20);
		panel.add(novaSenha);

		JLabel lblNewLabel = new JLabel("Cidade");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 112, 53, 29);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("UF");
		lblNewLabel_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(410, 98, 29, 50);
		panel.add(lblNewLabel_2);

		logradouro = new JTextField();
		logradouro.setFont(new Font("Gisha", Font.PLAIN, 13));
		logradouro.setBounds(111, 82, 405, 20);
		panel.add(logradouro);
		logradouro.setColumns(10);
	}

	private void setVendedor(Vendedor v) {
		this.v = v;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField email;
	private JTextField telefone;
	private JPasswordField novaSenhaConfirmar;
	private JPasswordField novaSenha;
	private JTextField cidade;
	private JTextField bairro;
	private JTextField logradouro;

	public class EventoAtualizarComprador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			c = new Contato();
			try{
				if(!email.getText().equals(""))	c.setEmail(email.getText());
				else c.setEmail(v.getContato().getEmail());
				if (!telefone.getText().equals("")) c.setTelefone(telefone.getText());
				else c.setTelefone(v.getContato().getTelefone());
				if (!cidade.getText().equals("")) c.setCidade(cidade.getText());
				else c.setCidade(v.getContato().getCidade());
				if (!bairro.getText().equals("")) c.setBairro(bairro.getText());
				else c.setBairro(v.getContato().getBairro());
				if (!logradouro.getText().equals("")) c.setLogradouro(logradouro.getText());
				else c.setLogradouro(v.getContato().getLogradouro());
				if (!novaSenha.getPassword().equals("") && !novaSenhaConfirmar.getPassword().equals("") 
						&& novaSenha.equals(novaSenhaConfirmar)){
					v.setSenha(new String (novaSenha.getPassword()));
				}
				v.setContato(c);
			} catch (NullPointerException e1){
				JOptionPane.showMessageDialog(null, "Argumento inválido");
			}
			try {
				fachada.atualizarVendedor(v);
			} catch (IllegalArgumentException e1) {
				JOptionPane.showMessageDialog(null, "Argumento inválido");
			} catch (NaoEncontradoVendedorException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}

		}

	}
}
