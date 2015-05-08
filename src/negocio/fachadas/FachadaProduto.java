package fachadas;

import java.util.ArrayList;

import cadastros.CadastroProduto;
import negocio.classes_basicas.Produto;
import negocio.classes_basicas.Vendedor;
import negocio.exceptions.CpfJaCadastradoException;
import negocio.exceptions.NomeUsuarioJaCadastradoException;
import negocio.exceptions.ProdutoJaCadastradoException;

public class FachadaProduto {
	private CadastroProduto cadastroProduto = new CadastroProduto();

	private FachadaProduto() {
		// Construtor privado para evitar instanciação fora da classe
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException {
		cadastroProduto.cadastrarProduto(produto);
	}

	public void removerProduto(String nome) {
		cadastroProduto.removerProduto(nome);
	}

	public void salvarProduto() {
		cadastroProduto.salvarProduto();
	}

	public ArrayList<Produto> retornarListaProdutos() {
		return cadastroProduto.getProdutos();
	}

	public Vendedor exibirInfoProduto(String nome) {
		return cadastroProduto.exibirInfoProduto(nome);
	}
}
