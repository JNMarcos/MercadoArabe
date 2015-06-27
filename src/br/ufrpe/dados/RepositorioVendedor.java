package br.ufrpe.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.controladores.ControladorVendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;
import br.ufrpe.negocio.utilidades.PessoaUtilidades;

public class RepositorioVendedor extends PessoaUtilidades implements IRepositorioVendedor, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Vendedor> vendedores = new ArrayList<Vendedor>();
	public static ControladorVendedor cadastroVendedor = new ControladorVendedor();
	private static RepositorioVendedor instancia;

	public static RepositorioVendedor getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioVendedor();
		}
		return instancia;
	}

	private static RepositorioVendedor lerDoArquivo() {
		RepositorioVendedor instanciaLocal = null;

		File in = new File("repositorioVendedor.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioVendedor) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioVendedor();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File("repositorioVendedor.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent exception*/
				}
			}
		}
	}

	public List<Vendedor> getVendedores() {
		if(this.vendedores!=null)
			Collections.sort(vendedores);
		return vendedores;
	}


	public boolean verificarCpfJaExiste(String cpfVendedor){
		boolean cpfJaExiste = false;
		if (!cpfVendedor.equals("") && !cpfVendedor.equals(" ")){
				for (int i = 0; i < vendedores.size(); i++){
					if (vendedores.get(i).getNomeUsuario().equals(cpfVendedor)){
						cpfJaExiste = true;
						break;
					}
				}
			}
		return cpfJaExiste;
	}
	
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario){
		boolean nomeUsuarioJaExiste = false;
		if (!nomeUsuario.equals("") && !nomeUsuario.equals(" ")){
			for (int i = 0; i < vendedores.size(); i++){
				if (vendedores.get(i).getNomeUsuario().equals(nomeUsuario)){
					nomeUsuarioJaExiste = true;
					break;
				}
			}
		}
		return nomeUsuarioJaExiste;
	}

	public boolean verificarSenhaJaExiste(String senha){
		boolean senhaJaExiste = false;
		if (!senha.equals("") && !senha.equals(" ")){
			for (int i = 0; i < vendedores.size(); i++){
				if (vendedores.get(i).getSenha().equals(senha)){
					senhaJaExiste = true;
					break;
				}
			}
		}
		return senhaJaExiste;
	}

	public void cadastrarVendedor(Vendedor vendedor){
		this.vendedores.add(vendedor);
		salvarArquivo();
	}
	
	public void atualizarVendedor(Vendedor vendedor, int posicao){
		vendedores.set(posicao, vendedor);
		salvarArquivo();
	}
	
	public void removerVendedor(Vendedor vendedor) {
		vendedores.remove(vendedor);
		salvarArquivo();
	}
	public int procurarIndice(Vendedor vendedor){
		int retAux = -1;//índice que indica que não existe tal Vendedor
		for (int i = 0; i < vendedores.size(); i++){
			if (vendedores.get(i).getNomeUsuario().equals(vendedor.getNomeUsuario())){
				retAux = i;
				break;
			}
		}
		return retAux;
	}

	public Vendedor retornarVendedor(String nomeUsuario){
		Vendedor vendedor = null;
		for (int i = 0; i < vendedores.size(); i++){
			if (vendedores.get(i).getNomeUsuario().equals(nomeUsuario)) {		
				vendedor = vendedores.get(i);
				break;
			}
		}
		return vendedor;
	}

	public Vendedor verificarLogin(String nomeUsuario, String senha){
		Vendedor vendedor = null;
		for (int i = 0; i < vendedores.size(); i++){
			if (vendedores.get(i).getNomeUsuario().equals(nomeUsuario) && vendedores.get(i).getSenha().equals(senha)){
				vendedor = vendedores.get(i);
				break;
			}
		}

		return vendedor;
	}

}

