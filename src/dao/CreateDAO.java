package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import database.Conexao;
import database.DadosConexao;

public class CreateDAO {
	private static Conexao conexao;	
	
	public static boolean createBD(String bd, String schema, DadosConexao dadosCon) {		
		boolean bdCriado = false;
		conexao = conectar("postgres", dadosCon);
		
		if (criarDatabase(conexao, bd)) {
			desconectar(conexao);
			
			conexao = conectar(bd, dadosCon);
			
			if (criarSchema(conexao, schema)) {
				criarEntidadeCliente(conexao, schema);
				criarEntidadeFuncionario(conexao, schema);
				criarEntidadeCategoria(conexao, schema);
				criarEntidadeProduto(conexao, schema);
				criarEntidadePedido(conexao, schema);
				criarEntidadePedidoItem(conexao, schema);
				bdCriado = true;
			}
		}
		desconectar(conexao);
		
		return bdCriado;
	}
	
	private static Conexao conectar(String bd, DadosConexao dadosCon) {		
		dadosCon.setBanco(bd);
		Conexao conexao = new Conexao(dadosCon);
		conexao.conect();
		return conexao;
	}
	
	private static void desconectar(Conexao con) {
		con.disconect();
	}
	
	private static boolean criarDatabase(Conexao con, String bd) {		
		boolean bdExiste;
		int tentativas = 1;
		String sql;
				
		class Database {		
			public static ResultSet Exists(Conexao con, String bd) {
				ResultSet entidade;
				String sql = "select datname from pg_database where datname = '" + bd + "'";		
				entidade = con.query(sql);
				return entidade;
			}
		}
				
		do {
			try {
				bdExiste = Database.Exists(con, bd).next(); 
				
				if (!bdExiste) {
					sql = "create database "+ bd;		
					con.query(sql);
					tentativas++;
				}
			} catch (Exception e) {
				System.err.printf("Nao foi possivel criar o database %s: %s", bd, e);
				e.printStackTrace();
				return false;
			}
		} while (!bdExiste && (tentativas<=3));
		
		return bdExiste;
	}
	
	private static boolean criarSchema(Conexao con, String schema) {		
		boolean schemaExiste;
		int tentativas = 1;
		String sql;
				
		class Schema {		
			public static ResultSet Exists(Conexao con, String schema) {
				ResultSet entidade;
				String sql = "select * from pg_namespace where nspname = '" + schema + "'";		
				entidade = con.query(sql);
				return entidade;
			}
		}
				
		do {
			try {
				schemaExiste = Schema.Exists(con, schema).next(); 
				
				if (!schemaExiste) {
					sql = "create schema "+ schema;		
					con.query(sql);
					tentativas++;
				}
			} catch (Exception e) {
				System.err.printf("Nao foi possivel criar o schema %s: %s", schema, e);
				e.printStackTrace();
				return false;
			}
		} while (!schemaExiste && (tentativas<=3));
		
		return schemaExiste;
	}
	
	private static void criarTabela(Conexao con, String entidade, String schema) {				
		String sql = "create table " + schema + "." + entidade + " ()";		
		con.query(sql);		
	}
	
	private static void criarCampo(Conexao con, String schema, String entidade, 
			String atributo, String tipoAtributo, boolean primario, 
			boolean estrangeiro, String entidadeEstrangeira, 
			String atributoEstrangeiro) {
		
		if (!atributoExists(con, schema, entidade, atributo)) {
			String sql = "alter table " + schema + "." + entidade + " add column " + 
				atributo + " " + tipoAtributo + " "; 
			
			if (primario) {
				sql += "primary key "; 
			}

			if (estrangeiro) {
				sql += "references " + schema + "." + entidadeEstrangeira + "(" + atributoEstrangeiro + ")";
			}

			System.out.println(sql);
			con.query(sql);
		}
	}
	
	private static void criarChaveComposta(Conexao con, String schema, String entidade, 
			String nomesCamposCompostos ) {
		
		boolean chaveExist = false;
		String sql = "SELECT CONNAME FROM pg_constraint where conname = 'chave_pk'";				
		ResultSet result = con.query(sql);
		
		try {
			chaveExist = (result.next()?true:false);
			
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		if (!chaveExist) {
			sql = "alter table " + schema + "." + entidade + " add constraint chave_pk" +
					" primary key (" + nomesCamposCompostos + ")";
				
		con.query(sql);
		}
	}
	
	/*
	 * =================================================================================
	 * 								CRIAR ENTIDADES
	 * =================================================================================
	 * */
	
	private static void criarEntidadeCliente(Conexao con, String schema) {
		String entidade = "cliente";
		
		if (!entidadeExists(con, schema, entidade))		
			criarTabela(con, entidade, schema);
		
		if (entidadeExists(con, schema, entidade)) {
			criarCampo(con, schema, entidade, "idcliente", "serial"	 	 	, true,  false, null, null);
			criarCampo(con, schema, entidade, "codigo"	 ,
					"TEXT GENERATED ALWAYS AS ( 'USER' || LPAD(idcliente::TEXT, 3, '0') ) STORED", 
					false,  false, null, null);
			criarCampo(con, schema, entidade, "nome"	 , "varchar(100)"	, false, false, null, null);
			criarCampo(con, schema, entidade, "cpf"		 , "varchar(11)" 	, false, false, null, null);
			criarCampo(con, schema, entidade, "email"	 , "varchar(150)"	, false, false, null, null);
			criarCampo(con, schema, entidade, "telefone" , "varchar(16)"	, false, false, null, null);
			criarCampo(con, schema, entidade, "endereco" , "varchar(150)"	, false, false, null, null);
			criarCampo(con, schema, entidade, "dtnasc"	 , "date"	 	 	, false, false, null, null);
		}		
	}
	
	private static void criarEntidadeFuncionario(Conexao con, String schema) {
		String entidade = "funcionario";
		
		if (!entidadeExists(con, schema, entidade))		
			criarTabela(con, entidade, schema);
		
		if (entidadeExists(con, schema, entidade)) {
			criarCampo(con, schema, entidade, "idfuncionario"	 , "serial"	 	 	 , true,  false, null, null);
			criarCampo(con, schema, entidade, "codigo"	 ,
					"TEXT GENERATED ALWAYS AS ( 'FUNC' || LPAD(idfuncionario::TEXT, 3, '0') ) STORED", 
					false,  false, null, null);
			criarCampo(con, schema, entidade, "nome"	 , "varchar(100)"	 , false, false, null, null);
			criarCampo(con, schema, entidade, "cpf"		 , "varchar(14)" 	 , false, false, null, null);
			criarCampo(con, schema, entidade, "username" , "varchar(14)" 	 , false, false, null, null);
			criarCampo(con, schema, entidade, "senha"	 , "varchar(60)" 	 , false, false, null, null);
			criarCampo(con, schema, entidade, "email"	 , "varchar(150)"	 , false, false, null, null);
			criarCampo(con, schema, entidade, "endereco" , "varchar(150)"	 , false, false, null, null);
		}		
	}
	
	private static void criarEntidadeCategoria(Conexao con, String schema) {
		String entidade = "categoria";
		
		if (!entidadeExists(con, schema, entidade))		
			criarTabela(con, entidade, schema);
		
		if (entidadeExists(con, schema, entidade)) {
			criarCampo(con, schema, entidade, "idcategoria"	 , "serial"	 	 , true,  false, null, null);
			criarCampo(con, schema, entidade, "nome"	 , "varchar(100)"	 , false, false, null, null);
			criarCampo(con, schema, entidade, "descricao", "varchar(255)" 	 , false, false, null, null);
		}		
	}
	
	private static void criarEntidadeProduto(Conexao con, String schema) {
		String entidade = "produto";
		
		if (!entidadeExists(con, schema, entidade))		
			criarTabela(con, entidade, schema);
		
		if (entidadeExists(con, schema, entidade)) {
			criarCampo(con, schema, entidade, "idproduto"	, "serial"	 	, true,  false, null, null);
			criarCampo(con, schema, entidade, "codigo"	 ,
					"TEXT GENERATED ALWAYS AS ( 'PROD' || LPAD(idproduto::TEXT, 3, '0') ) STORED", 
					false,  false, null, null);
			criarCampo(con, schema, entidade, "nome"	 			, "varchar(100)", false, false, null, null);
			criarCampo(con, schema, entidade, "descricao"			, "varchar(255)", false, false, null, null);
			criarCampo(con, schema, entidade, "data_fabricacao"		, "date"		, false, false, null, null);
			criarCampo(con, schema, entidade, "valor_unitario"		, "numeric"		, false, false, null, null);
			criarCampo(con, schema, entidade, "quantidade_estoque"	, "int"			, false, false, null, null);
			criarCampo(con, schema, entidade, "idcategoria"  		, "int"
					, false, true, "categoria", "idcategoria");
		}
		
	}
	
	private static void criarEntidadePedido(Conexao con, String schema) {
		String entidade = "pedido";
		
		if (!entidadeExists(con, schema, entidade))		
			criarTabela(con, entidade, schema);
		
		if (entidadeExists(con, schema, entidade)) {
			criarCampo(con, schema, entidade, "idpedido"	, "serial"	 	, true,  false, null, null);
			criarCampo(con, schema, entidade, "codigo"	 ,
					"TEXT GENERATED ALWAYS AS ( 'ORDER' || LPAD(idpedido::TEXT, 3, '0') ) STORED", 
					false,  false, null, null);
			criarCampo(con, schema, entidade, "data_emissao"		, "date"		, false, false, null, null);
			//fks
			criarCampo(con, schema, entidade, "idfuncionario", "int"	 		
					, false, true, "funcionario", "idfuncionario");
			criarCampo(con, schema, entidade, "idcliente", "int"
					, false, true, "cliente", "idcliente");
		}
		
	}
	
	private static void criarEntidadePedidoItem(Conexao con, String schema) {
		String entidade = "pedido_produto";
		
		if (!entidadeExists(con, schema, entidade))		
			criarTabela(con, entidade, schema);
		
		if (entidadeExists(con, schema, entidade)) {
			//fks
			criarCampo(con, schema, entidade, "idproduto"		
					,"int" , false,  true, "produto", "idproduto");
			criarCampo(con, schema, entidade, "idpedido"		
					,"int" , false,  true, "pedido", "idpedido");
			//atributos
			criarCampo(con, schema, entidade, "quantidade"	 	, "int"				, false, false, null, null);
			criarCampo(con, schema, entidade, "valor_unitario"	, "Double Precision", false, false, null, null);
			criarCampo(con, schema, entidade, "valor_desconto"	, "date"			, false, false, null, null);
			criarCampo(con, schema, entidade, "frete"			, "numeric"			, false, false, null, null);
			criarCampo(con, schema, entidade, "valor_bruto"		, "int"				, false, false, null, null);
			criarCampo(con, schema, entidade, "valor_liquido"  	, "int"	 			, false, false, null, null);
		}
		
	}
	

	public static boolean databaseExists(Conexao con, String bd) {
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

	public static boolean entidadeExists(Conexao con, String schema, String entidade) {
		boolean entidadeExist = false;
		String sql = 
				"SELECT n.nspname AS schemaname, c.relname AS tablename " +
				   "FROM pg_class c " +
				   "LEFT JOIN pg_namespace n ON n.oid = c.relnamespace " +
				   "LEFT JOIN pg_tablespace t ON t.oid = c.reltablespace " +
				"WHERE c.relkind = 'r' " +
				"AND n.nspname = '" + schema + "' " +
				"AND c.relname = '" + entidade + "'";
		
		ResultSet tabela = con.query(sql);
		
		try {
			entidadeExist = (tabela.next()?true:false); 
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return entidadeExist;
	}
	
	public static boolean atributoExists(Conexao con, String schema, 
			String entidade, String atributo) {
		
		boolean atributoExist = false;
		
		String sql = "select table_schema, table_name, column_name from information_schema.columns "
				+ "where table_schema = '" + schema + "' "
				+ "and table_name = '" + entidade + "' "
				+ "and column_name = '" + atributo + "'";
		
		ResultSet result = con.query(sql);
		
		try {
			atributoExist = (result.next()?true:false);
			
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		return atributoExist;
	}
	
	/*private static void cadastrarLivros(Conexao con, String schema, String entidade) {
		
		ResultSet tabela = con.query("select titulo from " + schema + "." + entidade + " limit 1");
		
		try {
			if (!tabela.next()) {
				String sql = "insert into " + schema + "." + entidade;
				sql += " (titulo, autor, isbn, editora, nrpaginas, quantidade)";
				sql += " values";
				sql += "('e assim que acaba', 'Colleen Hoover', '11111', 'Galera', 368, 1),";
				sql += "('Como fazer amigos e influenciar pessoas', 'Dale Carnegie', '8543108683,', 'Editora Sextante', 256, 4),";
				sql += "('Pai rico pai pobre', 'Robert T. Kiyosaki', '8550801488', 'Alta Books', 336, 3),";
				sql += "('O homem mais rico da Babilonia', 'George S. Clason', '22222', 'HarperCollins', 160, 2),";
				sql += "('SQL Guia Pratico: Um guia para o uso de SQL', 'Alice Zhao', 'B0BQP75V8R', 'Novatec Editora', 351, 1),";
				sql += "('Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos', 'Aditya Y. Bhargava', '8575225634', 'Novatec Editora', 264, 1),";
				sql += "('Codigo limpo: Habilidades praticas do Agile Software', 'Robert C. Martin', '8576082675', 'Alta Books', 425, 2),";
				sql += "('Arquitetura limpa: O guia do artesao para estrutura e design de software', 'Robert C. Martin', '8550804606', 'Alta Books', 432, 1),";
				sql += "('O codificador limpo: Um codigo de conduta para programadores profissionais', 'Bob Martin', '8576086476', 'Alta Books', 244, 1),";
				sql += "('Refatoracao: Aperfeicoando o Design de Codigos Existentes', 'Colleen Hoover', '8575227246', 'Novatec Editora', 456, 6)";
				
				con.query(sql);
				tabela.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}*/
}
