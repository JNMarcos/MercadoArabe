package br.ufrpe.negocio.exceptions_negocio;

public class CpfJaCadastradoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfJaCadastradoException(){
		super("CPF j� cadastrado! Verifique se voc� o digitou erradamente.");
	}
}
