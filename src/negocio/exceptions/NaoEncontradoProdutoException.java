package negocio.exceptions;

public class NaoEncontradoProdutoException extends Exception{
	public String toString(){
		return "Ops, n�o conseguimos encontrar o produto pesquisado! ;)\nTente outra vez se for capaz!";
	}
}
