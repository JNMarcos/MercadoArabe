package br.ufrpe.gui.telas_editar;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Contato;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;
import br.ufrpe.negocio.utilidades.PessoaUtilidades;

public class TelaEditarVendedor extends JFrame{
	Vendedor v;
	Contato c;
	Fachada fachada;
	private TelaVendedor telaVendedor;

	public TelaEditarVendedor(Vendedor v) {
		setVendedor(v);
		fachada = Fachada.getInstance();
		setResizable(false);
		setSize(530,340);
		setTitle("Atualiza\u00E7\u00E3o de informa\u00E7\u00F5es cadastrais");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 524, 315);
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
		lblNewLabel_3.setFont(new Font("Gisha", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(30, 245, 486, 23);
		panel.add(lblNewLabel_3);

		cidade = new JTextField();
		cidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		cidade.setBounds(101, 118, 127, 20);
		panel.add(cidade);
		cidade.setColumns(10);

		JLabel lblAtualizeSuasInforme = new JLabel("Atualize suas informa\u00E7\u00F5es de contato e credenciais");
		lblAtualizeSuasInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizeSuasInforme.setBounds(30, 11, 487, 20);
		panel.add(lblAtualizeSuasInforme);
		lblAtualizeSuasInforme.setFont(new Font("Gisha", Font.PLAIN, 18));

		bairro = new JTextField();
		bairro.setBounds(284, 118, 116, 20);
		panel.add(bairro);
		bairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		bairro.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBox.setBounds(437, 116, 79, 20);
		panel.add(comboBox);

		String[] arrayUF = {" ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", 
				"RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		for(int i = 0; i < 28; i++)
			comboBox.addItem(arrayUF[i]);
		panel.add(comboBox);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				telaVendedor = new TelaVendedor(v);
				telaVendedor.setVisible(true);
			}
		});
		btnVoltar.setBounds(152, 268, 108, 23);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));

		novaSenhaConfirmar = new JPasswordField("");
		novaSenhaConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		novaSenhaConfirmar.setBounds(137, 196, 146, 20);
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

		JLabel lblNewLabel_5 = new JLabel("A senha tem de ter no m\u00EDnimo 8 caracteres, dentre eles n\u00FAmeros ou caracteres especiais e letra em mai\u00FAscula.");
		lblNewLabel_5.setFont(new Font("Gisha", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(10, 227, 506, 14);
		panel.add(lblNewLabel_5);
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
	private JComboBox<String> comboBox;

	public class EventoAtualizarComprador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			c = new Contato();
			Vendedor vd = new Vendedor();
			int nadaAlterado = 0;
			try{
				vd.setNome(v.getNome());
				vd.setNomeUsuario(v.getNomeUsuario());
				vd.setDataNascimento(v.getDia(), v.getDataNascimento().getMonthValue(),
						v.getDataNascimento().getYear());
				vd.setCpf(v.getCpf());
				vd.setXp(v.getXp());
				vd.setDataCadastro(v.getDataCadastro());

				if(!email.getText().equals(""))	c.setEmail(email.getText());
				else {c.setEmail(v.getContato().getEmail()); nadaAlterado++;}
				if (!telefone.getText().equals("")) c.setTelefone(telefone.getText());
				else {c.setTelefone(v.getContato().getTelefone()); nadaAlterado++;}
				if (!cidade.getText().equals("")) c.setCidade(cidade.getText());
				else {c.setCidade(v.getContato().getCidade()); nadaAlterado++;}
				if (!bairro.getText().equals("")) c.setBairro(bairro.getText());
				else {c.setBairro(v.getContato().getBairro()); nadaAlterado++;}
				if (!logradouro.getText().equals("")) c.setLogradouro(logradouro.getText());
				else {c.setLogradouro(v.getContato().getLogradouro()); nadaAlterado++;}
				if (!(comboBox.getSelectedIndex() == 0))  c.setEstado((String)comboBox.getSelectedItem());
				else {c.setEstado(v.getContato().getEstado());nadaAlterado++;}
				
				vd.setContato(c);
				
				String senha = new String(novaSenha.getPassword());
				String senhaConfirma = new String(novaSenhaConfirmar.getPassword());
				if (!senha.equals("") && !senhaConfirma.equals("")){

					if(senha.equals(senhaConfirma)) {
						if (!senha.equals(v.getSenha())){
							boolean estaOk = PessoaUtilidades.senhaNosConformes(senha);
							if (estaOk){
								vd.setSenha(senha);
								fachada.removerVendedor(v);
								fachada.cadastrarVendedor(vd);
								JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
								setVendedor(vd);
								dispose();
								telaVendedor = new TelaVendedor(v);
								telaVendedor.setVisible(true);
							} else{
								JOptionPane.showMessageDialog(null, "Que tal seguir as regras apenas uma vez! \n\nA Gerência :)");

							}
						} else 
							JOptionPane.showMessageDialog(null, "Essa já é sua senha!");
					} else 
						JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
				} else if (senha.equals("") && senhaConfirma.equals("") && nadaAlterado < 6) {
					vd.setSenha(v.getSenha());
					fachada.removerVendedor(v);
					fachada.cadastrarVendedor(vd);
					JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
					setVendedor(vd);
					dispose();
					telaVendedor = new TelaVendedor(v);
					telaVendedor.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nada alterado. Todos os espaços estão em branco! Insira alguma coisa para alterar.");
				}
			} catch (NaoEncontradoVendedorException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (SenhaForaPadroesException e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (IllegalArgumentException e1) {
				JOptionPane.showMessageDialog(null, "Argumento inválido");
			} catch (NomeUsuarioJaCadastradoException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (NomeUsuarioForaPadroesException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (CpfJaCadastradoException e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());

			}
		}
	}
}
