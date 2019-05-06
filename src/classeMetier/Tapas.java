package classeMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DataBaseManager;

public class Tapas
{

	private static int ID;
	private static String nom;
	
	public static void fillTapas(int IDey)
	{
		
		ResultSet result; 
		DataBaseManager connex = new DataBaseManager(); // se co � la bdd
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Tapas Where Tapas.idTapas = " + IDey); // r�cup�rer les infos de la table Categorie correspondant � l'id en param�tre
			
			ResultSetMetaData resultMeta = result.getMetaData();
			result.next();

			nom = result.getObject(2).toString();
			ID = IDey; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void saveTapas()
	{
		DataBaseManager connex = new DataBaseManager(); // se co � la bdd
		ResultSet result;
		Connection bdd = connex.connectBDD(); 
		Statement state;
		int idTapas;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Tapas");
			result.next();

			idTapas = Integer.valueOf((String) result.getObject(1));
			if (idTapas == ID)
			{
				state.executeUpdate("Update Tapas SET nom = '" + nom + "' WHERE idTapas LIKE '" + ID);
			}
			else
			{
				state.executeUpdate("insert into Tapas(nom) values(" + nom + ")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
	
	
}
