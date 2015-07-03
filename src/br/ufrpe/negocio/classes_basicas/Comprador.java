package br.ufrpe.negocio.classes_basicas;

import java.util.List;

public class Comprador extends Pessoa implements Comparable<Comprador>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Produto> produtosInteressantes;
	List<Produto> produtosAdquiridos;
	List<Produto> favoritos;
	
	int quantProdInteresses = 0;
	int quantProdAdquiridos = 0;
	int quantProdFavoritos = 0;
	
	public void incrementarProdInteresses (){
		quantProdInteresses++;
	}
	
	public void incrementarProdAdquiridos (){
		quantProdAdquiridos++;
	}
	
	public void incrementarProdFavoritos(){
		quantProdFavoritos++;
	}
	
	public void decrementarProdInteresses (){
		quantProdInteresses--;
	}
	
	public void decrementarProdFavoritos(){
		quantProdFavoritos--;
	}

	public List<Produto> getProdutosInteressantes() {
		return produtosInteressantes;
	}

	public List<Produto> getProdutosAdquiridos() {
		return produtosAdquiridos;
	}


	public List<Produto> getFavoritos() {
		return favoritos;
	}
	
	public int getQuantProdInteresses() {
		return quantProdInteresses;
	}

	public int getQuantProdAdquiridos() {
		return quantProdAdquiridos;
	}

	public int getQuantProdFavoritos() {
		return quantProdFavoritos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((favoritos == null) ? 0 : favoritos.hashCode());
		result = prime
				* result
				+ ((produtosAdquiridos == null) ? 0 : produtosAdquiridos
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Comprador)) {
			return false;
		}
		Comprador other = (Comprador) obj;
		if (favoritos == null) {
			if (other.favoritos != null) {
				return false;
			}
		} else if (!favoritos.equals(other.favoritos)) {
			return false;
		}
		if (produtosAdquiridos == null) {
			if (other.produtosAdquiridos != null) {
				return false;
			}
		} else if (!produtosAdquiridos.equals(other.produtosAdquiridos)) {
			return false;
		}
		return true;
	}

	public int compareTo(Comprador comprador) {
		// TODO Auto-generated method stub
		return this.getNomeUsuario().compareToIgnoreCase(comprador.getNomeUsuario());
	}
}
