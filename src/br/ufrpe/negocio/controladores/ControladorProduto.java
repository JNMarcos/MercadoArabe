package br.ufrpe.negocio.controladores;

import java.util.List;

import br.ufrpe.dados.IRepositorioComprador;
import br.ufrpe.dados.IRepositorioProduto;
import br.ufrpe.dados.RepositorioComprador;
import br.ufrpe.dados.RepositorioProduto;
import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.filtro.Filtro;

public class ControladorProduto {
	private IRepositorioProduto repositorio;
	private IRepositorioComprador repositorioComprador;

	public ControladorProduto(){
		this.repositorio = RepositorioProduto.getInstancia();	
		this.repositorioComprador = RepositorioComprador.getInstancia();
	}

	public void cadastrarProduto(Produto produto, Vendedor vendedor) throws ProdutoJaCadastradoException, IllegalArgumentException {
		boolean produtoJaExiste;
		if (produto == null){
			throw new IllegalArgumentException();
		} else{
			produtoJaExiste = repositorio.verificarNomeProdutoJaExiste(produto.getNome(), vendedor);
			if (produtoJaExiste == false){
				repositorio.cadastrarProduto(produto);
				vendedor.getXp().adicionarPontosPorCadastrarProduto();
			} else{
				throw new ProdutoJaCadastradoException();
			}
		}
	}

	public void removerProduto(Produto produto) throws NaoEncontradoProdutoException, IllegalArgumentException {
		if (produto != null){
			int index = repositorio.procurarIndice(produto);
			if (index != -1){
				produto.getVendedor().getXp().removerPontosPelaRetiradaProduto(produto);
				repositorio.removerProduto(produto);
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void atualizarProduto(Produto produto, Vendedor vendedor) throws NaoEncontradoProdutoException, IllegalArgumentException {
		Produto p;
		int index;
		if (produto != null && vendedor != null){
			p  = repositorio.retornarProduto(produto.getNome(), vendedor, null);
			index = repositorio.procurarIndice(produto);
		} else {
			throw new IllegalArgumentException();
		}

		if (index != -1 && p != null){
			repositorio.atualizarProduto(p, index);
		} else {
			throw new NaoEncontradoProdutoException();
		}
	}

	public void salvarProduto() {
		RepositorioProduto.salvarArquivo();
	}

	public List<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return repositorio.getProdutos();
	}

	public Produto retornarProduto(String nomeProduto, Vendedor vendedor, List<Produto> produtos) throws NaoEncontradoProdutoException {
		return repositorio.retornarProduto(nomeProduto, vendedor, produtos);
	}

	public List<Produto> buscarProdutos(Filtro filtro) throws NaoEncontradoProdutoException{
		List<Produto> produtosParcialmenteRefinados = null; 
		if (!filtro.getNomeProduto().equals("")){
			produtosParcialmenteRefinados = repositorio.procurarProdutoPorNome(filtro.getNomeProduto(), produtosParcialmenteRefinados);
		}

		if (!filtro.getCategoria().equals("")){
			produtosParcialmenteRefinados = repositorio.procurarProdutoPorCategoria(filtro.getCategoria(), produtosParcialmenteRefinados);
		}

		if(filtro.getFaixaPrecoDe() != 0.0 || filtro.getFaixaPrecoAte() != 0.0){
			if (filtro.getFaixaPrecoDe() > filtro.getFaixaPrecoAte()){// se de for maior que ate, inverta os valores
				double momentaneo = filtro.getFaixaPrecoDe();
				filtro.setFaixaPrecoDe(filtro.getFaixaPrecoAte());
				filtro.setFaixaPrecoAte(momentaneo);
			}
			produtosParcialmenteRefinados = repositorio.procurarProdutoPorFaixaPreco(filtro.getFaixaPrecoDe(), filtro.getFaixaPrecoAte(), produtosParcialmenteRefinados);
		}

		if (!filtro.getLocalVendedor().equals("")){
			produtosParcialmenteRefinados = repositorio.procurarProdutoPorLocalVendedor(filtro.getLocalVendedor(), produtosParcialmenteRefinados);

		}

		if (produtosParcialmenteRefinados == null){
			throw new NaoEncontradoProdutoException();
		}

		return produtosParcialmenteRefinados;
	}

	public List<Produto> organizarProdutos (List<Produto> produtosASeremOrganizados) throws NaoEncontradoProdutoException, IllegalArgumentException{
		List<Produto> retAux = null;
		if (produtosASeremOrganizados != null){
			retAux = repositorio.organizarProduto(produtosASeremOrganizados);
		} else{
			throw new NaoEncontradoProdutoException();
		}
		return retAux;
	}

	public void venderProduto(Produto produto, Vendedor vendedor, Comprador comprador) throws NaoEncontradoProdutoException,
	NaoEncontradoVendedorException, NaoEncontradoCompradorException, IllegalArgumentException {
		if (produto != null && comprador != null && vendedor != null){// todos devem existir senão não há transação
			produto.decrementarItensNoEstoque();
			repositorioComprador.adicionarAosAdquiridos(comprador, produto);
			vendedor.getXp().adicionarPontosPorVender(produto); 
			if (produto.getItensNoEstoque() == 0){
				produto.setEstado(true);//é considerado vendido (não aparece nas buscas) e não pode mais ser alterado. veja método setEstado
			}
		} else {
			throw new IllegalArgumentException();
		}

		//decrementa o n° de itens, atualiza pts do vendedor e muda estado do produto p/ vendido(true) se todos os itens do produto for vendido


	}
}
