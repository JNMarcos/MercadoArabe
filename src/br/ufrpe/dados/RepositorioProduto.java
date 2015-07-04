package br.ufrpe.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.controladores.ControladorProduto;

public class RepositorioProduto implements IRepositorioProduto, Serializable{

	private static final long serialVersionUID = 1L;
	List<Produto> produtos = new ArrayList<Produto>();
	public static ControladorProduto cadastroProduto = new ControladorProduto();
	private static RepositorioProduto instancia;

	public static RepositorioProduto getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioProduto();
		}
		return instancia;
	}

	private static RepositorioProduto lerDoArquivo() {
		RepositorioProduto instanciaLocal = null;

		File in = new File("repositorioProduto.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProduto) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProduto();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File("repositorioProduto.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent exception*/
				}
			}
		}
	}

	public List<Produto> getProdutos() {
		if(this.produtos!=null)
			Collections.sort(produtos);
		return produtos;
	}

	public boolean verificarNomeProdutoJaExiste(String nomeProduto, Vendedor vendedor){
		boolean nomeProdutoJaExiste = false;
		if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){
			for (int i = 0; i < produtos.size(); i++){
				if (produtos.get(i).getNome().equalsIgnoreCase(nomeProduto) && produtos.get(i).getVendedor().equals(vendedor)){
					nomeProdutoJaExiste = true;
					break;
				}
			} 
		}else nomeProdutoJaExiste = true;
		return nomeProdutoJaExiste;
	}

	public void cadastrarProduto(Produto produto){
		this.produtos.add(produto);
		produto.getVendedor().incrementarQtdProdutosAVenda();
		salvarArquivo();
	}

	public void atualizarProduto(Produto produto, int posicao){
		produtos.set(posicao, produto);
		salvarArquivo();
	}

	public void removerProduto(Produto produto){
		produtos.remove(produto);
		salvarArquivo();
	}

	public Produto retornarProduto(String nomeProduto, Vendedor vendedor, List<Produto> produtoASerEncontrado){
		Produto produto = null;
		List<Produto> iProduto = null;
		if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){
			if (produtoASerEncontrado.equals("")){
				if (!this.getProdutos().equals("")) iProduto = this.produtos;
			} else {
				iProduto = produtoASerEncontrado;
			} //iterator ou listIterato
			if (!iProduto.equals("")){
				for (int i = 0; i < iProduto.size(); i++){
					if (iProduto.get(i).getNome().equalsIgnoreCase(nomeProduto) && iProduto.get(i).getVendedor().equals(vendedor)){
						produto = iProduto.get(i);
						break;
					}
				}
			}
		}	
		return produto;//pode ser null
	}

	public List<Produto> procurarProdutoPorNome(String nomeProduto, List<Produto> produtosASeremRefinados){
		List<Produto> produtosEncontrados = null;
		List<Produto> iProduto = null;
		if (!nomeProduto.equals(null)){

			if (produtosASeremRefinados == null){// se a lista entregue como parâmetro for vazia, use a do repositório
				if (this.getProdutos() != null){
					iProduto = this.produtos;
				}
			} else {
				iProduto = produtosASeremRefinados;
			} 
			if (iProduto != null){
				produtosEncontrados = new ArrayList<Produto>();
				for (int i = 0; i < iProduto.size(); i++){
					if (iProduto.get(i).getNome().equalsIgnoreCase(nomeProduto)){
						produtosEncontrados.add(iProduto.get(i));
					}
				}
			}
		}
		return 	produtosEncontrados;//pode ser null
	}

	public List<Produto> procurarProdutoPorCategoria(String categoriaProduto, List<Produto> produtosASeremRefinados){
		List<Produto> produtosEncontrados = null;
		List<Produto> iProduto = null;
		if (!categoriaProduto.equals("")){

			if (produtosASeremRefinados == null){
				if (this.getProdutos() != null){
					iProduto = this.produtos;
				}
			} else {
				iProduto = produtosASeremRefinados;
			}
			if (iProduto != null){
				produtosEncontrados = new ArrayList<Produto>();
				for (int i = 0; i < iProduto.size(); i++){
					if (iProduto.get(i).getCategoria().equalsIgnoreCase(categoriaProduto)){
						produtosEncontrados.add(iProduto.get(i));
					}
				}
			}
		}
		return 	produtosEncontrados;//pode ser null
	}


	public List<Produto> procurarProdutoPorFaixaPreco (double de, double ate, List<Produto> produtosASeremRefinados){
		List<Produto> produtosEncontrados = null;
		List<Produto> iProduto = null;
		if ((de > 0.0 || ate > 0.0) && de != ate && (de < ate || ate == 0.0)){//ou de ou ate tem de ser maior que zero
			if (produtosASeremRefinados == null){
				if (this.getProdutos() != null){ 
					iProduto = this.produtos;
				}
			} else {
				iProduto = produtosASeremRefinados;
			} 
			if (iProduto != null){
				produtosEncontrados = new ArrayList<Produto>();
				for (int i = 0; i < iProduto.size(); i++){
					if (ate != 0.0){
						if (iProduto.get(i).getPreco() >= de && iProduto.get(i).getPreco() <= ate){
							produtosEncontrados.add(iProduto.get(i));
						}
					} else {
						if (iProduto.get(i).getPreco() >= de){
							produtosEncontrados.add(iProduto.get(i));
						}
					}
				}
			}
		}
		return 	produtosEncontrados;//pode ser null
	} 

	public List<Produto> procurarProdutoPorLocalVendedor(String localVendedor, List<Produto> produtosASeremRefinados){
		List<Produto> produtosEncontrados = null;
		List<Produto> iProduto = null;
		if (!localVendedor.equals("")){

			if (produtosASeremRefinados == null){
				if (this.getProdutos() != null){
					iProduto = this.produtos;
				}
			} else {
				iProduto = produtosASeremRefinados;
			} 
			if (iProduto != null){
				produtosEncontrados = new ArrayList<Produto>();
				for (int i = 0; i < iProduto.size(); i++){
					if (iProduto.get(i).getVendedor().getContato().getCidade().equalsIgnoreCase(localVendedor)){
						produtosEncontrados.add(iProduto.get(i));
					}
				}
			}
		}
		return 	produtosEncontrados;//pode ser null
	}

	public List<Produto> retornarProdutosDoVendedor(Vendedor vendedor){
		List <Produto> produtosVendedor = null;
		if (!vendedor.equals("") && !this.getProdutos().equals("")){
			produtosVendedor = new ArrayList<Produto>();
			for (int i = 0; i < produtos.size(); i++){
				if (produtos.get(i).getVendedor().equals(vendedor)){
					produtosVendedor.add(produtos.get(i));
				}
			}
		}
		return produtosVendedor;
	}

	public int procurarIndice(Produto produto) {
		int retAux = -1;//índice que indica que não existe tal Vendedor
		if (produto != null && this.getProdutos() != null){
			for (int i = 0; i < produtos.size(); i++){
				if (produtos.get(i).equals(produto)){
					retAux = i;
					break;
				}
			}
		}
		return retAux;
	}

	public List<Produto> organizarProduto(List<Produto> produtosASeremOrganizados){
		List<Produto> produtosOrganizados = null;
		boolean troca = true;
		Produto maiorRodada;
		int j;
		if (produtosASeremOrganizados != null){
			for (int k = 0; k < produtosASeremOrganizados.size(); k++){
				if (produtosASeremOrganizados.get(k).isEstado())//retorna true se já foi vendido o produto
				{
					produtosASeremOrganizados.remove(k);//remove todos os produtos já vendidos do resultado
				}	
			}

			if (produtosASeremOrganizados.size() >= 2){
				while (troca) {
					troca = false;
					for (int i = 0; i < produtosASeremOrganizados.size() - 1; i++) {
						j = i + 1;
						//organiza pondo os vendedores que possuem maior número de xp
						if (produtosASeremOrganizados.get(i).getVendedor().getXp().getPontos() < produtosASeremOrganizados.get(j).getVendedor().getXp().getPontos()) {
							maiorRodada = produtosASeremOrganizados.get(j);
							produtosASeremOrganizados.set(j, produtosASeremOrganizados.get(i));
							produtosASeremOrganizados.set(i,maiorRodada);
							troca = true;
						}
						//organiza pondos os mais baratos afrente
						if (produtosASeremOrganizados.get(i).getVendedor().getXp().getPontos() == produtosASeremOrganizados.get(j).getVendedor().getXp().getPontos() && 
								produtosASeremOrganizados.get(i).getPreco() > produtosASeremOrganizados.get(j).getPreco()){
							maiorRodada = produtosASeremOrganizados.get(j);
							produtosASeremOrganizados.set(j,produtosASeremOrganizados.get(i));
							produtosASeremOrganizados.set(i, maiorRodada);
							troca = true;
						}
					}
				}
			}

			produtosOrganizados = produtosASeremOrganizados;
		}
		return produtosOrganizados; 

	}
}
