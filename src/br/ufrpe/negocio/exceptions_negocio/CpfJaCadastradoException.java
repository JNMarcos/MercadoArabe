package br.ufrpe.negocio.exceptions_negocio;

public class CpfJaCadastradoException extends Exception {
	
	public CpfJaCadastradoException(){
		super("CPF já cadastrado! Verifique se você o digitou erradamente.");
	}
}
