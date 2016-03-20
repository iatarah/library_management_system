package com.bfis.lms;

import static com.bfis.lms.DatabaseConnector.PASS;
import static com.bfis.lms.DatabaseConnector.URL;
import static com.bfis.lms.DatabaseConnector.USER;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector {
	static final String USER = "lms";
	static final String PASS = "lms";
	static final String URL = "jdbc:mysql://172.17.5.161:3306/lmsdb";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static Connection cn;
	static ResultSet rs;
	static Statement st;
	//static ArrayList resultList;
	DatabaseConnector(){		
		try {
			cn = DriverManager.getConnection(URL, USER, PASS);
			//Statement st = cn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//resultList = new ArrayList();		
		
	}
	
	public static ResultSet dbQuery(String msg){
		try {
			rs = st.executeQuery(msg);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs; 
		
	}
	
	
	

}
