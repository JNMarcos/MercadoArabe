package negocio.exceptions;

public class ProdutoJaCadastradoException extends Exception{
	public String toString(){
		return "Esse produto j� foi cadastrado! � melhor registrar outra marca! :) \n#FikaDica";
	}
}
