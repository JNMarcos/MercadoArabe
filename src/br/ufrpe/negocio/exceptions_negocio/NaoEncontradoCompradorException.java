package br.ufrpe.negocio.exceptions_negocio;

public class NaoEncontradoCompradorException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoEncontradoCompradorException(){
		super("Ops, comprador n�o encontrado! :) \nN�s n�o somos a NSA para conhecer sobre todo mundo. Mas bem quer�amos! Hahaha!");
	}
}
