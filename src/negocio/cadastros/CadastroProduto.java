package negocio.cadastros;

import java.util.ArrayList;

import dados.IRepositorioProduto;
import dados.RepositorioProduto;
import negocio.classes_basicas.Produto;
import negocio.classes_basicas.Vendedor;
import negocio.exceptions.NaoEncontradoProdutoException;
import negocio.exceptions.ProdutoJaCadastradoException;

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
