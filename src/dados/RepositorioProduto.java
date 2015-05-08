package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import negocio.cadastros.CadastroProduto;
import negocio.classes_basicas.Produto;
import negocio.exceptions.NaoEncontradoProdutoException;
import negocio.exceptions.ProdutoJaCadastradoException;

public class RepositorioProduto implements IRepositorioProduto, Serializable{

	ArrayList<Produto> produtos;
	public static CadastroProduto cadastroProduto = new CadastroProduto();
	private static RepositorioProduto instancia;

	public static RepositorioProduto getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}

	private static RepositorioProduto lerDoArquivo() {
		RepositorioProduto instanciaLocal = null;

		File in = new File("repositorioProduto.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProduto) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProduto();
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
		File out = new File("repositorioProduto.dat");
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

	public void criarListaProdutos(){
		produtos = new ArrayList<Produto>();
	}

	public ArrayList<Produto> getProdutos() {
		if(this.produtos!=null)
			Collections.sort(produtos);
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	//o motivo de procurarPorProduto retornar o tipo int e não boolean é pq o
	// método será usado tb. para remover, que precisa saber o índice de remoção
	//podemos pensar, talvez numa alternativa melhor

	public int procurarPorProduto(String nomeProduto){
		int i = 0;
		int encontrou = -1; //pq não há índice negativo
		if (produtos != null) {
			while(i < produtos.size() && encontrou == -1){
				if (nomeProduto.equals(produtos.get(i).getNome())){
					encontrou = i;
				}
				i++;
			}
		}
		return encontrou;		
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException{
		if (produtos == null){
			criarListaProdutos();
		}
		int produtoJaExiste = procurarPorProduto(produto.getNome());
		if (produtoJaExiste == -1){
			produtos.add(produto);
			salvarArquivo();
		} else{
			throw new ProdutoJaCadastradoException();
		}

	}

	public void removerProduto(String nomeProduto) throws NaoEncontradoProdutoException{
		int produtoRemovido = procurarPorProduto(nomeProduto);
		if (produtoRemovido != -1){
			produtos.remove(produtoRemovido);
			salvarArquivo();
		} else{
			throw new NaoEncontradoProdutoException();
		}
	}

	public Produto mostrarProduto(String nomeProduto){
		int produtoASerMostrado = procurarPorProduto(nomeProduto);
		return produtos.get(produtoASerMostrado);
	}
}
