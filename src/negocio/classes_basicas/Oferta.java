package negocio.classes_basicas;

import java.sql.Time;

public class Oferta{
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

}
