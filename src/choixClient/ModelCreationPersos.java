package choixClient;

import classeMetier.GroupeTable;
import libs.GrosModel;
import libs.Personne;

public class ModelCreationPersos
{

	public void addClient(String pseudo, String couleur, int numTable)
	{
		Personne client = new Personne(couleur, pseudo, numTable);
		client.savePersonne();
		GrosModel.addPersonne(client);

	}
	
	public void creerGrp(int numeroTable)
	{
		GroupeTable.saveChoix(numeroTable);
	}
	
}
