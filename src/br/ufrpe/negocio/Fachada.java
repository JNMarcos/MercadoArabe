package br.ufrpe.negocio;

import java.util.ArrayList;

import br.ufrpe.negocio.cadastros.CadastroProduto;
import br.ufrpe.negocio.cadastros.CadastroVendedor;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public class Fachada {
	private CadastroProduto cadastroProduto = new CadastroProduto();
	private CadastroVendedor cadastroVendedor = new CadastroVendedor();

	private Fachada() {
		// Construtor privado para evitar instanciação fora da classe
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException {
		cadastroProduto.cadastrarProduto(produto);
	}

	public void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException {
		cadastroProduto.removerProduto(nomeProduto);
	}

	public void salvarProduto() {
		cadastroProduto.salvarProduto();
	}

	public ArrayList<Produto> retornarListaProdutos() {
		return cadastroProduto.getProdutos();
	}

	public Produto exibirInfoProduto(String nomeProduto) {
		return cadastroProduto.exibirInfoProduto(nomeProduto);
	}
	
	//VENDEDOR
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
