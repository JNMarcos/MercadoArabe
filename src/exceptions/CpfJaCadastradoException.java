package exceptions;

public class CpfJaCadastradoException extends Exception {
	public String toString(){
		return "CPF j� cadastrado! Verifique se voc� o digitou erradamente.";
	}
}
