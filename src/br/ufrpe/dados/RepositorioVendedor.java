package br.ufrpe.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import br.ufrpe.negocio.cadastros.CadastroVendedor;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class RepositorioVendedor implements IRepositorioVendedor{

	ArrayList<Vendedor> vendedores;
	public static CadastroVendedor cadastroVendedor = new CadastroVendedor();
	private static RepositorioVendedor instancia;

	public static RepositorioVendedor getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}

	private static RepositorioVendedor lerDoArquivo() {
		RepositorioVendedor instanciaLocal = null;

		File in = new File("repositorioVendedor.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioVendedor) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioVendedor();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File("repositorioVendedor.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent exception*/
				}
			}
		}
	}

	public void criarListaVendedores(){
		vendedores = new ArrayList<Vendedor>();
	}

	public ArrayList<Vendedor> getVendedores() {
		if(this.vendedores!=null)
			Collections.sort(vendedores);
		return vendedores;
	}

	//o motivo de procurarPorProduto retornar o tipo int e não boolean é pq o
	// método será usado tb. para remover, que precisa saber o índice de remoção
	//podemos pensar, talvez numa alternativa melhor

	public int retornarIndiceVendedorPorCpf(String cpfVendedor){
		int i = 0;
		int encontrou = -1; //pq não há índice negativo
		if (vendedores != null) {
			while(i < vendedores.size() && encontrou == -1){
				if (cpfVendedor.equals(vendedores.get(i).getCpf())){
					encontrou = i;
				}
				i++;
			}
		}
		return encontrou;		
	}

	public int retornarIndiceVendedorPorNomeUsuario(String nomeUsuario) {
		int i = 0;
		int encontrou = -1; //pq não há índice negativo
		if (vendedores != null) {
			while(i < vendedores.size() && encontrou == -1){
				if (nomeUsuario.equals(vendedores.get(i).getNomeUsuario())){
					encontrou = -1;
				}
				i++;
			}
		}
		return encontrou;	
	}

	public int retornarIndicePorSenha(String senha) {
		int i = 0;
		int encontrou = -2;//o motivo de usar -2 é pq depois se comparará com procurarPorNomeUsuario 
		//logo após. veja login

		if (vendedores != null) { 
			while(i < vendedores.size() && encontrou == -2){
				if (senha.equals(vendedores.get(i).getSenha())){
					encontrou = i;
				}
				i++;
			}
		}
		return encontrou;
	} 

	public void cadastrarVendedor(Vendedor vendedor) throws CpfJaCadastradoException, NomeUsuarioJaCadastradoException{
		if (vendedores == null){
			criarListaVendedores();
		}
		int cpfJaExiste = retornarIndiceVendedorPorCpf(vendedor.getCpf());
		int nomeUsuarioJaExiste = retornarIndiceVendedorPorNomeUsuario(vendedor.getNomeUsuario());
		if (cpfJaExiste == -1 && nomeUsuarioJaExiste == -1){//se for -1 e false quer dizer que não foi encontrado, logo é para se cadastrar
			vendedores.add(vendedor);
			salvarArquivo();
		} else if (cpfJaExiste != -1){
			throw new CpfJaCadastradoException();
		} else if (nomeUsuarioJaExiste != -1){
			throw new NomeUsuarioJaCadastradoException();
		}

	}

	public void removerVendedor(String cpfVendedor) throws NaoEncontradoVendedorException{
		int vendedorARemover = retornarIndiceVendedorPorCpf(cpfVendedor);
		if (vendedorARemover != -1){//se diferente de -1 é pq encontrou o objeto a ser removido
			vendedores.remove(vendedorARemover);
			salvarArquivo();
		} else{
			throw new NaoEncontradoVendedorException();
		}
	}

	public Vendedor exibirInfoVendedor(String cpfVendedor){
		int vendedorASerMostrado= retornarIndiceVendedorPorCpf(cpfVendedor);
		return vendedores.get(vendedorASerMostrado);
	}


	public Vendedor verificarLogin(String nomeUsuario, String senha)
					throws NaoEncontradoVendedorException, SenhaIncorretaException {
		int indiceSenha = retornarIndicePorSenha(senha);
		int indiceNomeUsuario = retornarIndiceVendedorPorNomeUsuario(nomeUsuario);
		Vendedor vendedor = null;

		try {
			if (indiceNomeUsuario != -1){//quer dizer que existe um vendedor com aquele nome, ou seja, 
				//existe mas senha pode estar errada
				if (indiceNomeUsuario == indiceSenha){
					vendedor =  this.vendedores.get(indiceSenha);
				} else throw new SenhaIncorretaException();
			}
		} catch (NullPointerException e1) {
		} 
		return vendedor;
	} 


}

