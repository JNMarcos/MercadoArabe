package br.ufrpe.negocio.exceptions_negocio;

public class QuantidadeMaximaItensUltrapassadaException extends Exception {
	public QuantidadeMaximaItensUltrapassadaException(){
		super("O número que você digitou está fora do limite ou não existe! Por favor, tente algo entre um e três");
	}

}
