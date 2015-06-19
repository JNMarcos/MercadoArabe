package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton buttonCont;
	private JButton buttonContinuar;
	private JButton buttonOK;



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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Gisha", Font.PLAIN, 13));
		tabbedPane.setBounds(0, 0, 440, 270);
		frame.getContentPane().add(tabbedPane);
		
		panelDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados pessoais", null, panelDadosPessoais, null);
		panelDadosPessoais.setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNome.setBounds(10, 11, 36, 23);
		panelDadosPessoais.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldNome.setBounds(55, 10, 357, 23);
		panelDadosPessoais.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblDataDeNascimento.setBounds(10, 111, 125, 23);
		panelDadosPessoais.add(lblDataDeNascimento);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblCpf.setBounds(10, 66, 23, 23);
		panelDadosPessoais.add(lblCpf);
		
		formattedTextFieldCpf = new JFormattedTextField();
		formattedTextFieldCpf.setBounds(43, 63, 169, 23);
		panelDadosPessoais.add(formattedTextFieldCpf);
		
		comboBoxDia = new JComboBox<>();
		comboBoxDia.setBounds(185, 112, 28, 20);
		String[] arrayDia = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for (int i = 0; i < 31; i++){
		comboBoxDia.addItem(arrayDia[i]);
		}
		panelDadosPessoais.add(comboBoxDia);
		
		comboBoxMes = new JComboBox<>();
		comboBoxMes.setBounds(290, 112, 28, 20);
		panelDadosPessoais.add(comboBoxMes);
		
		comboBoxAno = new JComboBox<>();
		comboBoxAno.setBounds(368, 112, 28, 20);
		panelDadosPessoais.add(comboBoxAno);
		
		buttonCont = new JButton("Continuar");
		buttonCont.setFont(new Font("Gisha", Font.PLAIN, 13));
		buttonCont.setBounds(176, 183, 89, 23);
		panelDadosPessoais.add(buttonCont);
		
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
		textFieldRua.setBounds(42, 11, 370, 23);
		panelContato.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Gisha", Font.PLAIN, 13));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(55, 54, 358, 23);
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
		formattedTextFieldEmail.setBounds(65, 164, 347, 23);
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
}
