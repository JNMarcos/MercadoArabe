package br.ufrpe.dados;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Comprador;

public interface IRepositorioComprador{

	public abstract List<Comprador> getCompradores();
	
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario);
	
	public boolean verificarSenhaJaExiste(String senha);

	public abstract void cadastrarComprador(Comprador comprador);

	public abstract void removerComprador (Comprador comprador);
	
	public abstract void atualizarComprador (Comprador comprador, int index);

	public abstract Comprador verificarLogin(String nomeUsuario, String senha);

	public abstract Comprador retornarComprador(String nomeUsuario);

	public abstract int procurarIndice(Comprador comprador);

}