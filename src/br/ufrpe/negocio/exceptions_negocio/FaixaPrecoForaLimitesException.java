package br.ufrpe.negocio.exceptions_negocio;

public class FaixaPrecoForaLimitesException extends Exception {
	public FaixaPrecoForaLimitesException(){
		super("O limite da faixa de pre�o est� fora do padr�o! Ponha um valor maior que zero!");
	}
}
