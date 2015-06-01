package br.ufrpe.negocio.classes_basicas;

import java.sql.Time;
import java.util.ArrayList;

public class Vendedor {
	private String nome;
	private Time dataNascimento;
	private Contato contato;
	private String cpf;
	private ArrayList<Produto> produtos;
	private Xp xp;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
