package br.ufrpe.negocio.exceptions_negocio;

public class ProdutoJaCadastradoException extends Exception{
	public ProdutoJaCadastradoException(){
		super("Esse produto j� foi cadastrado! � melhor registrar outra marca! :) \n#FikaDica");
	}
}
