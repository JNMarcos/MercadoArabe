package negocio.classes_basicas;

import java.sql.Time;

public class Oferta extends Produto{
	private int porcentagem;
	private Time tempo;
	
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
