package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Contato;
import br.ufrpe.negocio.classes_basicas.Vendedor;

public class TelaCadastroVendedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panelDadosPessoais;
	private JPanel panelContato;
	private JPanel panelAcesso;
	
	
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
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldSenha;
	private JTextField textFieldNomeUsuario;
	private JTextField textFieldConfirmarSenha;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAno;
	private JComboBox<String> comboBoxEstado;
	private JFormattedTextField formattedTextFieldTelefone;
	private JFormattedTextField formattedTextFieldEmail;
	private JButton buttonAvancar;
	private JButton buttonContinuar;
	private JButton buttonOK;
	private JButton btnCancelar;

	private Fachada fachada;
	private Vendedor vendedor;
	private Contato contato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVendedor window = new TelaCadastroVendedor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cadastro Vendedor");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
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
		
		formattedTextFieldCpf = new JFormattedTextField();
		formattedTextFieldCpf.setBounds(55, 76, 169, 23);
		panelDadosPessoais.add(formattedTextFieldCpf);
		
		lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblDataDeNascimento.setBounds(9, 110, 125, 23);
		panelDadosPessoais.add(lblDataDeNascimento);
		
		//dia
		comboBoxDia = new JComboBox<>();
		comboBoxDia.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxDia.setBounds(144, 112, 41, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		panelDadosPessoais.add(comboBoxDia);
		
		//mes
		comboBoxMes = new JComboBox<>();
		comboBoxMes.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxMes.setBounds(194, 111, 91, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		panelDadosPessoais.add(comboBoxMes);
		
		//ano
		comboBoxAno = new JComboBox<>();
		comboBoxAno.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxAno.setBounds(294, 111, 57, 20);
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
		
		//fachada = new Fachada();
		vendedor = new Vendedor();
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
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 164, 36, 23);
		lblEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblEmail);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 130, 50, 23);
		lblTelefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblTelefone);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 11, 22, 23);
		lblRua.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblRua);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 55, 35, 23);
		lblBairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblBairro);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 89, 41, 23);
		lblCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblCidade);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(289, 89, 40, 23);
		lblEstado.setFont(new Font("Gisha", Font.PLAIN, 13));
		panelContato.add(lblEstado);
		
		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldRua.setBounds(63, 11, 349, 23);
		panelContato.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(64, 54, 349, 23);
		panelContato.add(textFieldBairro);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(65, 91, 204, 23);
		panelContato.add(textFieldCidade);
		
		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBoxEstado.setBounds(385, 93, 28, 20);
		panelContato.add(comboBoxEstado);
		
		formattedTextFieldTelefone = new JFormattedTextField();
		formattedTextFieldTelefone.setFont(new Font("Gisha", Font.PLAIN, 13));
		formattedTextFieldTelefone.setBounds(70, 130, 200, 23);
		panelContato.add(formattedTextFieldTelefone);
		
		formattedTextFieldEmail = new JFormattedTextField();
		formattedTextFieldEmail.setFont(new Font("Gisha", Font.PLAIN, 13));
		formattedTextFieldEmail.setBounds(63, 164, 349, 23);
		panelContato.add(formattedTextFieldEmail);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonContinuar.setFont(new Font("Gisha", Font.PLAIN, 13));
		buttonContinuar.setBounds(176, 198, 89, 23);
		panelContato.add(buttonContinuar);
		
		panelAcesso = new JPanel();
		tabbedPane.addTab("Credenciais", null, panelAcesso, null);
		panelAcesso.setLayout(null);
		
		lblNomeUsuario = new JLabel("Nome de usu\u00E1rio");
		lblNomeUsuario.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNomeUsuario.setBounds(10, 50, 113, 23);
		panelAcesso.add(lblNomeUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblSenha.setBounds(58, 84, 46, 23);
		panelAcesso.add(lblSenha);
		
		lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblConfirmarSenha.setBounds(10, 124, 113, 23);
		panelAcesso.add(lblConfirmarSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldSenha.setEnabled(true);
		textFieldSenha.setText("");
		textFieldSenha.setBounds(133, 85, 146, 23);
		panelAcesso.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldNomeUsuario.setBounds(131, 51, 254, 23);
		panelAcesso.add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);
		
		textFieldConfirmarSenha = new JTextField();
		textFieldConfirmarSenha.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldConfirmarSenha.setBounds(133, 125, 146, 23);
		panelAcesso.add(textFieldConfirmarSenha);
		textFieldConfirmarSenha.setColumns(10);
		
		buttonOK = new JButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonOK.setBounds(176, 183, 89, 23);
		panelAcesso.add(buttonOK);
		buttonOK.setFont(new Font("Gisha", Font.PLAIN, 13));
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
			
			//esse bloco serve p/ converter o incice do comboBox em ano
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
				tabbedPane.setSelectedIndex(1); //vai pra proxima aba
		}
	}
	
	private class EventoBotaoCancelar_DadosPessoais implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			frame.setVisible(false);
		}
	}
}
