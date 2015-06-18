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
import br.ufrpe.negocio.controladores.ControladorComprador;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class RepositorioComprador implements IRepositorioComprador, Iterator<Comprador>, Serializable {
	private static final long serialVersionUID = 1L;
	private static int posicao = 0;
	List<Comprador> compradores;
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
	public void criarListaCompradores() {
		compradores = new ArrayList<Comprador>();
		
	}

	@Override
	public List<Comprador> getCompradores() {
		if(this.compradores!=null)
			Collections.sort(compradores);
		return compradores;
	}

	@Override
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario) {
		boolean nomeUsuarioJaExiste = false;
		if (!nomeUsuario.equals("") && !nomeUsuario.equals(" ")){
			Iterator<Comprador> iComprador= this.compradores.listIterator();
			while(iComprador.hasNext()){
				if (iComprador.next().getNomeUsuario().equals(nomeUsuario)){
					nomeUsuarioJaExiste = true;
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}
		}
		return nomeUsuarioJaExiste;
	}

	@Override
	public boolean verificarSenha(String senha) {
		boolean senhaNoRepositorio = true;
		if (!senha.equals("") && !senha.equals(" ")){
			Iterator<Comprador> iComprador = this.compradores.listIterator();
			while(iComprador.hasNext()){
				if (iComprador.next().getSenha().equals(senhaNoRepositorio)){
					senhaNoRepositorio = false;
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}
		}
		return senhaNoRepositorio;
	}

	@Override
	public void cadastrarComprador(Comprador comprador)
			throws NomeUsuarioJaCadastradoException {
		if (this.compradores == null){
			criarListaCompradores();
		}
			this.compradores.add(comprador);
			salvarArquivo();
	}

	@Override
	public void removerComprador(String nomeUsuario)
			throws NaoEncontradoCompradorException {
		boolean removeu = false;
		if (!nomeUsuario.equals("") && !nomeUsuario.equals(" ")){
			Iterator<Comprador> iComprador = this.compradores.listIterator();
			while(iComprador.hasNext()){
				if (iComprador.next().getNomeUsuario().equals(nomeUsuario)){
					iComprador.remove();
					removeu = true;
					zerarContadorPosicao();
					salvarArquivo();
					break;
				}
				incrementarContadorPosicao();
			}
		}

		if (removeu == false){
			throw new NaoEncontradoCompradorException();
		}
		
	}

	@Override
	public Comprador exibirInfoComprador(String nomeUsuario) {
		Comprador comprador = null;
		if (!nomeUsuario.equals("") && !nomeUsuario.equals(" ")){
			Iterator<Comprador> iComprador = this.compradores.listIterator();
			while(iComprador.hasNext()){
				if (iComprador.next().getNomeUsuario().equals(nomeUsuario)){
					comprador = iComprador.next();
					zerarContadorPosicao();
					break;
				}
				incrementarContadorPosicao();
			}	
		}
		return comprador;
	}

	@Override
	public Comprador verificarLogin(String nomeUsuario, String senha)
			throws NaoEncontradoCompradorException, SenhaIncorretaException {
		Comprador comprador = null;
		Iterator<Comprador> iComprador = this.compradores.listIterator();
		while(iComprador.hasNext()){
			if (iComprador.next().getNomeUsuario().equals(nomeUsuario) && iComprador.next().getSenha().equals(senha)){
				comprador = iComprador.next();
				zerarContadorPosicao();
				break;
			}
			incrementarContadorPosicao();
		}

		return comprador;
	}

	public Comprador next(){
		Comprador comprador = this.compradores.get(posicao);
		return comprador;
	}
	public boolean hasNext(){
		boolean temProximo = true;//posto true pois comumente será mais vezes true
		if (posicao >= this.compradores.size() || this.compradores.get(posicao) == null) {
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
		// TODO Auto-generated method stub
		
	}
}
