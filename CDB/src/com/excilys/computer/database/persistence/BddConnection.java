package com.excilys.computer.database.persistence;

import java.sql.DriverManager;
import java.sql.Connection;

public class BddConnection {
	public  static BddConnection db;
	public static  Connection login;
	private String URL =  "jdbc:mysql://localhost:3306/computer-database-db";
	public final  String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final  String USERNAME = "admincdb";
	private final  String PASSWORD = "qwerty1234";
	/* On crée la connexion à la DB*/
	private BddConnection() {
	}
		
	private void getInstance() {
		try {
			Class.forName(DRIVER).newInstance();
			this.login = (Connection)DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	
	}	
	public static  BddConnection getDbConnection() {
		if (db ==null) {
			db = new BddConnection();
		}
		return db;
	}
			
			
	public void closeConnection() {
		
			
	}
	
	
	
	
	
	
	
	}