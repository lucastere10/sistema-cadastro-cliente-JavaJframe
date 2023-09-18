package com.project.models;

import com.project.connect.ClassConnection;

public class Setup {
	private static ClassConnection con; 
	private static String schema;
	
	//constructor
	public Setup(ClassConnection con, String schema) {
		super();
		this.con = con;
		this.schema = schema;
	}
	public static ClassConnection getCon() {
		return con;
	}
	public static void setCon(ClassConnection con) {
		Setup.con = con;
	}
	public static String getSchema() {
		return schema;
	}
	public static void setSchema(String schema) {
		Setup.schema = schema;
	}
	
	
	
}
