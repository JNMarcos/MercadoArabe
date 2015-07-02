package br.ufrpe.dados;

import java.util.List;

import br.ufrpe.negocio.classes_basicas.Vendedor;

public interface IRepositorioVendedor {
	
	public abstract List<Vendedor> getVendedores();
	
	public abstract boolean verificarCpfJaExiste(String cpfVendedor);
	
	public abstract boolean verificarNomeUsuarioJaExiste(String nomeUsuario);
	
	public abstract boolean verificarSenhaJaExiste(String senha);

	public abstract void cadastrarVendedor(Vendedor vendedor);
	
	public abstract void atualizarVendedor (Vendedor vendedor, int index);

	public abstract void removerVendedor(Vendedor vendedor);

	public abstract Vendedor verificarLogin(String nomeUsuario, String senha);
	
	public abstract int procurarIndice(Vendedor vendedor);
	
	public abstract Vendedor retornarVendedor(String nomeUsuario);
	
	public abstract void incrementarQtdProdutosAVenda(Vendedor v);
	
	public abstract void decrementarQtdProdutosAVenda(Vendedor v);

}
