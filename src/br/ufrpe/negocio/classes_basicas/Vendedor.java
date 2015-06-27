package br.ufrpe.negocio.classes_basicas;

import java.time.LocalDate;

public class Vendedor extends Pessoa implements Comparable<Vendedor>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private Contato contato;
	private Xp xp;
	private LocalDate dataCadastro;

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
		return this.getCpf().compareToIgnoreCase(vendedor.getCpf());
	}

}
