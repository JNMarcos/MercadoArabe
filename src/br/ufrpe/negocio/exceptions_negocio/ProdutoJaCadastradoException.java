package br.ufrpe.negocio.exceptions_negocio;

public class ProdutoJaCadastradoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoJaCadastradoException(){
		super("Esse produto já foi cadastrado! É melhor registrar outra marca! :) \n#FikaDica");
	}
}
