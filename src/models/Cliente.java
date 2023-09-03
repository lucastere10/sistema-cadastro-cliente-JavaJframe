package models;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {
	protected int	 idcliente;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String telefone;
	protected String endereco;
	protected LocalDate  dtnasc;
	
	public Cliente(String nome, String cpf, String email, 
			String telefone, String endereco, LocalDate dtnasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dtnasc = dtnasc;
	}

	public Cliente(String nome, String cpf, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}



	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(LocalDate dtnasc) {
		this.dtnasc = dtnasc;
	}
		
}
