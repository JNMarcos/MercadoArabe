package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.time.LocalDate;
import br.ufrpe.negocio.exceptions_negocio.QuantidadeMaximaItensUltrapassadaException;

public class Produto implements Comparable<Produto>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private String categoria;
	//adicionar um atributo para imagem do produto, senão pôr uma imagem padrão
	private int quantidade;
	private int itensNoEstoque;
	private double preco;
	private boolean estado;
	private LocalDate tempoCriacaoProduto;
	private int pontos;//qtd de pontos que esse produto gerou ao Vendedor, facilita na hora de remoção
	
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
	public void setQuantidade(int quantidade) throws QuantidadeMaximaItensUltrapassadaException {
		if (quantidade > 0 && quantidade <= NUMERO_MAXIMO_ITENS_POR_PRODUTO){
		this.quantidade = quantidade;
		} else throw new QuantidadeMaximaItensUltrapassadaException();
	}

	public int getItensNoEstoque() {
		return itensNoEstoque;
	}
	public void setItensNoEstoque(int itensNoEstoque) {
		this.itensNoEstoque = itensNoEstoque;
	}
	//indica quantos itens faltam a serem vendidos. O chama toda vez que vender um produto
	public void itensNoEstoque(){
		if (this.itensNoEstoque > 0) this.itensNoEstoque--;
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
		if (this.estado != true)
		this.estado = estado;
	}
	public LocalDate getTempoVenda() {
		return tempoCriacaoProduto;
	}
	public void setTempoVenda(LocalDate tempoVenda) {
		this.tempoCriacaoProduto = LocalDate.now();
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
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
		if (tempoCriacaoProduto == null) {
			if (other.tempoCriacaoProduto != null) {
				return false;
			}
		} else if (!tempoCriacaoProduto.equals(other.tempoCriacaoProduto)) {
			return false;
		}
		return true;
	}
	
	public int compareTo(Produto produto) {
        return this.getNome().compareToIgnoreCase(produto.getNome());
        
    }
	
	

}
