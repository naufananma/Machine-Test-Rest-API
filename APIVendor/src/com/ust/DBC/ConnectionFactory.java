package com.ust.DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	static Connection connection = null;
	
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		return prop;
	}

	public static Connection getConnection() throws Exception {
		try {
			
			//Load Properties File
			Properties prop = loadPropertiesFile();
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
			// STEP 2: Register JDBC driver
			
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
			
		}   catch (SQLException ex)
			{
				throw new RuntimeException("Error connecting to the database", ex);
			}
	}
}

	/**
	 * Test Connection
	 * 
	 * @throws Exception
	 */
