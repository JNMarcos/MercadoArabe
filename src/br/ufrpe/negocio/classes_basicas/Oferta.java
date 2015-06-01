package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.sql.Time;

public class Oferta implements Comparable<Oferta>, Serializable{
	private Produto produto;
	private int porcentagem;
	private Time tempo;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + porcentagem;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Oferta)) {
			return false;
		}
		Oferta other = (Oferta) obj;
		if (porcentagem != other.porcentagem) {
			return false;
		}
		if (produto == null) {
			if (other.produto != null) {
				return false;
			}
		} else if (!produto.equals(other.produto)) {
			return false;
		}
		if (tempo == null) {
			if (other.tempo != null) {
				return false;
			}
		} else if (!tempo.equals(other.tempo)) {
			return false;
		}
		return true;
	}

	public int compareTo(Oferta oferta) {
		return this.getProduto().compareTo(oferta.getProduto());

	}

}
