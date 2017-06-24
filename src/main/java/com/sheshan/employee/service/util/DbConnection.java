package com.sheshan.employee.service.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class DbConnection {

	private static Connection dbConnection;

	public static Connection getDbconnection() {
		String url;
		String password = null;
		String username = null;
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			url = "jdbc:google:mysql://hrsystem-168514:us-central1:managementdb/hr_system";

		} else {
			url = "jdbc:mysql://127.0.0.1:3306/hr_system";
			username = "root";
			password = "root";
		}
		if (dbConnection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = DriverManager.getConnection(url, username, password);
				return dbConnection;
			} catch (SQLException e) {
				e.printStackTrace();
				return dbConnection;
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
				return dbConnection;
			}
		}
		return dbConnection;
	}

}
