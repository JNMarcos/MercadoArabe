package exceptions;

public class CpfExistenteException extends Exception {
	public String toString(){
		return "CPF j� cadastrado! Verifique se voc� o digitou erradamente.";
	}
}
