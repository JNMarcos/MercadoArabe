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
import java.util.List;

import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.controladores.ControladorComprador;

public class RepositorioComprador implements IRepositorioComprador, Serializable {
	private static final long serialVersionUID = 1L;
	List<Comprador> compradores = new ArrayList<Comprador>();
	public static ControladorComprador controladorComprador = new ControladorComprador();
	private static RepositorioComprador instancia;

	public static RepositorioComprador getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioComprador();
		}
		return instancia;
	}

	private static RepositorioComprador lerDoArquivo() {
		RepositorioComprador instanciaLocal = null;

		File in = new File("repositorioComprador.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioComprador) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioComprador();
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
		File out = new File("repositorioComprador.dat");
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

	@Override
	public List<Comprador> getCompradores() {
		if(this.compradores!=null)
			Collections.sort(compradores);
		return compradores;
	}


	@Override
	public void cadastrarComprador(Comprador comprador) {
		this.compradores.add(comprador);
		salvarArquivo();
	}

	public void atualizarComprador(Comprador comprador, int posicao){
		compradores.set(posicao, comprador);
		salvarArquivo();
	}

	public void removerComprador(Comprador comprador) {
		compradores.remove(comprador);
		salvarArquivo();
	}

	public int procurarIndice(Comprador comprador){
		int retAux = -1;
		for (int i = 0; i < compradores.size(); i++){
			if (compradores.get(i).getNomeUsuario().equals(comprador.getNomeUsuario())){
				retAux = i;
				break;
			}
		}
		return retAux;
	}

	public Comprador retornarComprador(String nomeUsuario){
		Comprador comprador = null;
		for (int i = 0; i < compradores.size(); i++){
			if (compradores.get(i).getNomeUsuario().equals(nomeUsuario)) {		
				comprador = compradores.get(i);
				break;
			}
		}
		return comprador;
	}

	@Override
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario) {
		boolean nomeUsuarioJaExiste = false;
		if (nomeUsuario != null){
			if (compradores.size() > 0){
				for (int i = 0; i < compradores.size(); i++){
					if (compradores.get(i).getNomeUsuario().equals(nomeUsuario)){
						nomeUsuarioJaExiste = true;
						break;
					}
				}
			}
		}
		return nomeUsuarioJaExiste;
	}

	public boolean verificarSenhaJaExiste(String senha) {
		boolean senhaJaExiste = false;
		if (senha != null){
			for (int i = 0; i < compradores.size(); i++){
				if (compradores.get(i).getSenha().equals(senha)){
					senhaJaExiste = true;
					break;
				}
			}
		}
		return senhaJaExiste;
	}

	@Override
	public Comprador verificarLogin(String nomeUsuario, String senha) {
		Comprador comprador = null;
		for (int i = 0; i < compradores.size(); i++){
			if (compradores.get(i).getNomeUsuario().equals(nomeUsuario) && compradores.get(i).getSenha().equals(senha)){
				comprador = compradores.get(i);
				break;
			}
		}

		return comprador;
	}
	
	public void adicionarAosAdquiridos (Comprador c, Produto p){
		c.getProdutosAdquiridos().add(p);
		c.incrementarProdAdquiridos();
	}
	
	public void adicionarAosFavoritos (Comprador c, Produto p){
		c.getFavoritos().add(p);
		c.incrementarProdFavoritos();
	}
	
	public void adicionarAosInteresses (Comprador c, Produto p){
		c.getProdutosInteressantes().add(p);
		c.incrementarProdInteresses();
	}
	
	public void removerDosFavoritos (Comprador c, Produto p){
		c.getFavoritos().remove(p);
		c.decrementarProdFavoritos();
	}
	
	public void removerDosInteresses (Comprador c, Produto p){
		c.getProdutosInteressantes().remove(p);
		c.decrementarProdInteresses();
	}
}
