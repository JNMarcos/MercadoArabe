package br.ufrpe.negocio.exceptions_negocio;

public class ProdutoJaCadastradoException extends Exception{
	public ProdutoJaCadastradoException(){
		super("Esse produto já foi cadastrado! É melhor registrar outra marca! :) \n#FikaDica");
	}
}
