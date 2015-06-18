package br.ufrpe.negocio;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Comprador;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.controladores.ControladorComprador;
import br.ufrpe.negocio.controladores.ControladorProduto;
import br.ufrpe.negocio.controladores.ControladorVendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoCompradorException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;
import br.ufrpe.negocio.filtro.Filtro;

public class Fachada {
	private ControladorProduto controladorProduto = new ControladorProduto();
	private ControladorVendedor controladorVendedor = new ControladorVendedor();
	private ControladorComprador controladorComprador = new ControladorComprador();
	private Filtro filtro;

	private Fachada() {
		// Construtor privado para evitar instanciação fora da classe
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException {
		controladorProduto.cadastrarProduto(produto);
	}

	public void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException {
		controladorProduto.removerProduto(nomeProduto);
	}

	public void salvarProduto() {
		controladorProduto.salvarProduto();
	}

	public List<Produto> retornarListaProdutos() {
		return controladorProduto.getProdutos();
	}

	public Produto exibirInfoProduto(String nomeProduto) {
		return controladorProduto.exibirInfoProduto(nomeProduto);
	}
	
	public List<Produto> buscarProduto(String nomeProduto, String categoria, String faixaPrecoDe, String faixaPrecoAte, String localVendedor){
		filtro = new Filtro(nomeProduto, categoria, faixaPrecoDe, faixaPrecoAte, localVendedor);
		return filtro.buscarProdutos();
	}
	
	//VENDEDOR
	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException {
		controladorVendedor.cadastrarVendedor(vendedor);
	}

	public void removerVendedor(String cpf) throws NaoEncontradoVendedorException {
		controladorVendedor.removerVendedor(cpf);
	}

	public void salvarVendedor() {
		controladorVendedor.salvarVendedor();
	}

	public List<Vendedor> retornarListaVendedores() {
		return controladorVendedor.getVendedores();
	}

	public Vendedor exibirInfoVendedor(String cpf) {
		return controladorVendedor.exibirInfoVendedor(cpf);
	}

	public Vendedor verificarLoginVendedor(String nomeUsuario, String senha) 
			throws NaoEncontradoVendedorException, SenhaIncorretaException {
		return controladorVendedor.verificarLogin(nomeUsuario, senha);
	}
	
	//COMPRADOR
	public void cadastrarComprador(Comprador comprador) throws NomeUsuarioJaCadastradoException {
		controladorComprador.cadastrarComprador(comprador);
	}

	public void removerComprador(String nomeUsuario) throws NaoEncontradoCompradorException {
		controladorComprador.removerComprador(nomeUsuario);
	}

	public void salvarComprador() {
		controladorComprador.salvarComprador();
	}

	public List<Comprador> retornarListaCompradores() {
		return controladorComprador.getCompradores();
	}

	public Comprador exibirInfoComprador(String nomeUsuario) {
		return controladorComprador.exibirInfoComprador(nomeUsuario);
	}

	public Comprador verificarLoginComprador(String nomeUsuario, String senha) 
			throws NaoEncontradoCompradorException, SenhaIncorretaException {
		return controladorComprador.verificarLogin(nomeUsuario, senha);
	}
	
	

}
