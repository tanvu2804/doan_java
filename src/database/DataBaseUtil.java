package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtil {
	public static Connection c;
	private static String db_url = "jdbc:mysql://localhost:3306/quanlydienthoai";
	private static String username = "root";
	private static String password = "";

	public static Connection getConnection() throws Exception {
		if (c == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");// Từ Java 6 sẽ tự tìm Driver
			c = DriverManager.getConnection(db_url, username, password);
		}
		return c;
	}

}