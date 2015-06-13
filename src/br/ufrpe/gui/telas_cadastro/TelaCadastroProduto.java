package br.ufrpe.gui.telas_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.JPanel;

public class TelaCadastroProduto {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto window = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Pr\u00F3ximo");
		btnNewButton.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 75, 46, 14);
		frame.getContentPane().add(lblNome);
		
	
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 130, 77, 14);
		frame.getContentPane().add(lblDescricao);
		
		textField_2 = new JTextField();
		textField_2.setBounds(77, 61, 292, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 434, 23);
		frame.getContentPane().add(tabbedPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(77, 130, 322, 79);
		frame.getContentPane().add(textArea);
	}
}
