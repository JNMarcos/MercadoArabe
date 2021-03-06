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
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;
import br.ufrpe.negocio.filtro.Filtro;

public class Fachada {

	private ControladorProduto controladorProduto = new ControladorProduto();
	private ControladorVendedor controladorVendedor  = new ControladorVendedor();
	private ControladorComprador controladorComprador = new ControladorComprador();
	private static Fachada instancia;

	private Fachada() {

	}

	public static Fachada getInstance() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public void cadastrarProduto(Produto produto, Vendedor vendedor) throws ProdutoJaCadastradoException, IllegalArgumentException {
		controladorProduto.cadastrarProduto(produto, vendedor);
	}

	public void removerProduto(Produto produto) throws NaoEncontradoProdutoException {
		controladorProduto.removerProduto(produto);
	}
	
	public void atualizarProduto(Produto p, Vendedor v) throws NaoEncontradoProdutoException, IllegalArgumentException{
		controladorProduto.atualizarProduto(p, v);
	}

	public void salvarProduto() {
		controladorProduto.salvarProduto();
	}

	public List<Produto> retornarListaProdutos() {
		return controladorProduto.getProdutos();
	}
	
	public Produto retornarProduto(String nomeProduto, Vendedor vendedor, List<Produto> produtos) throws NaoEncontradoProdutoException, IllegalArgumentException{
		return controladorProduto.retornarProduto(nomeProduto, vendedor, produtos);
	}

	public void venderProduto(Produto produto, Vendedor vendedor, Comprador comprador) throws NaoEncontradoProdutoException, 
	NaoEncontradoVendedorException, NaoEncontradoCompradorException{
		controladorProduto.venderProduto(produto, vendedor, comprador);
	}

	public List<Produto> buscarProdutos(Filtro filtro) throws NaoEncontradoProdutoException{
		return controladorProduto.buscarProdutos(filtro);
	}

	public List<Produto> organizarProdutos(List<Produto> produtosASeremOrganizados) throws NaoEncontradoProdutoException{
		return controladorProduto.organizarProdutos(produtosASeremOrganizados);
	}

	public List<Produto> retornarProdutosDoVendedor(Vendedor v){
		return controladorProduto.retornarProdutosDoVendedor(v);
	}
	//VENDEDOR
	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException, NomeUsuarioForaPadroesException, SenhaForaPadroesException {
		controladorVendedor.cadastrarVendedor(vendedor);
	}

	public void removerVendedor(Vendedor vendedor) throws NaoEncontradoVendedorException {
		controladorVendedor.removerVendedor(vendedor);
	}

	public void salvarVendedor() {
		controladorVendedor.salvarVendedor();
	}

	public List<Vendedor> retornarListaVendedores() {
		return controladorVendedor.getVendedores();
	}

	public Vendedor verificarLoginVendedor(String nomeUsuario, String senha) 
			throws NaoEncontradoVendedorException, SenhaIncorretaException {
		return controladorVendedor.verificarLogin(nomeUsuario, senha);
	}

	public void removerPontosAposNDias(){
		controladorVendedor.mesarioDataCadastroRemoverPontos(controladorVendedor.getVendedores());
	}
	
	public Vendedor retornarVendedor(String nomeUsuario) throws NaoEncontradoVendedorException, IllegalArgumentException{
		return controladorVendedor.retornarVendedor(nomeUsuario);
	}
	
	public void incrementarQtdProdutosAVenda(Vendedor v){
		controladorVendedor.incrementarQtdProdutosAVenda(v);
	}
	
	public void decrementarQtdProdutosAVenda(Vendedor v){
		controladorVendedor.decrementarQtdProdutosAVenda(v);
	}

	public void atualizarVendedor (Vendedor v) throws NaoEncontradoVendedorException, IllegalArgumentException{
		controladorVendedor.atualizarVendedor(v);
	}
	//COMPRADOR
	public void cadastrarComprador(Comprador comprador) throws NomeUsuarioJaCadastradoException, NomeUsuarioForaPadroesException, SenhaForaPadroesException, IllegalArgumentException{
		controladorComprador.cadastrarComprador(comprador);
	}

	public void removerComprador(Comprador comprador) throws NaoEncontradoCompradorException, IllegalArgumentException {
		controladorComprador.removerComprador(comprador);
	}

	public void atualizarComprador(Comprador c) throws NaoEncontradoCompradorException, IllegalArgumentException{
		controladorComprador.atualizarComprador(c);
	}
	
	public void salvarComprador() {
		controladorComprador.salvarComprador();
	}

	public Comprador retornarComprador(String nomeUsuario) throws NaoEncontradoCompradorException, IllegalArgumentException{
		return controladorComprador.retornarComprador(nomeUsuario);
	}
	
	public List<Comprador> retornarListaCompradores() {
		return controladorComprador.getCompradores();
	}

	public Comprador verificarLoginComprador(String nomeUsuario, String senha) 
			throws NaoEncontradoCompradorException, SenhaIncorretaException {
		return controladorComprador.verificarLogin(nomeUsuario, senha);
	}
	
	public void adicionarAosAdquiridos(Comprador c, Produto p){
		controladorComprador.adicionarAosAdquiridos(c, p);
	}
	
	public void adicionarAosFavoritos(Comprador c, Produto p){
		controladorComprador.adicionarAosFavoritos(c, p);
	}
	
	public void adicionarAosInteresses(Comprador c, Produto p){
		controladorComprador.adicionarAosInteresses(c, p);
	}
	
	public void removerDosFavoritos(Comprador c, Produto p){
		controladorComprador.removerDosFavoritos(c, p);
	}
	
	public void removerDosInteresses(Comprador c, Produto p){
		controladorComprador.removerDosInteresses(c, p);
	}

	public void retornarProdutosVendedor() {
		// TODO Auto-generated method stub
		
	}
}
