package negocio.exceptions;

public class ProdutoJaCadastradoException extends Exception{
	public String toString(){
		return "Esse produto j� foi cadastrado! � melhor patentear outra marca. :) \n#FikaDica";
	}
}
