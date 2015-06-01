package br.ufrpe.negocio.cadastros;

import java.util.ArrayList;

import br.ufrpe.dados.IRepositorioProduto;
import br.ufrpe.dados.RepositorioProduto;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public class CadastroProduto {
	private IRepositorioProduto repositorio;

	public CadastroProduto(){
		this.repositorio = RepositorioProduto.getInstancia();	
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException {
		repositorio.cadastrarProduto(produto);
	}

	public void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException {
		repositorio.removerProduto(nomeProduto);
	}

	public void salvarProduto() {
		RepositorioProduto.salvarArquivo();
	}

	public ArrayList<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return repositorio.getProdutos();
	}

	public Produto exibirInfoProduto(String nomeProduto) {
		return repositorio.exibirInfoProduto(nomeProduto);
	}

}
