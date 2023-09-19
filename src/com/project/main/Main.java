package com.project.main;

import java.util.Scanner;

import com.project.connect.ClassConnection;
import com.project.connect.ConnectionData;
import com.project.connect.ConnectionFile;
import com.project.dao.CreateDAO;
import com.project.frames.LoginFrame;
import com.project.models.Setup;


public class Main {

	public static Setup sys;
	public static ClassConnection con;
	public static ConnectionData dadosCon = new ConnectionData();
	public static final String BANCO = "dbcrud";
	public static final String SCHEMA = "crud";
	public static final String PATH = System.getProperty("user.dir");
	public static final String SFILE = "DadosConexao.ini";
	public static void main(String[] args) {

		System.out.println("Present Project Directory : " + System.getProperty("user.dir"));
		if (configInicial()) {
			if (CreateDAO.createBD(BANCO, SCHEMA, dadosCon)) {
				try (Scanner input = new Scanner(System.in)) {
					con = new ClassConnection(dadosCon);
					con.conect();
					sys = new Setup(con, SCHEMA);
					LoginFrame lframe = new LoginFrame(con,SCHEMA);
					lframe.setVisible(true); 
					System.out.println(System.getProperty("user.dir"));
					System.out.println("Banco de Dados conectado com sucesso!");

				}
			} else {
				System.out.println("Ocorreu um problema na criacao do banco de dados");
			}
		} else
			System.out.println("Não foi possível executar o sistema.");
	}

	public static boolean configInicial() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		ConnectionFile conexaoIni = new ConnectionFile(PATH + "\\" + SFILE);
		boolean abrirSistema = false;

		if (conexaoIni.createFile()) {
			if (conexaoIni.feedDataConnection()) {
				dadosCon = conexaoIni.getData();
				abrirSistema = true;
			} else {
				conexaoIni.deleteFile();
				System.out.println("Arquivo de configuração de conexão:\n");
				System.out.println("Local: ");
				String local = input.nextLine();
				System.out.println("Porta: ");
				String porta = input.nextLine();
				System.out.println("Usuário: ");
				String usuario = input.nextLine();
				System.out.println("Senha: ");
				String senha = input.nextLine();
				System.out.println("Database: ");
				String banco = input.nextLine();

				if (conexaoIni.createFile()) {
					conexaoIni.writeFile("bd=PostgreSql");
					conexaoIni.writeFile("local=" + local);
					conexaoIni.writeFile("porta=" + porta);
					conexaoIni.writeFile("usuario=" + usuario);
					conexaoIni.writeFile("senha=" + senha);
					conexaoIni.writeFile("banco=" + banco);

					if (conexaoIni.feedDataConnection()) {
						dadosCon = conexaoIni.getData();
						abrirSistema = true;
					} else
						System.out.println("Não foi possível efetuar a configuração.\nVerifique");
				}
			}
		} else
			System.out.println("Houve um problema na criação do arquivo de configuração.");

		return abrirSistema;
	}
}
