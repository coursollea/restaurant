package choixClient;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class Modele
{
	
	public Connection connectBDD()
	{
		try 
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_tapas", "root", "");
			
			return connex; 
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	
	public void addClient(String pseudo, String couleur)
	{
		Connection connex = connectBDD();
		Statement state;
		try {
			state = connex.createStatement();
			state.executeUpdate("insert into client(pseudo, couleur) values ('" + pseudo +"','"+ couleur +"')");
			
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
