package br.ufrpe.dados;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;

public interface IRepositorioProduto {

	public abstract List<Produto> getProdutos();

	public abstract void cadastrarProduto(Produto produto);
	
	public abstract void removerProduto(Produto produto);
	
	public abstract void atualizarProduto(Produto produto, int index);
	
	public abstract int procurarIndice(Produto produto);
	
	public abstract Produto retornarProduto(String nomeProduto, Vendedor vendedor, List<Produto> produtoASerEncontrado);
	
	public List<Produto> retornarProdutosDoVendedor(Vendedor vendedor);
	
	public abstract List<Produto> procurarProdutoPorNome(String nomeProduto, List<Produto> produtosASeremRefinados);
	
	public abstract List<Produto> procurarProdutoPorCategoria(String categoriaProduto, List<Produto> produtosASeremRefinados);
	
	public abstract List<Produto> procurarProdutoPorFaixaPreco (double de, double ate, List<Produto> produtosASeremRefinados);

	public abstract List<Produto> procurarProdutoPorLocalVendedor(String localVendedor, List<Produto> produtosParcialmenteRefinados);
	
	public abstract List<Produto> organizarProduto(List<Produto> produtosASeremOrganizados);

	public abstract boolean verificarNomeProdutoJaExiste(String nomeProduto, Vendedor vendedor);
}
