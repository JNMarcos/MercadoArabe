package br.ufrpe.negocio.exceptions_negocio;

public class SenhaIncorretaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SenhaIncorretaException(){
		super("A senha digitada est� incorreta, assim como aquela quest�o da prova que voc� fez!");
	}
}
