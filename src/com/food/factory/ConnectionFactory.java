package com.food.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
static{
	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Connection getConnection() throws SQLException{
	String url="jdbc:postgresql://localhost:5432/Food";
String userName="postgres";
String password="manikant";
Connection con=DriverManager.getConnection(url,userName,password);
return con;
}
}
