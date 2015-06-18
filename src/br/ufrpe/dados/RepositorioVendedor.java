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

import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.controladores.ControladorVendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class RepositorioVendedor implements IRepositorioVendedor, Serializable, Iterator<Vendedor>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int posicao = 0;
	List<Vendedor> vendedores;
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

	public void criarListaVendedores(){
		vendedores = new ArrayList<Vendedor>();
	}

	public List<Vendedor> getVendedores() {
		if(this.vendedores!=null)
			Collections.sort(vendedores);
		return vendedores;
	}


	public boolean verificarCpfJaExiste(String cpfVendedor){
		boolean cpfJaExiste = false;
		if (!cpfVendedor.equals("") && !cpfVendedor.equals(" ")){
			ListIterator<Vendedor> iVendedor = this.vendedores.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getCpf().equals(cpfVendedor)){
					cpfJaExiste = true;
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}
		}
		return cpfJaExiste;
	}
	
	public Vendedor vendedorExiste(String cpfVendedor){
		Vendedor vendedorExiste = null;
		if (!cpfVendedor.equals("") && !cpfVendedor.equals(" ")){
			ListIterator<Vendedor> iVendedor = this.vendedores.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getCpf().equals(cpfVendedor)){
					vendedorExiste = iVendedor.next();
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}
		}
		return vendedorExiste;
	}

	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario){
		boolean nomeUsuarioJaExiste = false;
		if (!nomeUsuario.equals("") && !nomeUsuario.equals(" ")){
			Iterator<Vendedor> iVendedor = this.vendedores.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getNomeUsuario().equals(nomeUsuario)){
					nomeUsuarioJaExiste = true;
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}
		}
		return nomeUsuarioJaExiste;
	}

	public boolean verificarSenha(String senha){
		boolean senhaNoRepositorio = true;
		if (!senha.equals("") && !senha.equals(" ")){
			Iterator<Vendedor> iVendedor = this.vendedores.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getSenha().equals(senhaNoRepositorio)){
					senhaNoRepositorio = false;
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}
		}
		return senhaNoRepositorio;
	}

	public void cadastrarVendedor(Vendedor vendedor){
		if (this.vendedores == null){
			criarListaVendedores();
		}
		this.vendedores.add(vendedor);
		salvarArquivo();
	}

	 

	public Vendedor exibirInfoVendedor(String cpfVendedor){
		Vendedor vendedor = null;
		if (!cpfVendedor.equals("") && !cpfVendedor.equals(" ")){
			Iterator<Vendedor> iVendedor = this.vendedores.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getCpf().equals(cpfVendedor)){
					vendedor = iVendedor.next();
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}	
		}
		return vendedor;
	}


	public Vendedor verificarLogin(String nomeUsuario, String senha){
		Vendedor vendedor = null;
		Iterator<Vendedor> iVendedor = this.vendedores.listIterator();
		while(iVendedor.hasNext()){
			if (iVendedor.next().getNomeUsuario().equals(nomeUsuario) && iVendedor.next().getSenha().equals(senha)){
				vendedor = iVendedor.next();
				zerarContadorPosicao();
				break;
			}
			incrementarContadorPosicao();
		}

		return vendedor;
	}

	public Vendedor next(){
		Vendedor vendedor = this.vendedores.get(posicao);
		return vendedor;
	}

	public boolean hasNext(){
		boolean temProximo = true;//posto true pois comumente ser� mais vezes true
		if (posicao >= this.vendedores.size() || this.vendedores.get(posicao) == null) {
			temProximo = false;
			zerarContadorPosicao();
		}
		return temProximo;
	}

	public static void incrementarContadorPosicao(){
		posicao++;
	}

	public static void zerarContadorPosicao(){
		posicao = 0;
	}

	@Override
	public void remove() {
		
		
	}
}

