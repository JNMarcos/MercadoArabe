package br.ufrpe.negocio.controladores;

import java.util.List;

import br.ufrpe.dados.IRepositorioProduto;
import br.ufrpe.dados.RepositorioProduto;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.classes_basicas.Xp;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public class ControladorProduto {
	private IRepositorioProduto repositorio;

	public ControladorProduto(){
		this.repositorio = RepositorioProduto.getInstancia();	
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException {
		boolean produtoJaExiste;
		if (produto == null){
			throw new NullPointerException();
		} else{
			produtoJaExiste = repositorio.verificarNomeProdutoJaExiste(produto.getNome());
			if (produtoJaExiste == false){
			repositorio.cadastrarProduto(produto);
			} else{
				throw new ProdutoJaCadastradoException();
			}
	}

	public void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException {
		repositorio.removerProduto(nomeProduto);
	}

	public void salvarProduto() {
		RepositorioProduto.salvarArquivo();
	}

	public List<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return repositorio.getProdutos();
	}

	public Produto exibirInfoProduto(String nomeProduto, List<Produto> produto) {
		return repositorio.exibirInfoProduto(nomeProduto, produto);
	}

	/*
	public void vendeuProduto(Produto produto, Vendedor vendedor) throws NaoEncontradoProdutoException {

		repositorio.procurarProdutoPorNome(produto.getNome(), null);

		Xp xp = vendedor.getXp();
		xp.adicionarPontosPorVender(produto); //atualiza pts e muda estado do produto p/ vendido(true)
		vendedor.setXp(xp); 				  //atualizando o xp do vendedor

		repositorio.removerProduto(produto.getNome()); //remove
	}*/
}
