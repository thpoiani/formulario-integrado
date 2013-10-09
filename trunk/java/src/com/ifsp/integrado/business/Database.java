package com.ifsp.integrado.business;

public class Database {
	
	private final static String ADAPTER = "mysql";
	private final static String HOST = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
	private final static String PORT = "3306";
	private final static String DATABASE = "interativo";
	private final static String USERNAME = "interativo";
	private final static String PASSWORD = "interativo";
	private static java.sql.Connection connection;

	private Database() {}
	
	public static java.sql.Connection getInstance() throws java.sql.SQLException {
		if (connection == null) {
			String connectionString = "jdbc:" + ADAPTER + "://" + HOST + ":" + PORT + "/" + DATABASE;
			connection = java.sql.DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
		}
		return connection;
	}
	
	public static void close() {
		if (connection != null) {
			connection = null;			
		}
	}
	
}
