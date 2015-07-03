package br.ufrpe.negocio.controladores;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.ufrpe.dados.IRepositorioProduto;
import br.ufrpe.dados.IRepositorioVendedor;
import br.ufrpe.dados.RepositorioProduto;
import br.ufrpe.dados.RepositorioVendedor;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;
import br.ufrpe.negocio.utilidades.PessoaUtilidades;

public class ControladorVendedor {

	private IRepositorioVendedor repositorioVendedor;
	private IRepositorioProduto repositorioProduto;
	private LocalDate dia;

	public ControladorVendedor(){
		this.repositorioVendedor = RepositorioVendedor.getInstancia();
		this.repositorioProduto = RepositorioProduto.getInstancia();
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException, IllegalArgumentException, NomeUsuarioForaPadroesException, SenhaForaPadroesException{
		boolean cpfJaExiste;
		boolean nomeUsuarioJaExiste;

		if (vendedor == null){
			throw new IllegalArgumentException();// o que fazer quando null?
		} else {
			if (PessoaUtilidades.nomeUsuarioNosConformes(vendedor.getNomeUsuario())){

			} else {
				throw new NomeUsuarioForaPadroesException();
			}
			if (PessoaUtilidades.senhaNosConformes(vendedor.getSenha())){

			} else{
				throw new SenhaForaPadroesException();
			}
			
			PessoaUtilidades.nomeNosConformes(vendedor.getNome());
			//chamar método nomeUsuarioNosConforme e senha tb.		
			cpfJaExiste = repositorioVendedor.verificarCpfJaExiste(vendedor.getCpf());
			nomeUsuarioJaExiste = repositorioVendedor.verificarNomeUsuarioJaExiste(vendedor.getNomeUsuario());
			if (cpfJaExiste == false && nomeUsuarioJaExiste == false){
				repositorioVendedor.cadastrarVendedor(vendedor);
			} else if (cpfJaExiste){
				throw new CpfJaCadastradoException();
			} if (nomeUsuarioJaExiste){
				throw new NomeUsuarioJaCadastradoException();
			}
		} 
	}

	public void removerVendedor(Vendedor vendedor) throws NaoEncontradoVendedorException, IllegalArgumentException {
		List<Produto> produtosASeremRemovidos = null;
		if (vendedor != null){
			int index = repositorioVendedor.procurarIndice(vendedor);
			if (index != -1){
				produtosASeremRemovidos = repositorioProduto.retornarProdutosDoVendedor(vendedor);
				if (produtosASeremRemovidos != null){
					for (Produto p: produtosASeremRemovidos){
						repositorioProduto.removerProduto(p);
					}
				}
				repositorioVendedor.removerVendedor(vendedor);
			}
			else throw new NaoEncontradoVendedorException();
		} else{ 
			throw new IllegalArgumentException();
		}
	}

	public void atualizarVendedor(Vendedor vendedor) throws NaoEncontradoVendedorException, IllegalArgumentException{
		Vendedor v = null;
		int index = -1;
		if (vendedor != null){
			v = repositorioVendedor.retornarVendedor(vendedor.getNomeUsuario());
			index = repositorioVendedor.procurarIndice(vendedor);
		} else {
			throw new IllegalArgumentException();
		}

		if (index != -1 && v != null){
			repositorioVendedor.atualizarVendedor(v, index);
		} else {
			throw new NaoEncontradoVendedorException();
		}
	}

	public void salvarVendedor() {
		RepositorioVendedor.salvarArquivo();

	}

	public List<Vendedor> getVendedores() {
		return repositorioVendedor.getVendedores();
	}

	//método usado toda vez que fizer login numa conta de Vendedor
	public void mesarioDataCadastroRemoverPontos(List<Vendedor> vendedores){//completo um mes para remover pontos
		LocalDate dataHoje = LocalDate.now();
		Period periodoDiasControlador = null;
		Period periodoDiasVendedor;
		if (this.getDia() != null)	periodoDiasControlador = Period.between(this.getDia(), dataHoje);
		
		if (this.getDia() == null || (periodoDiasControlador.getDays() == 1)){
			for (int i = 0; i < vendedores.size(); i++){
				periodoDiasVendedor = Period.between(vendedores.get(i).getDataCadastro(), LocalDate.now());
				if (periodoDiasVendedor.getDays() == 28){//por conta do mes de fevereiro que tem apenas 28  e 29, simplifica e muito
					vendedores.get(i).getXp().removerPontosPorPassadoNDias();
				}
			}
			this.setDia(dataHoje);
		}
	}

	public Vendedor verificarLogin(String nomeUsuario, String senha) throws NaoEncontradoVendedorException, SenhaIncorretaException {
		Vendedor vendedor = null;
		boolean retSenha = false;
		boolean retNomeUsuario = false;

		if (!senha.equals("")) retSenha = repositorioVendedor.verificarSenhaJaExiste(senha);
		if (!nomeUsuario.equals("")) retNomeUsuario = repositorioVendedor.verificarNomeUsuarioJaExiste(nomeUsuario);

		if (retSenha && retNomeUsuario){
			vendedor = repositorioVendedor.verificarLogin(nomeUsuario, senha);
		} else if (retNomeUsuario == false && retSenha){
			throw new NaoEncontradoVendedorException();
		} else if (retNomeUsuario && retSenha == false){
			throw new SenhaIncorretaException();
		} else {
			throw new NaoEncontradoVendedorException();// mais importante saber para alguém que o usuario não existe do que uma senha
		}

		if (retNomeUsuario && vendedor == null) throw new SenhaIncorretaException();
		return vendedor;

	}
	
	public Vendedor retornarVendedor(String nomeUsuario) throws NaoEncontradoVendedorException, IllegalArgumentException{
		Vendedor vendedor = null;
		if (!nomeUsuario.equals("")){
			vendedor = repositorioVendedor.retornarVendedor(nomeUsuario);
			if (vendedor == null) throw new NaoEncontradoVendedorException();
		} else {
			throw new IllegalArgumentException();
		}
		
		return vendedor;
	}
	
	public void incrementarQtdProdutosAVenda(Vendedor v){
		repositorioVendedor.incrementarQtdProdutosAVenda(v);
	}
	
	public void decrementarQtdProdutosAVenda(Vendedor v){
		repositorioVendedor.decrementarQtdProdutosAVenda(v);
	}
}