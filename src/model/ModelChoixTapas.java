package model;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import libs.GrosModel;
import libs.VueChoixTapas;
import tool.DataBaseManager;

public class ModelChoixTapas {
	
	private int nbPersonnes;
	private int nbTapasrestant = 5;
	private int nbTapastotal;
	private VueChoixTapas vue;
	
	public String getNomTapas(int n)
	{
		Statement state;
		ResultSet resultat;
		try {
			state = DataBaseManager.connectBDD().createStatement();
			resultat = state.executeQuery("SELECT nom FROM Tapas WHERE idTapas LIKE " + n);
			ResultSetMetaData resultMeta = resultat.getMetaData();
			resultat.next();
			
			return resultat.getObject(1).toString();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	
	public int getNbTapastotal()
	{
		Statement state;
		int i = 0;
		try {
			state = DataBaseManager.connectBDD().createStatement(); 
			ResultSet resultat;
			try {
				resultat = state.executeQuery("SELECT * FROM Tapas");
				ResultSetMetaData resultMeta = resultat.getMetaData();
				while(resultat.next())
				{
					i++;
				}
				return i;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getNbTapasrestant() {
		return nbTapasrestant;
	}

	public void init(VueChoixTapas vue)
	{
		this.vue = vue;
	}
}
