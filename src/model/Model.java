package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Tools.BDD;
import libs.View;

public class Model {
	
	private int nbPersonnes;
	private int nbTapasrestant = 5;
	private int nbTapastotal;
	private View vue;
	
	public String getNomTapas(int n)
	{
		Statement state;
		try {
			state = BDD.cobdd().createStatement();
			ResultSet resultat;
			try {
				resultat = state.executeQuery("SELECT nom FROM Tapas WHERE idTapas LIKE " + n);
				ResultSetMetaData resultMeta = resultat.getMetaData();
				resultat.next();
				  
				return resultat.getObject(1).toString();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
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
			state = BDD.cobdd().createStatement();
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

	public void setNbTapasrestant(int nbTapasrestant) {
		this.nbTapasrestant = nbTapasrestant;
	}
	
	public void init(View vue)
	{
		this.vue = vue;
	}
}
