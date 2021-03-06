package br.ufrpe.negocio.controladores;

import java.util.List;

import br.ufrpe.dados.IRepositorioComprador;
import br.ufrpe.dados.RepositorioComprador;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;
import br.ufrpe.negocio.utilidades.PessoaUtilidades;

public class ControladorComprador {
	private IRepositorioComprador repositorio;

	public ControladorComprador(){
		this.repositorio = RepositorioComprador.getInstancia();
	}

	public List<Comprador> getCompradores() {
		return repositorio.getCompradores();
	}

	public void cadastrarComprador(Comprador comprador) throws NomeUsuarioJaCadastradoException, 
	NomeUsuarioForaPadroesException, SenhaForaPadroesException, IllegalArgumentException {
		boolean nomeUsuarioJaExiste;
		if (comprador == null){
			throw new IllegalArgumentException();
		} else{
			if (PessoaUtilidades.nomeUsuarioNosConformes(comprador.getNomeUsuario())){

			} else {
				throw new NomeUsuarioForaPadroesException();
			}
			if (PessoaUtilidades.senhaNosConformes(comprador.getSenha())){

			} else{
				throw new SenhaForaPadroesException();
			}
			PessoaUtilidades.nomeNosConformes(comprador.getNome());


			nomeUsuarioJaExiste = repositorio.verificarNomeUsuarioJaExiste(comprador.getNomeUsuario());
			if (nomeUsuarioJaExiste == false){
				repositorio.cadastrarComprador(comprador);
			} else {
				throw new NomeUsuarioJaCadastradoException();
			}
		}
	}

	public void atualizarComprador(Comprador comprador) throws NaoEncontradoCompradorException, IllegalArgumentException {
		Comprador c;
		int index;
		if (comprador != null){
			c  = repositorio.retornarComprador(comprador.getNomeUsuario());
			index = repositorio.procurarIndice(comprador);
		} else {
			throw new IllegalArgumentException();
		}

		if (index != -1 && c != null){
			repositorio.atualizarComprador(c, index);
		} else {
			throw new NaoEncontradoCompradorException();
		}
	}

	public void removerComprador(Comprador comprador) throws NaoEncontradoCompradorException, IllegalArgumentException {
		if (comprador != null){
			int index = repositorio.procurarIndice(comprador);
			if (index != -1)
				repositorio.removerComprador(comprador);
			else throw new NaoEncontradoCompradorException();
		} else{ 
			throw new IllegalArgumentException();
		}
	}

	public void salvarComprador() {
		RepositorioComprador.salvarArquivo();

	}

	public Comprador verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoCompradorException, SenhaIncorretaException {
		Comprador comprador = null;
		boolean retSenha = false;
		boolean retNomeUsuario = false;

		if (!senha.equals("")) retSenha = repositorio.verificarSenhaJaExiste(senha);
		if (!nomeUsuario.equals("")) retNomeUsuario = repositorio.verificarNomeUsuarioJaExiste(nomeUsuario);

		if (retSenha && retNomeUsuario){
			comprador = repositorio.verificarLogin(nomeUsuario, senha);
		} else if (retNomeUsuario == false && retSenha){
			throw new NaoEncontradoCompradorException();
		} else if (retNomeUsuario && retSenha == false){
			throw new SenhaIncorretaException();
		} else {
			throw new NaoEncontradoCompradorException();// mais importante saber para algu�m que o usuario n�o existe do que uma senha
		}

		if (retNomeUsuario && comprador == null) throw new SenhaIncorretaException();
		return comprador;

	}

	public Comprador retornarComprador(String nomeUsuario) throws NaoEncontradoCompradorException, IllegalArgumentException{
		Comprador comprador = null;
		if (!nomeUsuario.equals("")){
			comprador = repositorio.retornarComprador(nomeUsuario);
			if (comprador.equals("")) throw new NaoEncontradoCompradorException();
		} else {
			throw new IllegalArgumentException();
		}

		return comprador;	}

	public void adicionarAosAdquiridos(Comprador c, Produto p){
		repositorio.adicionarAosAdquiridos(c, p);
	}

	public void adicionarAosFavoritos(Comprador c, Produto p){
		repositorio.adicionarAosFavoritos(c, p);
	}

	public void adicionarAosInteresses(Comprador c, Produto p){
		repositorio.adicionarAosInteresses(c, p);
	}

	public void removerDosFavoritos (Comprador c, Produto p){
		repositorio.removerDosFavoritos(c, p);
	}

	public void removerDosInteresses (Comprador c, Produto p){
		repositorio.removerDosInteresses(c, p);
	}

}
