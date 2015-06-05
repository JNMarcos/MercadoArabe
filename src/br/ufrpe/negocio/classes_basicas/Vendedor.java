package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class Vendedor implements Comparable<Vendedor>, Serializable{
	private String nome;
	private LocalDate dataNascimento;
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

	//põe nomes no formato "Pablo Alexandre do Arrocha" (primeiras letras de cada palavra em maiúscula e sem espaço no fim dos nomes)
	public void porNomesNoPadrao(String nome){
		nome = nome.trim();
		nome = nome.toLowerCase();
		Character.toUpperCase(nome.charAt(0));
		for (int i = 1; i < nome.length(); i++){
			if(nome.charAt(i) == ' ')
				Character.toUpperCase(nome.charAt(i+1));
			}
		}			
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int dia, int mes, int ano) {
		LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result	+ ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vendedor))
			return false;
		Vendedor other = (Vendedor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public int compareTo(Vendedor vendedor) {
		return this.getNome().compareToIgnoreCase(vendedor.getNome());
	}

}
