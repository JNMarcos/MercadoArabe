package dados;

import java.util.ArrayList;
import java.util.Collections;

import classes_basicas.Vendedor;
import exceptions.CpfJaCadastradoException;
import exceptions.NaoEncontradoVendedorException;
import exceptions.NomeUsuarioJaCadastradoException;

public interface IRepositorioVendedor {
	
	public abstract void criarListaVendedores();

	public abstract ArrayList<Vendedor> getVendedores();

	public abstract void setVendedores(ArrayList<Vendedor> vendedores);

	public abstract int procurarPorVendedor(String cpfVendedor);

	public abstract int procurarPorNomeUsuario(String nomeUsuario);

	public abstract int procurarPorSenha(String senha);

	public abstract void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException;

	public abstract void descadastrarVendedor(String cpfVendedor) throws NaoEncontradoVendedorException;

	public abstract Vendedor mostrarVendedor(String cpfVendedor);

	public abstract Vendedor verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoVendedorException;

}
