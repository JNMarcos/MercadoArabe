package br.ufrpe.dados;

import java.util.ArrayList;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public interface IRepositorioProduto {
	public abstract void criarListaProdutos();

	public abstract ArrayList<Produto> getProdutos();

	public abstract int retornarIndiceProduto(String nomeProduto);

	public abstract void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException;
	
	public abstract void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException;
	
	public abstract Produto exibirInfoProduto(String nomeProduto);
	
	public abstract ArrayList<Produto> procurarProdutoPorNome(String nomeProduto) throws NaoEncontradoProdutoException;
	
	public abstract ArrayList<Produto> procurarProdutoPorCategoria(String categoriaProduto) throws NaoEncontradoProdutoException;
}
