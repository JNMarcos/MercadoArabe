package br.ufrpe.negocio.filtros;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.negocio.classes_basicas.Produto;

public class Filtro {
	private String nomeProduto;
	private String categoria;
	private String faixaPrecoDe;
	private String faixaPrecoAte;
	private String localVendedor;
	private List<Produto> produtosEncontrados = new ArrayList<Produto>();
	
	public Filtro(String nomeProduto, String categoria, String faixaPrecoDe, String faixaPrecoAte, String localVendedor){
		setNomeProduto(nomeProduto);
		setCategoria(categoria);
		setFaixaPrecoDe(faixaPrecoDe);
		setFaixaPrecoAte(faixaPrecoAte);
		setLocalVendedor(localVendedor);
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
	public String getFaixaPrecoDe() {
		return faixaPrecoDe;
	}
	public void setFaixaPrecoDe(String faixaPrecoDe) {
		this.faixaPrecoDe = faixaPrecoDe;
	}
	public String getFaixaPrecoAte() {
		return faixaPrecoAte;
	}
	public void setFaixaPrecoAte(String faixaPrecoAte) {
		this.faixaPrecoAte = faixaPrecoAte;
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
		if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){
			procurarProdutoPorNome
		}
	}

}
