package gui.telas_principais;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicio extends JFrame {
	private static TelaInicio frame;
	private JPanel contentPane;
	public static boolean instanciar;
	private static TelaInicio instance;

	public static void main(String[] args){
		frame = new TelaInicio();
	}

	public TelaInicio(){
		setVisible(true);
		setForeground(Color.YELLOW);
		setBackground(SystemColor.desktop);
		setTitle("Mercado Árabe - Do Brasil à Arábia, tudo num só lugar!");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("")); por uma imagem para o app
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 306);
		setLocationRelativeTo(null);	

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entre");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin login = new TelaLogin();
			}
		});
		btnEntrar.setBounds(79, 69, 110, 23);//modificar valores depois
		contentPane.add(btnEntrar);

		JButton btnCadastrar = new JButton("Cadastre-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
			}
		});
		btnCadastrar.setBounds(79, 103, 110, 23);//modificar valores depois
		contentPane.add(btnCadastrar);

		JButton btnQueroComprar = new JButton("Quero comprar!");
		btnQueroComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPesquisaProdutos pesquisa = new TelaPesquisaProdutos();
			}
		});
		btnQueroComprar.setBounds(79, 69, 110, 23);//modificar valores depois
		contentPane.add(btnQueroComprar);
	}

}
