package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.connect.ClassConnection;
import com.project.connect.ConnectionData;

/*
 * @author Ricardo de Jesus
 * Made during Serratec Intern Program
 * 
 * *
 */

 public class CreateDAO {
 	private static ClassConnection conexao;	
 	
 	public static boolean createBD(String bd, String schema, ConnectionData dadosCon) {		
 		boolean bdCriado = false;
 		conexao = makeConnection("postgres", dadosCon);
 		
 		if (criarDatabase(conexao, bd)) {
 			makeDisconnection(conexao);
 			
 			conexao = makeConnection(bd, dadosCon);
 			
 			if (createSchema(conexao, schema)) {
				
 				bdCriado = true;
 			}
 		}
 		makeDisconnection(conexao);
 		
 		return bdCriado;
 	}
 	
 	//CONEXÃO--------------------------------------------------------------------------------
 	private static ClassConnection makeConnection(String bd, ConnectionData dataCon) {		
 		dataCon.setDatabase(bd);
 		ClassConnection connection = new ClassConnection(dataCon);
 		connection.conect();
 		return connection;
 	}
 	
 	private static void makeDisconnection(ClassConnection con) {
 		con.disconect();
 	}
 	
 	//---------------------------------------------------------------------------------------
 	private static boolean criarDatabase(ClassConnection con, String bd) {		
 		boolean bdExist;
 		int tries = 1;
 		String sql;
 				
 		class Database {		
 			public static ResultSet Exists(ClassConnection con, String bd) {
 				ResultSet entity;
 				String sql = "select datname from pg_database where datname = '" + bd + "'";		
 				entity = con.query(sql);
 				return entity;
 			}
 		}
 				
 		do {
 			try {
 				bdExist = Database.Exists(con, bd).next(); 
 				
 				if (!bdExist) {
 					sql = "create database "+ bd;		
 					con.query(sql);
 					tries++;
 				}
 			} catch (Exception e) {
 				System.err.printf("Não foi possível criar o database %s: %s", bd, e);
 				e.printStackTrace();
 				return false;
 			}
 		} while (!bdExist && (tries<=3));
 		
 		return bdExist;
 	}
 	
 	private static boolean createSchema(ClassConnection con, String schema) {		
 		boolean schemaExists;
 		int tries = 1;
 		String sql;
 				
 		class Schema {		
 			public static ResultSet Exists(ClassConnection con, String schema) {
 				ResultSet entity;
 				String sql = "select * from pg_namespace where nspname = '" + schema + "'";		
 				entity = con.query(sql);
 				return entity;
 			}
 		}
 				
 		do {
 			try {
 				schemaExists = Schema.Exists(con, schema).next(); 
 				
 				if (!schemaExists) {
 					sql = "create schema "+ schema;		
 					con.query(sql);
 					tries++;
 				}
 			} catch (Exception e) {
 				System.err.printf("Não foi possível criar o schema %s: %s", schema, e);
 				e.printStackTrace();
 				return false;
 			}
 		} while (!schemaExists && (tries<=3));
 		
 		return schemaExists;
 	}
 	
 	private static void criarTabela(ClassConnection con, String entitiy, String schema) {				
 		String sql = "create table " + schema + "." + entitiy + " ()";		
 		con.query(sql);		
 	}
 	
 	private static void criarCampo(ClassConnection con, String schema, String entity, 
 			String attribute, String attributeType, boolean primary, 
 			boolean foreing, String foreingEntity, 
 			String foreingAttribute) {
 		
 		if (!attributeExists(con, schema, entity, attribute)) {
 			String sql = "alter table " + schema + "." + entity + " add column " + 
 				attribute + " " + attributeType+ " "; 
 			
 			if (primary) {
 				sql += "primary key "; 
 			}

 			if (foreing) {
 				sql += "references " + schema + "." + foreingEntity + "(" + foreingAttribute + ") on delete cascade";
 			}

 			con.query(sql);
 		}
 	}	

 	//CRIAR ENTIDADES --------------------------------------------------------------
 	private static void criarEntidadeCliente(ClassConnection con, String schema) {
 		String entity = "cliente";
 		
 		if (!entityExists(con, schema, entity))		
 			criarTabela(con, entity, schema);
 		
 		if (entityExists(con, schema, entity)) {
 			criarCampo(con, schema, entity, "idcliente", "serial"	 	 	, true,  false, null, null);
 			criarCampo(con, schema, entity, "nome"	 , "varchar(100)"	, false, false, null, null);
 			criarCampo(con, schema, entity, "cpf"		 , "varchar(11)" 	, false, false, null, null);
 			criarCampo(con, schema, entity, "email"	 , "varchar(150)"	, false, false, null, null);
 			criarCampo(con, schema, entity, "telefone" , "varchar(16)"	, false, false, null, null);
 			criarCampo(con, schema, entity, "dt_nascimento"	, "date"	, false, false, null, null);
 			criarCampo(con, schema, entity, "endereco"	 	, "text"	, false, false, null, null);
 			cadastrarClientes(con, schema, entity);
 		}		
 	}
 	
 	//---------------------------------------------------------------------------------------
 	public static boolean databaseExists(ClassConnection con, String bd) {
 		ResultSet entidade;
 		boolean dbExists = false;
 		
 		String sql = "select datname from pg_database where datname = '" + bd + "'";		
 		entidade = con.query(sql);
 		
 		try {
 			dbExists = entidade.next();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		return dbExists;
 	}

 	public static boolean entityExists(ClassConnection con, String schema, String entity) {
 		boolean entityExist = false;
 		String sql = 
 				"SELECT n.nspname AS schemaname, c.relname AS tablename " +
 				   "FROM pg_class c " +
 				   "LEFT JOIN pg_namespace n ON n.oid = c.relnamespace " +
 				   "LEFT JOIN pg_tablespace t ON t.oid = c.reltablespace " +
 				"WHERE c.relkind = 'r' " +
 				"AND n.nspname = '" + schema + "' " +
 				"AND c.relname = '" + entity + "'";
 		
 		ResultSet table = con.query(sql);
 		
 		try {
 			entityExist = (table.next()?true:false); 
 			
 		} catch (SQLException e) {
 			System.out.println(e);
 			e.printStackTrace();
 		}
 		
 		return entityExist;
 	}
 	
 	public static boolean attributeExists(ClassConnection con, String schema, 
 			String entitiy, String attribute) {
 		
 		boolean attributeExist = false;
 		
 		String sql = "select table_schema, table_name, column_name from information_schema.columns "
 				+ "where table_schema = '" + schema + "' "
 				+ "and table_name = '" + entitiy + "' "
 				+ "and column_name = '" + attribute + "'";
 		
 		ResultSet result = con.query(sql);
 		
 		try {
 			attributeExist = (result.next()?true:false);
 			
 		} catch (SQLException e) {
 			System.err.println(e);
 			e.printStackTrace();
 		}
 		
 		return attributeExist;
 	}
 	
 	
 	//---------------------------------------------------------------------------------------
 	private static void cadastrarClientes(ClassConnection con, String schema, String entity) {
 		ResultSet table = con.query("select nome from " + schema + "." + entity + " limit 1");
 		
 		try {
 			if (!table.next()) {
 				String sqlClientes = "insert into " + schema + "." + entity;
 				sqlClientes += " (nome, cpf, email, telefone, dt_nascimento, endereco)";
 				sqlClientes += " values";
 				sqlClientes += "('Lucas', '12345678901', 'lucas@mail' , '12345678', '11/11/2011','Rua das Flores'),";
 				sqlClientes += "('JP Galvao', '98765432109', 'jp@mail' , '87654321', '01/01/2001','Bolso do Bruno Henrique'),";
 				sqlClientes += "('Bruno Lage', '65498732110', 'blage@mail' , '98732165', '22/02/2022','Rua dos Tolos')";
 				con.query(sqlClientes);
 				table.close();
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}		
 	}
  
 }