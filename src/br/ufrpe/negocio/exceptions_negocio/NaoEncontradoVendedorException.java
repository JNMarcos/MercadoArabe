package br.ufrpe.negocio.exceptions_negocio;

public class NaoEncontradoVendedorException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoEncontradoVendedorException(){
		super("Ops, vendedor não encontrado! :) \nNós não somos a NSA para conhecer sobre todo mundo. Mas bem queríamos! Hahaha!");
	}
	
}
