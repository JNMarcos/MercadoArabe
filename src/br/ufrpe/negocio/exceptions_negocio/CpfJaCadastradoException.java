package br.ufrpe.negocio.exceptions_negocio;

public class CpfJaCadastradoException extends Exception {
	
	public CpfJaCadastradoException(){
		super("CPF j� cadastrado! Verifique se voc� o digitou erradamente.");
	}
}
