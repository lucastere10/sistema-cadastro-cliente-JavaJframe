package com.project.connect;

public class ConnectionData {
	private String local;
	private String user;
	private String senha;
	private String porta;
	private String bd;   // PostgreSql
	private String database; // Database

	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String banco) {
		this.database = banco;
	}
}
