package com.ust.DBC;

import java.sql.Connection;

public class ConnectionTest {

	static Connection connection = null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		connection = ConnectionFactory.getConnection();
		System.out.println("Connected to database");
	}

}
