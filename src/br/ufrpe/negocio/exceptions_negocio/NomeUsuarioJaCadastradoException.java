package br.ufrpe.negocio.exceptions_negocio;

public class NomeUsuarioJaCadastradoException extends Exception{
	
	public NomeUsuarioJaCadastradoException(){
		super("A criatividade passou longe, hein! :)\nO nome de usu�rio j� existe, tente outro!");
	}
}
