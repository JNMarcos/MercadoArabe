package br.ufrpe.dados;

import java.util.ArrayList;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public interface IRepositorioProduto {
	public abstract void criarListaProdutos();

	public abstract ArrayList<Produto> getProdutos();

	public abstract void setProdutos(ArrayList<Produto> produtos);

	public abstract int procurarPorProduto(String nomeProduto);

	public abstract void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException;
	
	public abstract void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException;
	
	public abstract Produto exibirInfoProduto(String nomeProduto);	
}
