package br.ufrpe.gui.telas_editar;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import br.ufrpe.gui.telas_principais.TelaComprador_Principal;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;
import br.ufrpe.negocio.utilidades.PessoaUtilidades;

public class TelaEditarComprador extends JFrame{
	private Comprador c;
	private Fachada f;
	public TelaEditarComprador(Comprador c) {
		setTitle("Alterar senha");
		setComprador(c);
		f = Fachada.getInstance();
		setResizable(false);
		setSize(450,140);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 444, 117);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblRepetirSenha = new JLabel("Repetir senha");
		lblRepetirSenha.setBounds(30, 69, 83, 17);
		panel.add(lblRepetirSenha);
		lblRepetirSenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setBounds(30, 34, 72, 17);
		panel.add(lblNovaSenha);
		lblNovaSenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		passwordField = new JPasswordField();
		passwordField.setFont(UIManager.getFont("PasswordField.font"));
		passwordField.setBounds(134, 32, 200, 19);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(UIManager.getFont("PasswordField.font"));
		passwordField_1.setBounds(136, 66, 200, 20);
		panel.add(passwordField_1);

		btnConfirmar = new JButton("Confirmar");
		EventoEditarComprador e = new EventoEditarComprador();
		btnConfirmar.addActionListener(e);
		
		lblNewLabel = new JLabel("A senha tem de ter no m\u00EDnimo 8 caracteres, dentre eles n\u00FAmeros ou caracteres especiais e letra em mai\u00FAscula.");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 11, 434, 14);
		panel.add(lblNewLabel);

		btnConfirmar.setBounds(344, 30, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));

		btnVoltar = new JButton("Voltar");
		EventoVoltar e1 = new EventoVoltar();
		btnVoltar.addActionListener(e1);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVoltar.setBounds(346, 67, 89, 23);
		panel.add(btnVoltar);

	}

	void setComprador(Comprador c) {
		this.c = c;
	}


	public class EventoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			TelaComprador_Principal telaComprador_Principal = new TelaComprador_Principal(c);
			telaComprador_Principal.setVisible(true);
		}
	}

	public class EventoEditarComprador implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Comprador cp = new Comprador();
			try{
				cp.setNome(c.getNome());
				cp.setNomeUsuario(c.getNomeUsuario());
				cp.setDataNascimento(c.getDia(), c.getDataNascimento().getMonthValue(),
						c.getDataNascimento().getYear());
				String senha = new String(passwordField.getPassword());
				String senhaConfirma = new String(passwordField_1.getPassword());
				if (!senha.equals("") && !senhaConfirma.equals("")){
					
					if(senha.equals(senhaConfirma)) {
						if (!senha.equals(c.getSenha())){
							boolean estaOk = PessoaUtilidades.senhaNosConformes(senha);
							if (estaOk){
								cp.setSenha(senha);
								f.removerComprador(c);
								f.cadastrarComprador(cp);
								JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
								setComprador(cp);
								dispose();
								TelaComprador_Principal telaComprador_Principal = new TelaComprador_Principal(c);
								telaComprador_Principal.setVisible(true);
							} else{
								JOptionPane.showMessageDialog(null, "Que tal seguir as regras apenas uma vez! \n\nA Gerência :)");

							}
						} else 
							JOptionPane.showMessageDialog(null, "Essa já é sua senha!");
					} else 
						JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
				} else 
					JOptionPane.showMessageDialog(null, "Há algum campo vazio!");	
			} catch (NaoEncontradoCompradorException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (SenhaForaPadroesException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Argumento inválido");
			} catch (NomeUsuarioJaCadastradoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (NomeUsuarioForaPadroesException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JButton btnVoltar;
	private JPasswordField passwordField_1;
	private JButton btnConfirmar;
	private JLabel lblNewLabel;

}
