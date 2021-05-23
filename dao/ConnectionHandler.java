package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHandler 
{
	public static Connection getConnection()throws Exception 
	{
		Properties properties=new Properties();//update
	    properties.load(new FileInputStream("src/connection.properties"));
	    //Class.forName(properties.getProperty("driver"));
		String url=properties.getProperty("connection-url");
		String user=properties.getProperty("user");
		String pass=properties.getProperty("password");//update
		return DriverManager.getConnection(url,user,pass);
	}	
}
