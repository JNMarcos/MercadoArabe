package br.ufrpe.negocio.classes_basicas;

import java.util.List;

public class Comprador extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Produto> favoritos;

	public List<Produto> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Produto> favoritos) {
		this.favoritos = favoritos;
	}
}
