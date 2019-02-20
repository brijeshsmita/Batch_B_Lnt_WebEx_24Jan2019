/**
 * 
 */
package com.lnt.day18.hibernate.emp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Smita B Kumar
 *
 */
public class ConnectionUtil {
private static Connection conn=null;

	public static Connection getConnection() {
		String driver, url, user, password;
		File file = new File("src/database.properties");
		try(FileInputStream fis = new FileInputStream(file);
			){
			Properties prop = new Properties();
			prop.load(fis);// loaded the property file
			fis.close();
			//get the property from file
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("username");
			password = prop.getProperty("password");		
			//loading the driver .class file dynamically
			//Class.forName(driver);
			//System.out.println("Driver loaded and registered!!");
			//driver are loaded automatically by jdbc 4 onwards
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Error while Obtaining Connection.. "+e);
		}catch (IOException e1) {
			System.out.println("Error while Loading Property File.. "+e1);
		}
		return conn;
	}	
}
