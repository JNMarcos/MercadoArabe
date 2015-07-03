package br.ufrpe.gui.telas_cadastro;

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
import javax.swing.UIManager;

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

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 28, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));

		textField_Nome = new JTextField();
		textField_Nome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_Nome.setBounds(137, 24, 269, 23);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(10, 59, 129, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));

		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxDia.setBounds(137, 58, 41, 23);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		panel.add(comboBoxDia);

		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxMes.setBounds(188, 57, 91, 23);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		panel.add(comboBoxMes);

		comboBoxAno = new JComboBox<String>();
		comboBoxAno.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxAno.setBounds(292, 58, 57, 23);
		String[] arrayAno = new String[84];
		Integer ano = 1998;
		for(int i=0; i<84; i++, ano--) {
			if(i != 0) {
				arrayAno[i] = ano.toString();
				comboBoxAno.addItem(arrayAno[i]);
			}
			else {
				arrayAno[i] = "";
				comboBoxAno.addItem(arrayAno[i]);
			}		
		}
		panel.add(comboBoxAno);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(70, 109, 46, 14);
		panel.add(lblUsurio);
		lblUsurio.setFont(new Font("Gisha", Font.PLAIN, 13));

		textField_User = new JTextField();
		textField_User.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_User.setBounds(137, 105, 269, 23);
		panel.add(textField_User);
		textField_User.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(80, 143, 46, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 139, 155, 23);
		passwordField.setFont(UIManager.getFont("PasswordField.font"));
		panel.add(passwordField);

		JLabel lblNewLabel = new JLabel("Confirmar Senha");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 172, 105, 23);
		panel.add(lblNewLabel);

		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setFont(UIManager.getFont("PasswordField.font"));
		passwordFieldConfirmar.setBounds(137, 173, 155, 23);
		panel.add(passwordFieldConfirmar);

		//add acao ao botao cadastrar
		comprador = new Comprador();
		EventoBotaoCadastrar acaoBtnCadastrar = new EventoBotaoCadastrar();
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(253, 219, 91, 23);
		btnCadastrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(acaoBtnCadastrar);

		//botao cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnCancelar.setBounds(152, 219, 91, 23);
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
	
	public int getAno() { //calcula ano
		int ano = 1998;
		for(int i=1; i<=84; i++) {
			if(comboBoxAno.getSelectedIndex() == i) {
				ano = ano - i;
			}
		}
		return ano;
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
				} else if (comboBoxDia.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "O campo dia de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxMes.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "O campo mês de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxAno.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "O campo ano de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else{
					String senha = new String(passwordField.getPassword());
					String senhaConfirma = new String(passwordFieldConfirmar.getPassword());
					if(senha.equals(senhaConfirma)) {
						comprador.setNome(textField_Nome.getText());
						comprador.setNomeUsuario(textField_User.getText());
						comprador.setSenha(senha);
						comprador.setDataNascimento(comboBoxDia.getSelectedIndex(), comboBoxMes.getSelectedIndex(), getAno());

						fachada.cadastrarComprador(comprador);
						fachada.salvarComprador();

						//mensagem boas vindas
						JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!\nBem-vindo ao Mercado Árabe!");
						textField_Nome.setText("");
						textField_User.setText("");
						passwordField.setText("");
						frmCadastroComprador.dispose();
						telaInicio = new TelaInicio();
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
			telaInicio = new TelaInicio();
			telaInicio.setVisible(true);
		}
	}
}
