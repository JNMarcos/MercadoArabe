package br.ufrpe.negocio.exceptions_negocio;

public class NaoEncontradoCompradorException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoEncontradoCompradorException(){
		super("Ops, comprador não encontrado! :) \nNós não somos a NSA para conhecer sobre todo mundo. Mas bem queríamos! Hahaha!");
	}
}
