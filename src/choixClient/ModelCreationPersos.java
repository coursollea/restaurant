package choixClient;



import java.sql.SQLException;
import java.sql.Statement;

import tool.Connexion;

public class ModelCreationPersos
{

	public void addClient(String pseudo, String couleur, int numTable)
	{
		Statement state;
		try {
			state = Connexion.connectBDD().createStatement();
			state.executeUpdate("insert into groupe(numeroTable) values ('" + numTable +"')"); 
			state.executeUpdate("insert into client(pseudo, couleur, idGroupe) values ('" + pseudo +"','"+ couleur +"','"+ numTable +"')");
			System.out.println("Personnage " + couleur + " " + pseudo + " Créé à la table " + numTable);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
