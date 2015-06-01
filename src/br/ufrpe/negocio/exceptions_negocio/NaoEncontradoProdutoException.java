package br.ufrpe.negocio.exceptions_negocio;

public class NaoEncontradoProdutoException extends Exception{
	public NaoEncontradoProdutoException(){
		super("Ops, não conseguimos encontrar o produto pesquisado! ;)\nTente outra vez se for capaz!");
	}
}
