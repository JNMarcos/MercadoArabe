package negocio.exceptions;

public class NomeUsuarioJaCadastradoException extends Exception{
	
	public String toString(){
		return "A criatividade passou longe, hein! :)\nO nome de usuário já existe, tente outro!";
	}
}
