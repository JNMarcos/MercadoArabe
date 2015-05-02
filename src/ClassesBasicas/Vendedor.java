package ClassesBasicas;

import java.sql.Time;
import java.util.ArrayList;

public class Vendedor {
	private String nome;
	private String nomeUsuario;
	private Time dataNascimento;
	private Contato contato;
	private ArrayList<Produto> produtos;
	private int xp;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Time getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Time dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public int getXp() {
		return xp;
	}
	private void setXp(int xp) {
		this.xp = xp;
		//comentário inútil
	}

}
