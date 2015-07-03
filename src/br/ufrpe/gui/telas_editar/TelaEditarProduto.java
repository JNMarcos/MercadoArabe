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
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufrpe.gui.telas_principais.TelaVendedor;
import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;

public class TelaEditarProduto extends JFrame{
	Vendedor v;
	Produto p;
	Fachada f;
	public TelaEditarProduto(Produto p) {
		setProduto(p);
		setVendedor(v);
		f = Fachada.getInstance();
		setResizable(false);
		setSize(490,355);
		setTitle("Atualiza\u00E7\u00E3o de informa\u00E7\u00F5es sobre o produto");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 328);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = new Produto();
				try{
					if (!textField.getText().equals("")){
						p.setNome(new String (textField.getText()));
					}
					f.atualizarProduto(p, v);
				}catch (NullPointerException e1){
					JOptionPane.showMessageDialog(null, "Argumento inválido");
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Argumento inválido");
				} catch (NaoEncontradoProdutoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 				
			
				try{
					if(!textField_2.getText().equals("")){
						p.setPreco(textField_2.getText());
					}
					f.atualizarProduto(p, v);
				} catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null, "Argumento inválido");
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Argumento inválido");
				} catch (NaoEncontradoProdutoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				try{
					if(!textArea.getText().equals("")){
						p.setDescricao(textArea.getText());
					}
					f.atualizarProduto(p, v);
				} catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null, "Argumento inválido");
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Argumento inválido");
				} catch (NaoEncontradoProdutoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
			}
		});
		btnConfirmar.setBounds(261, 272, 95, 25);
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Gisha", Font.PLAIN, 13));
		comboBox.setBounds(95, 90, 172, 25);
		panel.add(comboBox);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.dispose();
				TelaVendedor telaVendedor = new TelaVendedor(v);
				telaVendedor.setVisible(true);
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnVoltar.setBounds(127, 272, 67, 25);
		panel.add(btnVoltar);
		btnVoltar.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(25, 131, 60, 17);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(308, 60, 36, 17);
		panel.add(lblPreo);
		lblPreo.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Gisha", Font.PLAIN, 13));
		spinner.setBounds(378, 90, 78, 25);
		panel.add(spinner);
		
		JLabel lblNueoueNecessuerio = new JLabel("N\u00E3o \u00E9 necess\u00E1rio a inclus\u00E3o de todos os dados para a conclus\u00E3o da atualiza\u00E7\u00E3o.");
		lblNueoueNecessuerio.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNueoueNecessuerio.setBounds(26, 227, 399, 34);
		panel.add(lblNueoueNecessuerio);
		
		textField = new JTextField();
		textField.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField.setBounds(74, 57, 208, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 60, 39, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Gisha", Font.PLAIN, 13));
		
		JLabel lblAtualizeSeuProduto = new JLabel("Atualize seu produto");
		lblAtualizeSeuProduto.setBounds(127, 21, 172, 22);
		panel.add(lblAtualizeSeuProduto);
		lblAtualizeSeuProduto.setFont(new Font("Gisha", Font.PLAIN, 18));
		
		textArea = new JTextArea("");
		textArea.setFont(new Font("Gisha", Font.PLAIN, 13));
		textArea.setBounds(100, 152, 356, 68);
		panel.add(textArea);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gisha", Font.PLAIN, 13));
		textField_2.setBounds(368, 57, 82, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel.setBounds(25, 90, 85, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Gisha", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(297, 93, 82, 28);
		panel.add(lblNewLabel_1);
		
	}
	
	private void setVendedor(Vendedor v) {
		this.v = v;
	}
	private void setProduto(Produto p) {
		this.p = p;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextArea textArea;
	private JTextField textField_2;
}
