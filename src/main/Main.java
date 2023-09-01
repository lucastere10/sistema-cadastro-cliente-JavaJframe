package main;

import database.Conexao;
//import database.Conexao2;
import database.DadosConexao;

public class Main {
	public static Conexao con;
	public static DadosConexao dadosCon = new DadosConexao();
	public static final String BANCO = "SistemaCadastroDB";
	public static final String SCHEMA = "sistema";
	public static final String LOCAL = "localhost";
	public static final String USUARIO = "postgres";
	public static final String SENHA = "<teste123>";
	public static final String PORTA = "5432";
	public static final String BD = "PostgreSql";

	public static void main(String[] args) {

		dadosCon.setBanco(BANCO);
		dadosCon.setLocal(LOCAL);
		dadosCon.setUser(USUARIO);
		dadosCon.setSenha(SENHA);
		dadosCon.setPorta(PORTA);
		dadosCon.setBd(BD);

		con = new Conexao(dadosCon);
		con.conect();
	}

}
