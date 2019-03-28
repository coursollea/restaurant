package choixClient;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.TextField;
import libs.Personne;

public class Modele
{
	private Connection connex = connectBDD();
	private int numTable = 1;
	
	public Connection connectBDD()
	{
		try 
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/BaseTapas?autoReconnect=true&useSSL=false", "root", "");
			
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
		Statement state;
		try {
			state = connex.createStatement();
			state.executeUpdate("insert into client(pseudo, couleur, idGroupe) values ('" + pseudo +"','"+ couleur +"','"+ numTable +"')");
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
