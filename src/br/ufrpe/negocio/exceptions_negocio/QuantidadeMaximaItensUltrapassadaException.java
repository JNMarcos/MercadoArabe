package br.ufrpe.negocio.exceptions_negocio;

public class QuantidadeMaximaItensUltrapassadaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuantidadeMaximaItensUltrapassadaException(){
		super("O n�mero que voc� digitou est� fora do limite ou n�o existe! Por favor, tente algo entre um e tr�s");
	}

}
