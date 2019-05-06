package choixClient;

import classeMetier.GroupeTable;
import classeMetier.Personne;
import libs.GrosModel;

public class ModelCreationPersos
{
	private GroupeTable table;
	
	public void addClient(String pseudo, String couleur)
	{
		Personne client = new Personne(couleur, pseudo, table.getID());
		client.savePersonne();
		GrosModel.addPersonne(client);

	}
	
	public void creerGrp(int numeroTable)
	{
		System.out.println(numeroTable);
		table = new GroupeTable();
		table.setNumeroTable(numeroTable);
		table.saveChoix();
	}
	
}
