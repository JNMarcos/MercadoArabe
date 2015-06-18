package br.ufrpe.negocio.controladores;

import java.util.List;

import br.ufrpe.dados.IRepositorioVendedor;
import br.ufrpe.dados.RepositorioVendedor;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class ControladorVendedor {

	private IRepositorioVendedor repositorio;

	public ControladorVendedor(){
		this.repositorio = RepositorioVendedor.getInstancia();
	}

	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException {
		boolean cpfJaExiste;
		boolean nomeUsuarioJaExiste;

		if (vendedor == null){
			throw new IllegalArgumentException();// o que fazer quando null?
		} else {
			cpfJaExiste = repositorio.verificarCpfJaExiste(vendedor.getCpf());
			nomeUsuarioJaExiste = repositorio.verificarNomeUsuarioJaExiste(vendedor.getNomeUsuario());
			if (cpfJaExiste == false && nomeUsuarioJaExiste == false){
				repositorio.cadastrarVendedor(vendedor);
			} else if (cpfJaExiste){
				throw new CpfJaCadastradoException();
			} if (nomeUsuarioJaExiste){
				throw new NomeUsuarioJaCadastradoException();
			}
		}

	}

	public void removerVendedor(String cpf) throws NaoEncontradoVendedorException {

		repositorio.removerVendedor(cpf);

	}

	public void salvarVendedor() {
		RepositorioVendedor.salvarArquivo();

	}

	public List<Vendedor> getVendedores() {
		return repositorio.getVendedores();
	}

	public Vendedor exibirInfoVendedor(String cpf) {
		return repositorio.exibirInfoVendedor(cpf);
	}

	public Vendedor verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoVendedorException, SenhaIncorretaException {
		return repositorio.verificarLogin(nomeUsuario, senha);
	}


}
