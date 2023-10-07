package com.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marah", "root", "password");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/marah?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","200093@@@marahjj");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}