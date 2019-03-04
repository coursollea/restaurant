package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main 
{

	public static void main(String[] args) 
	{

		try {
			Connection connex = DriverManager.getConnection ("jdbc:mysql://localhost:3306/site_sql", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
