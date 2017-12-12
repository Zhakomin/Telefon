package net.codejava.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class ConnectionDb {

    private Properties prorerties = new Properties();
    private Connection msqlConnect;
    public void Conect() {
    	 if (msqlConnect == null) {
    	 try {
    	       Class.forName ("com.mysql.jdbc.Driver");
 		   	   msqlConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abonent?autoReccnect=true&useSSL=false", "root","root");
 		    } catch (SQLException e) {
			   e.printStackTrace();
		    } catch (ClassNotFoundException e) {
 		       e.printStackTrace();
		    }
 
    }
     }
     public ResultSet resultSetQuery(String query) {
    	 ResultSet result = null;
    	 Statement stnt;
		try {
			stnt = msqlConnect.createStatement();
			result = stnt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
     }
     public void  updateQuery(String query) {
    	 
		try {
			Statement stnt = msqlConnect.createStatement();
			stnt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
     }
}