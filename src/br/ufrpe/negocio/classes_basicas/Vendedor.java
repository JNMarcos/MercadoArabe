package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.List;

public class Vendedor implements Comparable<Vendedor>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private LocalDate dataNascimento;
	private Contato contato;
	private String cpf;
	private List<Produto> produtos;
	private Xp xp;
	private String nomeUsuario;
	private String senha;
	private LocalDate dataCadastro;

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
		Year anoAgora = Year.now();
		int anoAgoraEmInteiro = anoAgora.getValue();
		if (dia >= 1 && dia <= 31 && mes >= 1  && mes <= 12 && ano >= 1900 && ano <= anoAgoraEmInteiro){
			LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
			this.dataNascimento = dataNascimento;
		}
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro() {
		this.dataCadastro = LocalDate.now();
	}
	
	public Xp getXp() {
		return xp;
	}
	
	public void setXp(Xp xp) {
		this.xp = xp;
	}

	//método usado toda vez que fizer login numa conta de Vendedor
	public boolean mesarioDataCadastroRemoverPontos(){//completo um mes para remover pontos
		boolean ehParaRemoverPontos = false;
		Period periodoDias = Period.between(dataCadastro, LocalDate.now());
		if (periodoDias.getDays() == 30){
			ehParaRemoverPontos = true;
		}
		return ehParaRemoverPontos;
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
