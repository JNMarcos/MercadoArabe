package br.ufrpe.negocio.classes_basicas;

import java.time.LocalDate;
import java.time.Period;

public class Xp {
	private int pontos;
	private int pontosAAdicionar;

	//GANHOS DE PONTOS
	private static final int PONTOS_GANHOS_PELO_CADASTRO_VENDEDOR = 30;
	private static final int PONTOS_GANHOS_PELO_CADASTRO_PRODUTO = 15;
	private static final int PONTOS_GANHOS_PELA_VENDA_UM_ITEM = 35;
	private static final int PONTOS_GANHOS_PELA_VENDA_DOIS_ITENS_CADA = 25;
	private static final int PONTOS_GANHOS_PELA_VENDA_TRES_ITENS_CADA = 20;

	//REMOÇÃO DE PONTOS
	private static final double PORCENTAGEM_PARA_REMOVER_PONTOS_APOS_N_DIAS = 0.1;
	private static final double PORCENTAGEM_PARA_INCREMENTAR_POR_PRECO = 0.1;

	//FAIXA DE CORREÇÃO DA REMOÇÃO DE XPs
	private static final int FAIXA_CORRECAO_ATE_100 = 1;
	private static final int FAIXA_CORRECAO_ATE_250 = 2;
	private static final int FAIXA_CORRECAO_ATE_500 = 3;
	private static final int FAIXA_CORRECAO_ATE_1000 = 4;
	private static final int FAIXA_CORRECAO_ATE_2000 = 5;
	private static final int FAIXA_CORRECAO_ATE_5000 = 6;
	private static final int FAIXA_CORRECAO_ATE_10000 = 7;
	private static final int FAIXA_CORRECAO_SEM_LIMITE = 8;
	private static final int DIVISOR_PERCENTUAL_PARA_INCREMENTO = 100;

	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_1_DIA = 10;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_3_DIAS = 20;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_5_DIAS = 35;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_10_DIAS = 30;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_15_DIAS = 25;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_30_DIAS = 20;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_45_DIAS = 15;
	private static final int PONTOS_GANHOS_PELA_VENDA_EM_ATE_60_DIAS = 10;
	private static final int PONTOS_GANHOS_PELA_VENDA_MAIS_60_DIAS = 5;


	public Xp(){
		this.pontos = PONTOS_GANHOS_PELO_CADASTRO_VENDEDOR;
		this.pontosAAdicionar = 0;
	}

	public int getPontos() {
		return pontos;
	}

	public void adicionarPontosPorVender(Produto produto) {
		int pontosIncrementarPorPreco;
		if (produto.getItensNoEstoque() == 0){
			if (produto.getQuantidade() == 1){
				pontosAAdicionar = pontosAAdicionar + produto.getQuantidade() * PONTOS_GANHOS_PELA_VENDA_UM_ITEM;
			} else if (produto.getQuantidade() == 2){
				//pontos adicinados pela venda de todos os itens
				pontosAAdicionar = pontosAAdicionar + produto.getQuantidade() * PONTOS_GANHOS_PELA_VENDA_DOIS_ITENS_CADA;

			} else if (produto.getQuantidade() == 3){
				//pontos adicinados pela venda de todos os itens
				pontosAAdicionar = pontosAAdicionar + produto.getQuantidade() * PONTOS_GANHOS_PELA_VENDA_TRES_ITENS_CADA;
			}
			
			//pontos recebidos pelo valor do produto unitariamente
			pontosIncrementarPorPreco = (int) (produto.getPreco() * PORCENTAGEM_PARA_INCREMENTAR_POR_PRECO);
			pontosAAdicionar = pontosAAdicionar + pontosIncrementarPorPreco;
			
			//pontos recebidos pelo tempo de exposição-venda do produto
			//observe q apenas após o último item vendido que é computado
			pontosAAdicionar = pontosAAdicionar + pontosRecebidosPelaVenda(produto);
			this.pontos = this.pontos + pontosAAdicionar;
			produto.setPontos(pontosAAdicionar);
			produto.setEstado(true);//é considerado vendido e não pode mais ser alterado. veja mét setEstado
			zerarPontosAAdicionar();
		}
		produto.itensNoEstoque();

	}
	public void adicionarPontosPorCadastrarProduto(){
		this.pontos = this.pontos + PONTOS_GANHOS_PELO_CADASTRO_PRODUTO ;
	}
	public void removerPontosPelaRetiradaProduto(Produto produto){
		this.pontos = this.pontos - produto.getPontos();
	}

	public void removerPontosPorPassadoNDias(boolean ehParaRemoverPontos){
		int faixaDeCorrecao = corrigirPontuacaoAposPontosRemovidos();
		if (ehParaRemoverPontos == true){
			int quantidadePontosRemovidos = (int) (this.pontos*PORCENTAGEM_PARA_REMOVER_PONTOS_APOS_N_DIAS);
			int valorCorrecao = (int) (this.pontos/DIVISOR_PERCENTUAL_PARA_INCREMENTO);
			int correcao = faixaDeCorrecao * valorCorrecao;
			this.pontos = this.pontos - quantidadePontosRemovidos + correcao;
		}
	}

	private void zerarPontosAAdicionar(){
		this.pontosAAdicionar = 0;
	}

	private int corrigirPontuacaoAposPontosRemovidos(){
		int faixaDeCorrecao = 0;
		if (this.pontos < 100) {
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_100;
		} else if (this.pontos >= 100 && this.pontos < 250) {
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_250;
		} else if (this.pontos >= 250 && this.pontos < 500){
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_500;
		} else if (this.pontos >= 500 && this.pontos < 1000){
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_1000;
		} else if (this.pontos >= 1000 && this.pontos < 2000){
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_2000;
		} else if (this.pontos >= 2000 && this.pontos < 5000){
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_5000;
		} else if (this.pontos >= 5000 && this.pontos <10000){
			faixaDeCorrecao = FAIXA_CORRECAO_ATE_10000;
		} else {
			faixaDeCorrecao = FAIXA_CORRECAO_SEM_LIMITE;
		}
		return faixaDeCorrecao;
	}

	private int pontosRecebidosPelaVenda(Produto produto){
		int pontosRecebidosPelaVendaEm;
		Period diferencaExposicaoVenda = Period.between(produto.getTempoVenda(), LocalDate.now());
		int difAnoExpoVenda = diferencaExposicaoVenda.getYears();
		int difMesExpoVenda = diferencaExposicaoVenda.getMonths();
		int difDiaExpoVenda = diferencaExposicaoVenda.getDays();
		if (difAnoExpoVenda == 0 && difMesExpoVenda == 0 && difDiaExpoVenda <= 1) {
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_1_DIA;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 0 && difDiaExpoVenda > 1 && difDiaExpoVenda <= 3) {
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_3_DIAS;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 0 && difDiaExpoVenda > 3 && difDiaExpoVenda <= 5){
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_5_DIAS;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 0 && difDiaExpoVenda > 5 && difDiaExpoVenda <= 10){
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_10_DIAS;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 0 && difDiaExpoVenda > 10 && difDiaExpoVenda <= 15){
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_15_DIAS;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 0 && difDiaExpoVenda > 15 && difDiaExpoVenda < 30){
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_30_DIAS;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 1 && difDiaExpoVenda >= 0 && difDiaExpoVenda <= 15){
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_45_DIAS;
		} else if (difAnoExpoVenda == 0 && difMesExpoVenda == 1 && difDiaExpoVenda > 15 && difDiaExpoVenda < 30){
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_EM_ATE_60_DIAS;
		} else {
			pontosRecebidosPelaVendaEm = PONTOS_GANHOS_PELA_VENDA_MAIS_60_DIAS;
		}
		return pontosRecebidosPelaVendaEm;
	}
	
	
}
