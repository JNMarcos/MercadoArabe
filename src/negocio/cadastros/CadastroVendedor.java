package negocio.cadastros;

import java.util.ArrayList;
import dados.IRepositorioVendedor;
import dados.RepositorioVendedor;
import negocio.classes_basicas.Vendedor;
import negocio.exceptions.CpfJaCadastradoException;
import negocio.exceptions.NaoEncontradoVendedorException;
import negocio.exceptions.NomeUsuarioJaCadastradoException;

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
