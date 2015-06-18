package br.ufrpe.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.controladores.ControladorProduto;
import br.ufrpe.negocio.exceptions_negocio.FaixaPrecoForaLimitesException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoProdutoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;

public class RepositorioProduto implements IRepositorioProduto, Serializable, Iterator<Produto>{

	private static final long serialVersionUID = 1L;
	ArrayList<Produto> produtos;
	public static ControladorProduto cadastroProduto = new ControladorProduto();
	private static RepositorioProduto instancia;
	public static int posicao = 0;

	public static RepositorioProduto getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioProduto();
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

	public List<Produto> getProdutos() {
		if(this.produtos!=null)
			Collections.sort(produtos);
		return produtos;
	}

	public boolean verificarNomeProdutoJaExiste(String nomeProduto){
		boolean nomeProdutoJaExiste = false;
		if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){
			Iterator<Produto> iVendedor = this.produtos.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getNome().equals(nomeProduto)){
					nomeProdutoJaExiste = true;
					zeraContadorPosicao();
					break;
				}
				incrementaContadorPosicao();
			}
		}
		return nomeProdutoJaExiste;
	}

	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException{
		if (this.produtos == null){
			criarListaProdutos();
		}
		produtos.add(produto);
		salvarArquivo();
	}

	public void removerProduto(String nomeProduto){
		boolean removeu = false;
		if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){
			for (Produto p: this.produtos){
				if (p.getNome().equalsIgnoreCase(nomeProduto)){
					this.produtos.remove(p);
					break;
				}
			}
			//VER O QUE FAZER COM ISSO
			Iterator<Produto> iVendedor = this.produtos.listIterator();
			while(iVendedor.hasNext()){
				if (iVendedor.next().getNome().equals(nomeProduto)){
					iVendedor.remove();
					removeu = true;
					zeraContadorPosicao();
					salvarArquivo();
					break;
				}
				incrementaContadorPosicao();
			}
		}
	}

		public void removerProduto(Produto produto) throws NaoEncontradoProdutoException{
			if (!produto.equals("")){
				for (Produto p: this.produtos){
					if (p.getNome().equals(produto)){
						this.produtos.remove(p);
						break;
					}
				}
			}
		}

			public List<Produto> procurarProdutoPorNome(String nomeProduto, List<Produto> produtosASeremRefinados) throws NaoEncontradoProdutoException{
				List<Produto> produtosEncontrados = null;
				Iterator<Produto> iProduto;
				if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){

					if (produtosASeremRefinados.equals("")){
						iProduto = this.produtos.iterator();
					} else {
						iProduto = produtosASeremRefinados.listIterator();
					} //iterator ou listIterator
					produtosEncontrados = new ArrayList<Produto>();
					while (iProduto.hasNext()){
						if (iProduto.next().getNome().equals(nomeProduto)){
							produtosEncontrados.add(iProduto.next());
						}
						incrementaContadorPosicao();
					}
				}
				return 	produtosEncontrados;//pode ser null
			}

			public List<Produto> procurarProdutoPorCategoria(
					String categoriaProduto, List<Produto> produtosASeremRefinados) throws NaoEncontradoProdutoException {

				List<Produto> produtosEncontrados = null;
				Iterator<Produto> iProduto;

				if (!categoriaProduto.equals("") && !categoriaProduto.equals(" ")){
					if (produtosASeremRefinados.equals("")){
						iProduto = this.produtos.listIterator();
					} else {
						iProduto = produtosASeremRefinados.listIterator();
					} //iterator ou listIterator
					produtosEncontrados = new ArrayList<Produto>();
					while (iProduto.hasNext()){
						if (iProduto.next().getCategoria().equals(categoriaProduto)){
							produtosEncontrados.add(iProduto.next());
						}
						incrementaContadorPosicao();
					}
				}
				return 	produtosEncontrados;//pode ser null
			}

			public List<Produto> procurarProdutoPorFaixaPreco (double de, double ate, List<Produto> produtosASeremRefinados)
					throws NaoEncontradoProdutoException, FaixaPrecoForaLimitesException{
				List<Produto> produtosEncontrados = null;
				Iterator<Produto> iProduto;

				if ((de > 0.0 || ate > 0.0) && de != ate && de < ate){//se receber um 'de' negativo e 'ate' positivo,
					//veja que entra, mas nesse caso como os valores tem de ser maio que zero não interfere tanto
					if (produtosASeremRefinados.equals("")){
						iProduto = this.produtos.listIterator();
					} else {
						iProduto = produtosASeremRefinados.listIterator();
					} //iterator ou listIterator
					produtosEncontrados = new ArrayList<Produto>();
					while (iProduto.hasNext()){
						if (iProduto.next().getPreco() >= de && iProduto.next().getPreco() <= ate){
							produtosEncontrados.add(iProduto.next());
						}
						incrementaContadorPosicao();
					}
				} else new FaixaPrecoForaLimitesException();
				return 	produtosEncontrados;//pode ser null
			} 

			public Produto exibirInfoProduto(String nomeProduto, List<Produto> produtoASerEncontrado){
				Produto produto = null;
				Iterator<Produto> iProduto;
				if (!nomeProduto.equals("") && !nomeProduto.equals(" ")){
					if (produtoASerEncontrado.equals("")){
						iProduto = this.produtos.listIterator();
					} else {
						iProduto = produtoASerEncontrado.listIterator();
					} //iterator ou listIterator
					while(iProduto.hasNext()){
						if (iProduto.next().getNome().equals(nomeProduto)){
							produto = iProduto.next();
							zeraContadorPosicao();
							break;//sai do while e não busca mais
						}
						incrementaContadorPosicao();
					}	
				}
				return produto;//pode ser null
			}

			public List<Produto> procurarProdutoPorLocalVendedor(String localVendedor, List<Produto> produtosASeremRefinados)	throws NaoEncontradoProdutoException {
				List<Produto> produtosEncontrados = null;
				Iterator<Produto> iProduto;

				if (!localVendedor.equals("") && !localVendedor.equals(" ")){
					if (produtosASeremRefinados.equals("")){
						iProduto = this.produtos.listIterator();
					} else {
						iProduto = produtosASeremRefinados.listIterator();
					} //iterator ou listIterator
					produtosEncontrados = new ArrayList<Produto>();
					while (iProduto.hasNext()){
						if (iProduto.next().getVendedor().getContato().getCidade().equals(localVendedor)){
							produtosEncontrados.add(iProduto.next());
						}
						incrementaContadorPosicao();
					}
				}
				return 	produtosEncontrados;//pode ser null
			}

			public Produto next(){
				Produto produto = this.produtos.get(posicao);
				return produto;
			}

			public boolean hasNext(){
				boolean temProximo = true;//posto true pois comumente será mais vezes true
				if (posicao >= this.produtos.size() || this.produtos.get(posicao) == null) {
					temProximo = false;
					zeraContadorPosicao();
				}
				return temProximo;
			}

			public static void incrementaContadorPosicao(){
				posicao++;
			}
			public static void zeraContadorPosicao(){
				posicao = 0;
			}

			// fazer o remove depois
			@Override
			public void remove() {
				// TODO Auto-generated method stub

			}
		}
