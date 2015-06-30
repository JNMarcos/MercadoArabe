package br.ufrpe.negocio.classes_basicas;

public class Contato {

	private String logradouro; //rua, número e complemento
	private String bairro; 
	private String cidade;
	private String estado;
	private String email;
	private String telefone;
	
	public Contato (String logradouro, String bairro, String cidade, String estado, String email, String telefone){
		setBairro(bairro);
		setCidade(cidade);
		setEmail(email);
		setEstado(estado);
		setLogradouro(logradouro);
		setTelefone(telefone);
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
