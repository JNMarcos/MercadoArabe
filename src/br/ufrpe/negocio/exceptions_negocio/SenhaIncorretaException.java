package br.ufrpe.negocio.exceptions_negocio;

public class SenhaIncorretaException extends Exception{
	public SenhaIncorretaException(){
		super("A senha digitada est� incorreta, assim como aquela quest�o da prova que voc� fez!");
	}
}
