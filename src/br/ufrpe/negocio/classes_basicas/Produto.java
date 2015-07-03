package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
	private Vendedor vendedor;
	private List<Comprador> compradoresInteressados;
	
	public Produto(){
		setTempoCriacaoProduto();
	}

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
	public void decrementarItensNoEstoque(){
		if (this.itensNoEstoque > 0) this.itensNoEstoque--;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(String string) {
		this.preco = string;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		if (this.estado != true)
		this.estado = estado;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public LocalDate getTempoCriacaoProduto() {
		return tempoCriacaoProduto;
	}
	private void setTempoCriacaoProduto() {
		this.tempoCriacaoProduto = LocalDate.now();
	}
	public List<Comprador> getCompradoresInteressados() {
		return compradoresInteressados;
	}
	public void setCompradoresInteressados(List<Comprador> compradoresInteressados) {
		this.compradoresInteressados = compradoresInteressados;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + itensNoEstoque;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
		result = prime * result
				+ ((vendedor == null) ? 0 : vendedor.hashCode());
		return result;
	}
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
		if (estado != other.estado) {
			return false;
		}
		if (itensNoEstoque != other.itensNoEstoque) {
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
		if (vendedor == null) {
			if (other.vendedor != null) {
				return false;
			}
		} else if (!vendedor.equals(other.vendedor)) {
			return false;
		}
		return true;
	}
	
	public int compareTo(Produto produto) {
        return this.getNome().compareToIgnoreCase(produto.getNome());
        
    }
	
	

}
