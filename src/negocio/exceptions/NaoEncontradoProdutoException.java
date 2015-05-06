package negocio.exceptions;

public class NaoEncontradoProdutoException extends Exception{
	public String toString(){
		return "Ops, não conseguimos encontrar o produto pesquisado! ;)\nTente outra vez se for capaz!";
	}
}
