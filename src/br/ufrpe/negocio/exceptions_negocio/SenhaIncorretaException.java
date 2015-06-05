package br.ufrpe.negocio.exceptions_negocio;

public class SenhaIncorretaException extends Exception{
	public SenhaIncorretaException(){
		super("A senha digitada está incorreta, assim como aquela questão da prova que você fez!");
	}
}
