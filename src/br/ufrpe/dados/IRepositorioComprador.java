package br.ufrpe.dados;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public interface IRepositorioComprador{
	public abstract void criarListaCompradores();

	public abstract List<Comprador> getCompradores();
	
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario);
	
	public boolean verificarSenha(String senha); 

	public abstract void cadastrarComprador(Comprador comprador) throws NomeUsuarioJaCadastradoException;

	public abstract void removerComprador(String nomeUsuario) throws NaoEncontradoCompradorException;

	public abstract Comprador exibirInfoComprador(String nomeUsuario);

	public abstract Comprador verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoCompradorException, SenhaIncorretaException;

}
