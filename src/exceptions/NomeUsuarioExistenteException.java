package exceptions;

public class NomeUsuarioExistenteException extends Exception{
	
	public String toString(){
		return "A criatividade passou longe, hein! :)\nO nome de usu�rio j� existe, tente outro!";
	}
}