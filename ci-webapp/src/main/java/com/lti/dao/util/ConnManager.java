package com.lti.dao.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
	
	public static Connection connect( ) {
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			return DriverManager.getConnection("jdbc:derby://localhost:1527/trainingdb","mj", "mj");
			}
		catch(ClassNotFoundException | SQLException e) {
	        	e.printStackTrace();
	        	return null;
	        }        
	}

}