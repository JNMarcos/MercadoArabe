package br.ufrpe.negocio.exceptions_negocio;

public class NomeUsuarioJaCadastradoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeUsuarioJaCadastradoException(){
		super("A criatividade passou longe, hein! :)\nO nome de usuário já existe, tente outro!");
	}
}
