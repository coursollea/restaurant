package choixClient;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.Connexion;

public class ModelCreationPersos
{

	public void addClient(String pseudo, String couleur, int numTable)
	{
		Statement state;
		ResultSet resultat;
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
