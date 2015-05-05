package classes_basicas;

import java.sql.Time;
import java.util.ArrayList;

public class Vendedor {
	private String nome;
	private Time dataNascimento;
	private Contato contato;
	private ArrayList<Produto> produtos;
	private int xp;
	private String nomeUsuario;
	private String senha;
	
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
	private void setXp(int xp) {//vendedor n�o pode alterar seu XP por isso � private
		this.xp = xp;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}