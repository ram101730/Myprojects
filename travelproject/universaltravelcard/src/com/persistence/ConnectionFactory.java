package com.persistence;
import java.sql.*;
import java.util.*;
public class ConnectionFactory
{
	static String url="jdbc:oracle:thin:@localhost:1521:xe";
	static String userName="travel";
	static String password="travel";
	static Connection connection=null;
	
	
	public static Connection getConnection()
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return connection;
		
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	
	
	
}
