package choixClient;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.TextField;
import libs.Personne;
import tool.Connexion;

public class ModelCreationPersos
{
	private int numTable = 1;

	public void addClient(String pseudo, String couleur)
	{
		Statement state;
		try {
			state = Connexion.connectBDD().createStatement();
			state.executeUpdate("insert into client(pseudo, couleur, idGroupe) values ('" + pseudo +"','"+ couleur +"','"+ numTable +"')");
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
