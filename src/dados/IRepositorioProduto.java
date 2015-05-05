package dados;

import java.util.ArrayList;

import classes_basicas.Produto;
import exceptions.NaoEncontradoProdutoException;
import exceptions.ProdutoJaCadastradoException;

public interface IRepositorioProduto {
	public abstract void criarListaProdutos();

	public abstract ArrayList<Produto> getProdutos();

	public abstract void setProdutos(ArrayList<Produto> produtos);

	public abstract int procurarPorProduto(String nomeProduto);

	public abstract void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException;
	
	public abstract void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException;
	
	public abstract Produto mostrarProduto(String nomeProduto);	
}
