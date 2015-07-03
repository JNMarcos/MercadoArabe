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

import br.ufrpe.gui.telas_principais.TelaComprador_Principal;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;

public class TelaEditarComprador extends JFrame{
		Comprador c;
		Fachada f;
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
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try{
						if (!passwordField.getPassword().equals("") && !passwordField_1.getPassword().equals("") 
								&& passwordField.equals(passwordField_1)){
							c.setSenha(new String (passwordField.getPassword()));
						}
						f.atualizarComprador(c);
					} catch (NullPointerException e1){
						JOptionPane.showMessageDialog(null, "Argumento inválido");
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, "Argumento inválido");
					} catch (NaoEncontradoCompradorException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
			}
		});
		btnConfirmar.setBounds(344, 30, 91, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField.setBounds(134, 32, 200, 19);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordField_1.setBounds(136, 66, 200, 20);
		panel.add(passwordField_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				this.dispose();
				TelaComprador_Principal telaComprador_Principal = new TelaComprador_Principal(c);
				telaComprador_Principal.setVisible(true);
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVoltar.setBounds(346, 67, 89, 23);
		panel.add(btnVoltar);
		
		}

	void setComprador(Comprador c) {
		this.c = c;
		}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

}
