package negocio.fachada;

import java.util.ArrayList;

import negocio.cadastros.CadastroProduto;
import negocio.cadastros.CadastroVendedor;
import negocio.classes_basicas.Produto;
import negocio.classes_basicas.Vendedor;
import negocio.exceptions.CpfJaCadastradoException;
import negocio.exceptions.NaoEncontradoProdutoException;
import negocio.exceptions.NaoEncontradoVendedorException;
import negocio.exceptions.NomeUsuarioJaCadastradoException;
import negocio.exceptions.ProdutoJaCadastradoException;

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
