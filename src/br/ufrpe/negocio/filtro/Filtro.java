package br.ufrpe.negocio.filtro;


public class Filtro {
	private String nomeProduto;
	private String categoria;
	private double faixaPrecoDe;
	private double faixaPrecoAte;
	private String localVendedor;

	public Filtro(String nomeProduto, String categoria, double faixaPrecoDe, double faixaPrecoAte, String localVendedor){
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
	public double getFaixaPrecoDe() {
		return faixaPrecoDe;
	}
	public void setFaixaPrecoDe(double faixaPrecoDe) {
			if (faixaPrecoDe <= 0.0) this.faixaPrecoDe = 0.0;
			else this.faixaPrecoDe = faixaPrecoDe;

	}
	public double getFaixaPrecoAte() {
		return faixaPrecoAte;
	}
	public void setFaixaPrecoAte(double faixaPrecoAte) {
			if (faixaPrecoAte <= 0.0) this.faixaPrecoAte = 0.0;
			else this.faixaPrecoAte = faixaPrecoAte;
	}
	public String getLocalVendedor() {
		return localVendedor;
	}
	public void setLocalVendedor(String localVendedor) {
		this.localVendedor = localVendedor;
	}
}
