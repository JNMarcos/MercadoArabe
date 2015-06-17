package br.ufrpe.negocio;

import java.util.List;

import br.ufrpe.negocio.cadastros.ControladorProduto;
import br.ufrpe.negocio.cadastros.ControladorVendedor;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class Fachada {
	private ControladorProduto controladorProduto = new ControladorProduto();
	private ControladorVendedor controladorVendedor = new ControladorVendedor();

	private Fachada() {
		// Construtor privado para evitar instanciação fora da classe
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException {
		controladorProduto.cadastrarProduto(produto);
	}

	public void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException {
		controladorProduto.removerProduto(nomeProduto);
	}

	public void salvarProduto() {
		controladorProduto.salvarProduto();
	}

	public List<Produto> retornarListaProdutos() {
		return controladorProduto.getProdutos();
	}

	public Produto exibirInfoProduto(String nomeProduto) {
		return controladorProduto.exibirInfoProduto(nomeProduto);
	}
	
	//VENDEDOR
	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException {
		controladorVendedor.cadastrarVendedor(vendedor);
	}

	public void removerVendedor(String cpf) throws NaoEncontradoVendedorException {
		controladorVendedor.removerVendedor(cpf);
	}

	public void salvarVendedor() {
		controladorVendedor.salvarVendedor();
	}

	public List<Vendedor> retornarListaVendedores() {
		return controladorVendedor.getVendedores();
	}

	public Vendedor exibirInfoVendedor(String cpf) {
		return controladorVendedor.exibirInfoVendedor(cpf);
	}

	public Vendedor verificarLogin(String nomeUsuario, String senha) 
			throws NaoEncontradoVendedorException, SenhaIncorretaException {
		return controladorVendedor.verificarLogin(nomeUsuario, senha);
	}

}
