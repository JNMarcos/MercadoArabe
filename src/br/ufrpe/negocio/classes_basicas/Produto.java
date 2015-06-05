package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.sql.Time;
import java.util.Iterator;

public class Produto implements Comparable<Produto>, Serializable, Iterator<Produto>{
	private String nome;
	private String descricao;
	private String categoria;
	//adicionar um atributo para imagem do produto, senão pôr uma imagem padrão
	private int quantidade;
	private double preco;
	private boolean estado;
	private Time tempoVenda;
	
	private final static int NUMERO_MAXIMO_ITENS_POR_PRODUTO = 3;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if (quantidade <= NUMERO_MAXIMO_ITENS_POR_PRODUTO){
		this.quantidade = quantidade;
		}
	}
	//indica quantos itens faltam a serem vendidos
	public void itensNoEstoque(){
		if(this.quantidade > 0)
		this.quantidade--;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Time getTempoVenda() {
		return tempoVenda;
	}
	public void setTempoVenda(Time tempoVenda) {
		this.tempoVenda = tempoVenda;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + quantidade;
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
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null) {
				return false;
			}
		} else if (!categoria.equals(other.categoria)) {
			return false;
		}
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (estado != other.estado) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco)) {
			return false;
		}
		if (quantidade != other.quantidade) {
			return false;
		}
		if (tempoVenda == null) {
			if (other.tempoVenda != null) {
				return false;
			}
		} else if (!tempoVenda.equals(other.tempoVenda)) {
			return false;
		}
		return true;
	}
	
	public int compareTo(Produto produto) {
        return this.getNome().compareToIgnoreCase(produto.getNome());
        
    }
	
	

}
