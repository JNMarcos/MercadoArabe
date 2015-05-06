package negocio.exceptions;

public class ProdutoJaCadastradoException extends Exception{
	public String toString(){
		return "Esse produto já foi cadastrado! É melhor patentear outra marca. :) \n#FikaDica";
	}
}
