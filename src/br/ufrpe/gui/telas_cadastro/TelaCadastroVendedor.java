package br.ufrpe.gui.telas_cadastro;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ufrpe.gui.telas_principais.TelaInicio;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Contato;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.classes_basicas.Xp;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;

public class TelaCadastroVendedor {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panelDadosPessoais;
	private JPanel panelContato;
	private JPanel panelCredenciais;


	private JLabel lblDataDeNascimento;

	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JLabel lblNomeUsuario;
	private JLabel lblSenha;
	private JLabel lblConfirmarSenha;
	private JFormattedTextField formattedTextFieldCpf;
	private MaskFormatter maskCpf;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldNomeUsuario;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAno;
	private JComboBox<String> comboBoxEstado;
	private JFormattedTextField formattedTextFieldTelefone;
	private MaskFormatter maskTelefone;
	private JTextField textFieldEmail;
	private JButton buttonAvancar;
	private JButton buttonAvancarContato;
	private JButton buttonCadastrar;
	private JButton btnCancelar;
	private JButton buttonVoltarContato;
	private JPasswordField passwordField;
	private JPasswordField passwordField_Confirmar;
	private JButton btnVoltarCredenciais;
	private TelaInicio telaInicio;
	private Fachada fachada;
	private Vendedor vendedor;
	private Contato contato;
	private Xp xp;

	/**
	 * Create the application.
	 */
	public TelaCadastroVendedor() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ParseException {
		vendedor = new Vendedor();
		fachada = Fachada.getInstance();
		xp = new Xp();

		frame = new JFrame("Cadastro Vendedor");
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 443, 297);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Gisha", Font.PLAIN, 13));
		tabbedPane.setBounds(0, 0, 440, 270);
		frame.getContentPane().add(tabbedPane);

		//Dados pessoais
		panelDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados pessoais", null, panelDadosPessoais, null);
		panelDadosPessoais.setLayout(null);

		maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("1234567890");
		maskCpf.install(formattedTextFieldCpf);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNome.setBounds(9, 42, 36, 23);
		panelDadosPessoais.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldNome.setBounds(53, 42, 357, 23);
		panelDadosPessoais.add(textFieldNome);
		textFieldNome.setColumns(10);

		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblCpf.setBounds(10, 76, 23, 23);
		panelDadosPessoais.add(lblCpf);

		formattedTextFieldCpf = new JFormattedTextField(maskCpf);
		formattedTextFieldCpf.setFont(new Font("Gisha", Font.PLAIN, 13));
		formattedTextFieldCpf.setBounds(53, 76, 169, 23);
		panelDadosPessoais.add(formattedTextFieldCpf);

		lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblDataDeNascimento.setBounds(9, 110, 125, 23);
		panelDadosPessoais.add(lblDataDeNascimento);

		//dia
		comboBoxDia = new JComboBox<>();
		comboBoxDia.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxDia.setBounds(144, 112, 41, 23);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		panelDadosPessoais.add(comboBoxDia);

		//mes
		comboBoxMes = new JComboBox<>();
		comboBoxMes.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxMes.setBounds(194, 111, 91, 23);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		panelDadosPessoais.add(comboBoxMes);

		//ano
		comboBoxAno = new JComboBox<>();
		comboBoxAno.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxAno.setBounds(294, 111, 57, 23);
		String[] arrayAno = new String[84];
		Integer ano = 1998;											//menores de 18 n podem cadastrar
		for(int i=0; i<84; i++, ano--) {
			if(i != 0) {
				arrayAno[i] = ano.toString();						//idade maxima 100 anos
				comboBoxAno.addItem(arrayAno[i]);
			}
			else {
				arrayAno[i] = "";
				comboBoxAno.addItem(arrayAno[i]);
			}		
		}
		panelDadosPessoais.add(comboBoxAno);

		//botoes
		buttonAvancar = new JButton("Avan\u00E7ar >");
		buttonAvancar.setFont(new Font("Gisha", Font.PLAIN, 13));
		buttonAvancar.setBounds(312, 193, 95, 23);
		panelDadosPessoais.add(buttonAvancar);

		EventoBotaoAvancar_DadosPessoais acaoBtnAvancar_DadosPessoais = new EventoBotaoAvancar_DadosPessoais();
		buttonAvancar.addActionListener(acaoBtnAvancar_DadosPessoais);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnCancelar.setBounds(20, 193, 90, 23);
		panelDadosPessoais.add(btnCancelar);

		EventoBotaoCancelar_DadosPessoais acaoBtnCancelar_DadosPessoais = new EventoBotaoCancelar_DadosPessoais();
		btnCancelar.addActionListener(acaoBtnCancelar_DadosPessoais);

		//Contato
		panelContato = new JPanel();
		tabbedPane.addTab("Contato", null, panelContato, null);
		panelContato.setLayout(null);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 11, 22, 23);
		lblRua.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblRua);

		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldRua.setBounds(63, 11, 349, 23);
		panelContato.add(textFieldRua);
		textFieldRua.setColumns(10);

		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 45, 35, 23);
		lblBairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblBairro);

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(63, 45, 349, 23);
		panelContato.add(textFieldBairro);

		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 79, 41, 23);
		lblCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(63, 79, 204, 23);
		panelContato.add(textFieldCidade);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(277, 79, 40, 23);
		lblEstado.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblEstado);

		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxEstado.setBounds(327, 79, 45, 23);
		String[] arrayUF = {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", 
				"RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		for(int i = 0; i < 28; i++)
			comboBoxEstado.addItem(arrayUF[i]);
		panelContato.add(comboBoxEstado);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 113, 50, 23);
		lblTelefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblTelefone);

		formattedTextFieldTelefone = new JFormattedTextField();
		formattedTextFieldTelefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		formattedTextFieldTelefone.setBounds(63, 113, 130, 23);
		maskTelefone = new MaskFormatter("(##) ####-####");
		maskTelefone.setValidCharacters("1234567890");
		maskTelefone.install(formattedTextFieldTelefone);
		panelContato.add(formattedTextFieldTelefone);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 147, 36, 23);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldEmail.setBounds(63, 147, 349, 23);
		panelContato.add(textFieldEmail);
		
		//botoes aba contato
		buttonAvancarContato = new JButton("Avan\u00E7ar >");
		buttonAvancarContato.setFont(new Font("Gisha", Font.PLAIN, 13));
		buttonAvancarContato.setBounds(312, 193, 95, 23);
		panelContato.add(buttonAvancarContato);

		EventoBotaoAvancar_Contato acaoBtnAvancar_Contato = new EventoBotaoAvancar_Contato();
		buttonAvancarContato.addActionListener(acaoBtnAvancar_Contato);

		buttonVoltarContato = new JButton("< Voltar");
		buttonVoltarContato.setFont(new Font("Gisha", Font.PLAIN, 13));
		buttonVoltarContato.setBounds(207, 193, 95, 23);
		panelContato.add(buttonVoltarContato);

		EventoBotaoVoltar_Contato acaoBtnVoltar_Contato = new EventoBotaoVoltar_Contato();
		buttonVoltarContato.addActionListener(acaoBtnVoltar_Contato);

		//credenciais
		panelCredenciais = new JPanel();
		tabbedPane.addTab("Credenciais", null, panelCredenciais, null);
		panelCredenciais.setLayout(null);

		lblNomeUsuario = new JLabel("Usu\u00E1rio");
		lblNomeUsuario.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNomeUsuario.setBounds(94, 51, 65, 23);
		panelCredenciais.add(lblNomeUsuario);

		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldNomeUsuario.setBounds(150, 51, 202, 23);
		panelCredenciais.add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);

		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblSenha.setBounds(94, 85, 46, 23);
		panelCredenciais.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 85, 128, 23);
		panelCredenciais.add(passwordField);

		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblConfirmarSenha.setBounds(35, 119, 105, 23);
		panelCredenciais.add(lblConfirmarSenha);

		passwordField_Confirmar = new JPasswordField();
		passwordField_Confirmar.setBounds(150, 119, 128, 23);
		panelCredenciais.add(passwordField_Confirmar);

		//botoes
		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBounds(226, 169, 91, 23);
		buttonCadastrar.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelCredenciais.add(buttonCadastrar);

		EventoBotaoCadastrar acaoBotaoCadastrar = new EventoBotaoCadastrar();
		buttonCadastrar.addActionListener(acaoBotaoCadastrar);

		btnVoltarCredenciais = new JButton("< Voltar");
		btnVoltarCredenciais.setFont(new Font("Gisha", Font.PLAIN, 13));
		btnVoltarCredenciais.setBounds(127, 169, 91, 23);
		panelCredenciais.add(btnVoltarCredenciais);

		EventoBotaoVoltar_Credenciais acaoBtnVoltar_Credenciais = new EventoBotaoVoltar_Credenciais();
		btnVoltarCredenciais.addActionListener(acaoBtnVoltar_Credenciais);
	}

	public void setVisible(boolean opcao) {
		if(opcao == true)
			frame.setVisible(opcao);
		else
			frame.setVisible(opcao);
	}

	private class EventoBotaoAvancar_DadosPessoais implements ActionListener {
		public void actionPerformed(ActionEvent evento) {

			vendedor.setNome(textFieldNome.getText());
			vendedor.setCpf(formattedTextFieldCpf.getText());

			//Converte o incice do comboBox em ano
			int ano = 1998;
			for(int i=1; i<=84; i++) {
				if(comboBoxAno.getSelectedIndex() == i) {
					ano = ano - i;
				}
			}

			vendedor.setDataNascimento(comboBoxDia.getSelectedIndex(), comboBoxMes.getSelectedIndex(), ano);

			//vai pra proxima aba se n houver nenhum espaço em braco
			if(vendedor.getNome().equals("") || vendedor.getCpf().equals("") || (comboBoxDia.getSelectedIndex() == 0 ||
					comboBoxMes.getSelectedIndex() == 0 || comboBoxAno.getSelectedIndex() == 0)) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!");
			}
			else
				tabbedPane.setSelectedIndex(1); //vai para aba Contato 
		}
	}

	private class EventoBotaoCancelar_DadosPessoais implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			textFieldNome.setText("");
			formattedTextFieldCpf.setText("");
			comboBoxDia.setSelectedIndex(0);
			comboBoxMes.setSelectedIndex(0);
			comboBoxAno.setSelectedIndex(0);
			textFieldEmail.setText("");
			comboBoxEstado.setSelectedIndex(0);
			textFieldBairro.setText("");
			textFieldRua.setText("");
			textFieldNomeUsuario.setText("");
			formattedTextFieldTelefone.setText("");
			passwordField.setText("");
			passwordField_Confirmar.setText("");
			frame.dispose();
			telaInicio = new TelaInicio();
			telaInicio.setVisible(true);
			
		}
	}

	private class EventoBotaoAvancar_Contato implements ActionListener {
		public void actionPerformed(ActionEvent evento) {

			contato = new Contato(textFieldRua.getText(), textFieldBairro.getText(), textFieldCidade.getText(),
					comboBoxEstado.getSelectedItem().toString(), textFieldEmail.getText(), formattedTextFieldTelefone.getText());
			
			vendedor.setContato(contato);

			//vai pra proxima aba se n houver nenhum espaço em braco
			if(vendedor.getContato().getLogradouro().equals("") || vendedor.getContato().getBairro().equals("") || 
					vendedor.getContato().getCidade().equals("") || vendedor.getContato().getEstado().equals("") || 
					vendedor.getContato().getTelefone().equals("") || vendedor.getContato().getEmail().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!");
			}
			else
				tabbedPane.setSelectedIndex(2); //vai para aba Credenciais
		}
	}

	private class EventoBotaoVoltar_Contato implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			tabbedPane.setSelectedIndex(0);
		}
	}

	private class EventoBotaoCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {

			try {
				if(textFieldNome.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Nome' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if(maskCpf.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'CPF' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				}  else if (comboBoxDia.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo dia de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxMes.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo mês de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxAno.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo ano de 'Data de nascimento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if(textFieldRua.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Rua' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (textFieldBairro.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Bairro' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (textFieldCidade.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Cidade' encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (maskTelefone.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Telefone' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (textFieldEmail.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'E-mail' encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (comboBoxEstado.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Estado' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (textFieldNomeUsuario.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Username' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (passwordField.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Senha' encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

				} else if (passwordField_Confirmar.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Confirmar senha' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				} else{
					String senha = new String(passwordField.getPassword());
					String senhaConfirma = new String(passwordField_Confirmar.getPassword());

					if(senha.equals(senhaConfirma)) {
						vendedor.setNome(textFieldNome.getSelectedText());
						vendedor.setNomeUsuario(textFieldNomeUsuario.getSelectedText());
						vendedor.setCpf(maskCpf.getMask());
						//setContato já feito
						vendedor.setSenha(senha);
						vendedor.setXp(xp);
						vendedor.setDataCadastro();
						fachada.cadastrarVendedor(vendedor);
						fachada.salvarVendedor();

						//mensagem boas vindas
						JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!\nBem-vindo ao Mercado Árabe");
						textFieldNomeUsuario.setText("");
						passwordField.setText("");
						passwordField_Confirmar.setText("");
						telaInicio = new TelaInicio();
						telaInicio.setVisible(true);
						frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "As senhas precisam ser iguais!");
					passwordField.setText("");
					passwordField_Confirmar.setText("");
				}
			}

		} catch(NomeUsuarioForaPadroesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			textFieldNomeUsuario.setText("");
			passwordField.setText("");
			passwordField_Confirmar.setText("");

		} catch(NomeUsuarioJaCadastradoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			textFieldNomeUsuario.setText("");
			passwordField.setText("");
			passwordField_Confirmar.setText("");

		} catch(SenhaForaPadroesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()); //organizar aqui
			passwordField.setText("");
			passwordField_Confirmar.setText("");

		} catch(CpfJaCadastradoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			formattedTextFieldCpf.setText("");
			passwordField.setText("");
			passwordField_Confirmar.setText("");
		} catch (IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "Argumento inválido");
		}	
	}
}

	private class EventoBotaoVoltar_Credenciais implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			tabbedPane.setSelectedIndex(1);
		}
	}
}
