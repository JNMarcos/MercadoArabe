package br.ufrpe.negocio.exceptions_negocio;

public class QuantidadeMaximaItensUltrapassadaException extends Exception {
	public QuantidadeMaximaItensUltrapassadaException(){
		super("O n�mero que voc� digitou est� fora do limite ou n�o existe! Por favor, tente algo entre um e tr�s");
	}

}
