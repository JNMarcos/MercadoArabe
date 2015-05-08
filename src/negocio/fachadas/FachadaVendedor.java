package negocio.fachadas;

import java.util.ArrayList;

import negocio.cadastros.CadastroVendedor;
import negocio.classes_basicas.Vendedor;
import negocio.exceptions.CpfJaCadastradoException;
import negocio.exceptions.NaoEncontradoVendedorException;
import negocio.exceptions.NomeUsuarioJaCadastradoException;

public class FachadaVendedor {
	private CadastroVendedor cadastroVendedor = new CadastroVendedor();

	private FachadaVendedor() {
		// Construtor privado para evitar instanciação fora da classe
	}

	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException {
		cadastroVendedor.cadastrarVendedor(vendedor);
	}

	public void removerVendedor(String cpf) throws NaoEncontradoVendedorException {
		cadastroVendedor.removerVendedor(cpf);
	}

	public void salvarVendedor() {
		cadastroVendedor.salvarVendedor();
	}

	public ArrayList<Vendedor> retornarListaVendedores() {
		return cadastroVendedor.getVendedores();
	}

	public Vendedor exibirInfoVendedor(String cpf) {
		return cadastroVendedor.exibirInfoVendedor(cpf);
	}

	public Vendedor verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoVendedorException {
		return cadastroVendedor.verificarLogin(nomeUsuario, senha);
	}

}
