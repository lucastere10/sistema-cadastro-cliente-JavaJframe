package models;

public class Produto {
	private String nome;
	private String categoria;
	
	public Produto(String nome, String categoria) {
		super();
		this.nome = nome;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
