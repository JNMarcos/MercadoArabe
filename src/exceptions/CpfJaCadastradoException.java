package exceptions;

public class CpfJaCadastradoException extends Exception {
	public String toString(){
		return "CPF já cadastrado! Verifique se você o digitou erradamente.";
	}
}
