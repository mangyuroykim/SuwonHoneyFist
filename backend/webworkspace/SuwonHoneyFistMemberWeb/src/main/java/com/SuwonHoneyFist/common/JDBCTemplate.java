package com.SuwonHoneyFist.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	private static final String DIRVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "BENQJDBC";
	private static final String PASSWORD = "BENQJDBC";
	
	private static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(conn == null || conn.isClosed()) {
			Class.forName(DIRVER_NAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	
		}
		return conn;
	}
}