package com.tweetapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		DatabaseProperties properties = new DatabaseProperties();
		try {
			Class.forName(properties.readProperty("driver"));
			String url = properties.readProperty("url") + properties.readProperty("database");
			String username = properties.readProperty("username");
			String password = properties.readProperty("password");
			Connection con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException - Unable to connect to Database: " + ex.getMessage());
			return null;
		} catch (SQLException ex) {
			System.out.println("SQLException - Unable to connect to Database: " + ex.getMessage());
			return null;
		}
	}
}
