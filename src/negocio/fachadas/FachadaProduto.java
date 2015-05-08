package negocio.fachadas;

import java.util.ArrayList;

import negocio.cadastros.CadastroProduto;
import negocio.classes_basicas.Produto;
import negocio.classes_basicas.Vendedor;
import negocio.exceptions.NaoEncontradoProdutoException;
import negocio.exceptions.ProdutoJaCadastradoException;

public class FachadaProduto {
	private CadastroProduto cadastroProduto = new CadastroProduto();

	private FachadaProduto() {
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
}
