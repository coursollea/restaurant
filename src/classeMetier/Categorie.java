package classeMetier;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DataBaseManager;

public class Categorie 
{
	private int ID;
	private String nom;

	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void fillCategorie(int ID)
	{
		
		ResultSet result; 
		DataBaseManager connex = new DataBaseManager(); // se co à la bdd
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Categorie Where Categorie.ID = " + ID); // récupérer les infos de la table Categorie correspondant à l'id en paramètre
			
			ResultSetMetaData resultMeta = result.getMetaData();
			result.next();

			nom = result.getObject(2).toString();
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
		int idCate;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Categorie");
			result.next();

			idCate = Integer.valueOf((String) result.getObject(1));
			if (idCate == ID)
			{
				state.executeUpdate("Update Categorie SET libelle = '" + nom + "' WHERE idCategorie LIKE '" + ID);
			}
			else
			{
				state.executeUpdate("insert into Categorie(libelle) values(" + nom + ")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
