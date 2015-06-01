package br.ufrpe.negocio.cadastros;

import java.util.ArrayList;

import br.ufrpe.dados.IRepositorioVendedor;
import br.ufrpe.dados.RepositorioVendedor;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;

public class CadastroVendedor {

	private IRepositorioVendedor repositorio;

	public CadastroVendedor(){
		this.repositorio = RepositorioVendedor.getInstancia();
	}

	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException {
		repositorio.cadastrarVendedor(vendedor);

	}

	public void removerVendedor(String cpf) throws NaoEncontradoVendedorException {
		repositorio.removerVendedor(cpf);

	}

	public void salvarVendedor() {
		RepositorioVendedor.salvarArquivo();

	}

	public ArrayList<Vendedor> getVendedores() {
		return repositorio.getVendedores();
	}

	public Vendedor exibirInfoVendedor(String cpf) {
		return repositorio.exibirInfoVendedor(cpf);
	}

	public Vendedor verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoVendedorException {
		return repositorio.verificarLogin(nomeUsuario, senha);
	}


}
