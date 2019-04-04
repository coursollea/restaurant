package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
	
	private static Connection connex = connectBDD();
	
	public static Connection connectBDD()
	{
		try 
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/BaseTapas?autoReconnect=true&useSSL=false", "root", "root");
			
			return connex; 
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
}
