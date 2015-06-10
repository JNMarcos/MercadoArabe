package br.ufrpe.dados;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public interface IRepositorioVendedor {
	
	public abstract void criarListaVendedores();

	public abstract List<Vendedor> getVendedores();
	
	public boolean verificarCpfJaExiste(String cpfVendedor);
	
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario);
	
	public boolean verificarSenha(String senha);

	public abstract void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException;

	public abstract void removerVendedor(String cpfVendedor) throws NaoEncontradoVendedorException;

	public abstract Vendedor exibirInfoVendedor(String cpfVendedor);

	public abstract Vendedor verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoVendedorException, SenhaIncorretaException;

}
