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
	private int dia;
	
	public int getDia() {
		return dia;
	}
	
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
		this.dia = dia;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (dataNascimento == null) {
			if (other.dataNascimento != null) {
				return false;
			}
		} else if (!dataNascimento.equals(other.dataNascimento)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null) {
				return false;
			}
		} else if (!nomeUsuario.equals(other.nomeUsuario)) {
			return false;
		}
		if (senha == null) {
			if (other.senha != null) {
				return false;
			}
		} else if (!senha.equals(other.senha)) {
			return false;
		}
		return true;
	}
	
	
}
