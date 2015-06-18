package br.ufrpe.negocio.controladores;

import java.util.List;

import br.ufrpe.dados.IRepositorioComprador;
import br.ufrpe.dados.RepositorioComprador;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class ControladorComprador {
	private IRepositorioComprador repositorio;

	public ControladorComprador(){
		this.repositorio = RepositorioComprador.getInstancia();
	}

	public void cadastrarComprador(Comprador comprador) throws NomeUsuarioJaCadastradoException {
		boolean nomeUsuarioJaExiste;
		if (comprador == null){
			throw new NullPointerException();
		} else{
			 nomeUsuarioJaExiste = repositorio.verificarNomeUsuarioJaExiste(comprador.getNomeUsuario());
			if (nomeUsuarioJaExiste == false){
				repositorio.cadastrarComprador(comprador);
			} else {
				throw new NomeUsuarioJaCadastradoException();
			}
		}
	}

	public void removerComprador(String cpf) throws NaoEncontradoCompradorException {
		repositorio.removerComprador(cpf);

	}

	public void salvarComprador() {
		RepositorioComprador.salvarArquivo();

	}

	public List<Comprador> getCompradores() {
		return repositorio.getCompradores();
	}

	public Comprador exibirInfoComprador(String cpf) {
		return repositorio.exibirInfoComprador(cpf);
	}

	public Comprador verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoCompradorException, SenhaIncorretaException {
		return repositorio.verificarLogin(nomeUsuario, senha);
	}
}
