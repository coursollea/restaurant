package classeMetier;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import tool.DataBaseManager;

public class Commande 
{

	private int ID; 
	private Date dateCommande;
	
	
	public void fillCommande(int ID)
	{
		
		ResultSet result; 
		DataBaseManager connex = new DataBaseManager(); // se co à la bdd
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Commande Where Commande.ID = " + ID); // récupérer les infos de la table Categorie correspondant à l'id en paramètre
			
			ResultSetMetaData resultMeta = result.getMetaData();
			result.next();

			try {
				dateCommande = new SimpleDateFormat("dd/MM/yyyy").parse(result.getObject(2).toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.ID = ID; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void saveCategorie()
	{
		DataBaseManager connex = new DataBaseManager(); // se co à la bdd
		ResultSet result;
		Connection bdd = connex.connectBDD(); 
		Statement state;
		int idComm;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Commande");
			result.next();

			idComm = Integer.valueOf((String) result.getObject(1));
			
			if (idComm == ID)
			{
				state.executeUpdate("Update Commande SET dateCommande = '" + dateCommande + "' WHERE idCommande LIKE '" + ID);
			}
			else
			{
				this.ID = state.executeUpdate("insert into Commande(dateCommande) values(" + dateCommande + ")", Statement.RETURN_GENERATED_KEYS);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getID() 
	{
		return ID;
	}
	public void setID(int iD)
	{
		ID = iD;
	}
	public Date getDateCommande() 
	{
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) 
	{
		this.dateCommande = dateCommande;
	}
}
