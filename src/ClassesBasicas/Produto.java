package ClassesBasicas;

import java.sql.Time;

public class Produto {
	private String nome;
	private String descricao;
	private String categoria;
	private int quantidade;
	private double preco;
	private boolean estado;
	private Time tempoVenda;

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
		this.quantidade = quantidade;
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

}
