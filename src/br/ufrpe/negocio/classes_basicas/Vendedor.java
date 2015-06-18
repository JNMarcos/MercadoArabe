package br.ufrpe.negocio.classes_basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Vendedor extends Pessoa implements Comparable<Vendedor>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private Contato contato;
	private Xp xp;
	private LocalDate dataCadastro;

	

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
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro() {
		this.dataCadastro = LocalDate.now();
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCpf() == null) ? 0 : getCpf().hashCode());
		result = prime * result	+ ((getNomeUsuario() == null) ? 0 : getNomeUsuario().hashCode());
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
