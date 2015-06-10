package br.ufrpe.negocio.exceptions_negocio;

public class FaixaPrecoForaLimitesException extends Exception {
	public FaixaPrecoForaLimitesException(){
		super("O limite da faixa de preço está fora do padrão! Ponha um valor maior que zero!");
	}
}
