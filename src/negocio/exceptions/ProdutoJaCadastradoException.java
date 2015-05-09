package negocio.exceptions;

public class ProdutoJaCadastradoException extends Exception{
	public String toString(){
		return "Esse produto já foi cadastrado! É melhor registrar outra marca! :) \n#FikaDica";
	}
}
