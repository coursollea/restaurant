package choixClient;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import libs.GrosModel;
import libs.Personne;
import tool.Connexion;

public class ModelCreationPersos
{
	private Personne pers;
	public void addClient(int idClient, String pseudo, String couleur, int numTable)
	{
		Personne client = new Personne(idClient, couleur, pseudo, numTable);
		pers.fillPersonne(idClient);
		pers.savePersonne();
		GrosModel.addPersonne(client);
	}
	
}
