package br.ufrpe.negocio.exceptions_negocio;

public class NomeVazioException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NomeVazioException() {
		super("Campo nome vazio! Digite seu nome para prosseguir.");
	}
}
