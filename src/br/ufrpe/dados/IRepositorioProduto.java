package br.ufrpe.dados;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.exceptions_negocio.FaixaPrecoForaLimitesException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public interface IRepositorioProduto {
	public abstract void criarListaProdutos();

	public abstract List<Produto> getProdutos();

	public abstract void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException;
	
	public abstract void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException;
	
	public abstract Produto exibirInfoProduto(String nomeProduto);
	
	public abstract List<Produto> procurarProdutoPorNome(String nomeProduto) throws NaoEncontradoProdutoException;
	
	public abstract List<Produto> procurarProdutoPorCategoria(String categoriaProduto) throws NaoEncontradoProdutoException;
	
	public List<Produto> procurarProdutoPorFaixaPreco (double de, double ate) throws NaoEncontradoProdutoException, FaixaPrecoForaLimitesException;
}
