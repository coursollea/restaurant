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
		DataBaseManager connex = new DataBaseManager(); // se co � la bdd
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select*From Categorie Where Categorie.ID = " + ID); // r�cup�rer les infos de la table Categorie correspondant � l'id en param�tre
			
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
		DataBaseManager connex = new DataBaseManager(); // se co � la bdd
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			if (ID == 0)
			{
				state.executeUpdate("insert into Categorie(nom) values(" + nom + ")"); 
			}
			else
			{
				state.executeUpdate("Update Categorie SET nom = " + nom + ""); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// co
		// si l'id = 0 insert les valeurs des attributs dans les champs de la table
		// sinon update
		
	}
	
}
