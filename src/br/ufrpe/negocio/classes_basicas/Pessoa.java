package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

public abstract class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private LocalDate dataNascimento;
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

	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
