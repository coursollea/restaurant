package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD
{
	private static Connection connexion;
	
	public static Connection cobdd()
	{
		try {
			connexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/basetapas?autoReconnect=true&useSSL=false", "root", "");
			return connexion;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Fail");
		return null;
	}
	
	public static void stop()
	{
		try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
