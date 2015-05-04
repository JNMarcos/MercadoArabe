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
import java.util.List;

import classes_basicas.Produto;
import negocio.CadastroProduto;

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
				} catch (IOException e) {/* Silent */
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
	
	//continuar depois
	public void cadastrar(Produto produto){
		if (produtos == null){
			criarListaProdutos();
		}
	}
}
