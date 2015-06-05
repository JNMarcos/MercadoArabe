package br.ufrpe.negocio.classes_basicas;

public class Xp {
	private int pontos;
	
	private final static int PONTOS_GANHOS_PELO_CADASTRO_VENDEDOR = 30;
	
	public Xp(){
		this.pontos = PONTOS_GANHOS_PELO_CADASTRO_VENDEDOR;
	}

	public int getPontos() {
		return pontos;
	}

	private void adicionarPontosPorVender() {
		this.pontos = pontos;
	}
	private void adicionarPontosPorCadastrarProduto(){
		
	}
	private void removerPontos(int pontos){
				
	}
}
