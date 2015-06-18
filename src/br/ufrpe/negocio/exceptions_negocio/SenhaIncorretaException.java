package br.ufrpe.negocio.exceptions_negocio;

public class SenhaIncorretaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SenhaIncorretaException(){
		super("A senha digitada está incorreta, assim como aquela questão da prova que você fez!");
	}
}
