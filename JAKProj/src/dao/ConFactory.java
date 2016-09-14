package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConFactory {
	
	public static Connection getConnection()
	{
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jak_shop","root", "");
			return con;
			
		} catch (Exception e) {
			
			e.printStackTrace();			
		}
		
		return null;
	}

}
