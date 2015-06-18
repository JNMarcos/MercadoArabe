package br.ufrpe.negocio.exceptions_negocio;

public class SenhaForaPadroesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SenhaForaPadroesException(){
		super("Que tal seguir as regras apenas uma vez! \n\nA Gerência :)");
	}
}
