package choixClient;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
import tool.DataBaseManager;
=======
import libs.GrosModel;
import libs.Personne;
import tool.Connexion;
>>>>>>> 5d045960e6b30667d84f7432d1e817f046a1f461

public class ModelCreationPersos
{

	public void addClient(int idClient, String pseudo, String couleur, int numTable)
	{

		Statement state;
		ResultSet resultat;
		try {
			state = DataBaseManager.connectBDD().createStatement();
			state.executeUpdate("insert into groupe(numeroTable) values ('" + numTable +"')"); 
			state.executeUpdate("insert into client(pseudo, couleur, idGroupe) values ('" + pseudo +"','"+ couleur +"','"+ numTable +"')");
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Personne client = new Personne(idClient, couleur, pseudo, numTable);
		client.savePersonne();
		GrosModel.addPersonne(client);

	}
	
}
