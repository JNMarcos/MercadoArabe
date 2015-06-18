package br.ufrpe.negocio.filtro;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.exceptions_negocio.FaixaPrecoForaLimitesException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.dados.IRepositorioProduto;
import br.ufrpe.dados.RepositorioProduto;

public class Filtro {
	private String nomeProduto;
	private String categoria;
	private double faixaPrecoDe;
	private double faixaPrecoAte;
	private String localVendedor;
	private List<Produto> produtosEncontrados;
	private IRepositorioProduto repositorio = new RepositorioProduto();
	
	public Filtro(String nomeProduto, String categoria, String faixaPrecoDe, String faixaPrecoAte, String localVendedor){
		setNomeProduto(nomeProduto);
		setCategoria(categoria);
		setFaixaPrecoDe(faixaPrecoDe);
		setFaixaPrecoAte(faixaPrecoAte);
		setLocalVendedor(localVendedor);
		produtosEncontrados = new ArrayList<Produto>();
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getFaixaPrecoDe() {
		return faixaPrecoDe;
	}
	public void setFaixaPrecoDe(String faixaPrecoDe) {
		if (!faixaPrecoDe.equals("") && !faixaPrecoDe.equals("")){
		double faixaPrecoDeDouble = Double.parseDouble(faixaPrecoDe);
		this.faixaPrecoDe = faixaPrecoDeDouble;
		} else {
			this.faixaPrecoDe = 0.0;
		}
	}
	public double getFaixaPrecoAte() {
		return faixaPrecoAte;
	}
	public void setFaixaPrecoAte(String faixaPrecoAte) {
		if (!faixaPrecoAte.equals("") && !faixaPrecoAte.equals("")){
		double faixaPrecoAteDouble = Double.parseDouble(faixaPrecoAte);
		this.faixaPrecoAte = faixaPrecoAteDouble;
		} else {
			this.faixaPrecoAte = 0.0;
		}
	}
	public String getLocalVendedor() {
		return localVendedor;
	}
	public void setLocalVendedor(String localVendedor) {
		this.localVendedor = localVendedor;
	}
	public List<Produto> getProdutosEncontrados() {
		return produtosEncontrados;
	}
	public void setProdutosEncontrados(List<Produto> produtosEncontrados) {
		this.produtosEncontrados = produtosEncontrados;
	}
	
	public List<Produto> buscarProdutos(){
		//if (nomeProduto.equals("") && categoria.equals("") && (faixaPrecoDe.equals("") || faixaPrecoAte.equals("")) && localVendedor)
		List<Produto> produtosParcialmenteRefinados = null; 
		if (!getNomeProduto().equals("") && !getNomeProduto().equals(" ")){
			try {
				produtosParcialmenteRefinados = repositorio.procurarProdutoPorNome(this.getNomeProduto(), produtosParcialmenteRefinados);
			} catch (NaoEncontradoProdutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//pegar um objeto do tipo repositório
			this.setProdutosEncontrados(produtosParcialmenteRefinados);
		}
		
		if (!getCategoria().equals("") && !getCategoria().equals(" ")){
			try {
				produtosParcialmenteRefinados = repositorio.procurarProdutoPorCategoria(this.getCategoria(), produtosParcialmenteRefinados);
			} catch (NaoEncontradoProdutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(getFaixaPrecoDe() != 0.0 || getFaixaPrecoAte() != 0.0){
			try {
				produtosParcialmenteRefinados = repositorio.procurarProdutoPorFaixaPreco(this.getFaixaPrecoDe(), this.getFaixaPrecoAte(), produtosParcialmenteRefinados);
			} catch (NaoEncontradoProdutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FaixaPrecoForaLimitesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (!getLocalVendedor().equals("") && !getLocalVendedor().equals(" ")){
			
			try {
				produtosParcialmenteRefinados = repositorio.procurarProdutoPorLocalVendedor(this.getLocalVendedor(), produtosParcialmenteRefinados);
			} catch (NaoEncontradoProdutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtosParcialmenteRefinados;
	}


}
