package br.ufrpe.gui.telas_cadastro;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.ufrpe.gui.telas_principais.TelaInicio;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;

public class TelaCadastroComprador {

	private JFrame frmCadastroComprador;
	private JPanel panel = new JPanel();
	private JTextField textField_User;
	private JTextField textField_Nome;
	private JPasswordField passwordField;
	private JButton btnCadastrar;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAno;
	private Comprador comprador;
	private static Fachada fachada = Fachada.getInstance();
	private JPasswordField passwordFieldConfirmar;

	private TelaInicio telaInicio;
	
	private static final int anoInicio = 1914;
	private static final int mesDiaInicio = 1;
	private static final int mesFim = 12;
	private static final int diaFim = 31;

	/**
	 * Create the application.
	 */
	public TelaCadastroComprador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroComprador = new JFrame();
		frmCadastroComprador.setResizable(false);
		frmCadastroComprador.setTitle("Cadastro Comprador");
		frmCadastroComprador.getContentPane().setBackground(SystemColor.activeCaption);
		frmCadastroComprador.setBounds(100, 100, 514, 287);
		frmCadastroComprador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroComprador.getContentPane().setLayout(null);

		panel.setBounds(0, 0, 510, 259);
		frmCadastroComprador.getContentPane().add(panel);
		panel.setLayout(null);

		comboBoxAno = new JComboBox<String>();
		comboBoxAno.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxAno.setBounds(292, 58, 91, 20);
		for (int i = anoInicio; i <= LocalDate.now().getYear(); i++){
			comboBoxAno.addItem("" + i);
		}
		panel.add(comboBoxAno);

		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxMes.setBounds(210, 58, 56, 20);
		for (int i = mesDiaInicio; i <= mesFim; i++){
			comboBoxMes.addItem("" + i);
		}
		panel.add(comboBoxMes);

		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxDia.setBounds(137, 58, 56, 20);
		for (int i = mesDiaInicio; i <= diaFim; i++){
			comboBoxDia.addItem("" + i);
		}
		panel.add(comboBoxDia);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(266, 225, 91, 23);
		btnCadastrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadastrar);


		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 22, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));

		textField_Nome = new JTextField();
		textField_Nome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_Nome.setBounds(137, 18, 269, 23);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(70, 103, 46, 14);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));

		textField_User = new JTextField();
		textField_User.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_User.setBounds(137, 99, 269, 23);
		panel.add(textField_User);
		textField_User.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(70, 142, 46, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 139, 155, 23);
		passwordField.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(passwordField);

		JLabel lblNewLabel = new JLabel("Confirmar Senha");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 178, 105, 23);
		panel.add(lblNewLabel);

		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		passwordFieldConfirmar.setBounds(137, 173, 155, 23);
		panel.add(passwordFieldConfirmar);

		//add acao ao botao cadastrar
		comprador = new Comprador();
		EventoBotaoCadastrar acaoBtnCadastrar = new EventoBotaoCadastrar();
		btnCadastrar.addActionListener(acaoBtnCadastrar);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(10, 59, 129, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));

		//botao cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnCancelar.setBounds(137, 225, 91, 23);
		panel.add(btnCancelar);
		EventoBotaoCancelar acaoBtnCancelar = new EventoBotaoCancelar();
		btnCancelar.addActionListener(acaoBtnCancelar);
	}

	public void setVisible(boolean opcao) {
		if(opcao == true)
			frmCadastroComprador.setVisible(true);
		else
			frmCadastroComprador.setVisible(false);
	}

	private class EventoBotaoCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			try {
				if(textField_Nome.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Nome' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				} else if (textField_User.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Username' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				} else if (passwordField.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Senha' encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (passwordFieldConfirmar.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Confirmar senha' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				} else if (comboBoxDia.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo dia de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxMes.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo mês de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxAno.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo ano de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else{
					String senha = new String(passwordField.getPassword());
					String senhaConfirma = new String(passwordFieldConfirmar.getPassword());
					if(senha.equals(senhaConfirma)) {
						comprador.setNome(textField_Nome.getText());
						comprador.setNomeUsuario(textField_User.getText());
						comprador.setSenha(senha);
						int dia = Integer.parseInt((String) comboBoxDia.getSelectedItem());
						int mes = Integer.parseInt((String) comboBoxMes.getSelectedItem());
						int ano = Integer.parseInt((String) comboBoxAno.getSelectedItem());

						comprador.setDataNascimento(dia, mes, ano);

						fachada.cadastrarComprador(comprador);
						fachada.salvarComprador();

						//mensagem boas vindas
						JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!\nBem-vindo ao Mercado Árabe!");
						textField_Nome.setText("");
						textField_User.setText("");
						passwordField.setText("");
						frmCadastroComprador.dispose();
						
						TelaInicio telaInicio = new TelaInicio();
						telaInicio.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "As senhas precisam ser iguais!");
						passwordField.setText("");
						passwordFieldConfirmar.setText("");
					}	
				}

			} catch(NomeUsuarioForaPadroesException e) {
				JOptionPane.showMessageDialog(null, "Usuário inválido! Tente novamente!\n "
						+ "O Usuário deve conter no mínimo 4 caracteres.");
				textField_User.setText("");
				passwordField.setText("");

			} catch(SenhaForaPadroesException e) {
				JOptionPane.showMessageDialog(null, "Senha inválida! Tente novamente!\n "
						+ "A Senha deve conter no mínimo 8 caracteres e presença de números ou caracteres especiais"); //organizar aqui
				passwordField.setText("");

			} catch(NomeUsuarioJaCadastradoException e) {
				JOptionPane.showMessageDialog(null, "Nome de usuário já cadastrado! Tente um diferente!");
				textField_User.setText("");
				passwordField.setText("");
			}
		}
	}

	private class EventoBotaoCancelar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			textField_Nome.setText("");
			textField_User.setText("");
			passwordField.setText("");
			passwordFieldConfirmar.setText("");
			frmCadastroComprador.dispose();
			
			TelaInicio telaInicio = new TelaInicio();
			telaInicio.setVisible(true);
		}
	}
}
