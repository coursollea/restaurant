package choixClient;

import libs.GrosModel;
import libs.Personne;

public class ModelCreationPersos
{

	public void addClient(int idClient, String pseudo, String couleur, int numTable)
	{
		Personne client = new Personne(idClient, couleur, pseudo, numTable);
		client.savePersonne();
		GrosModel.addPersonne(client);

	}
	
}
