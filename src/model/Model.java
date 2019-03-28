package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import libs.View;

public class Model {
	
	private int nbPersonnes;
	private int nbTapasrestant = 5;
	private int nbTapastotal;
	private View vue;
	private Connection connex = connectBDD();
	
	
	public Connection connectBDD()
	{
		try 
		{
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/BaseTapas?autoReconnect=true&useSSL=false", "root", "");
			
			return connex; 
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	
	public String getNomPers(int n)
	{
		Statement state;
		ResultSet resultat;
		try {
			state = connex.createStatement();
			
			resultat = state.executeQuery("SELECT pseudo FROM Client WHERE idClient = " + n + " AND idGroupe = " + 1);
			System.out.println("SELECT pseudo FROM Client WHERE idClient LIKE " + n);
			
			ResultSetMetaData resultMeta = resultat.getMetaData();
			resultat.next();
			  
			return String.valueOf(resultat.getObject(0));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getNomTapas(int n)
	{
		Statement state;
		ResultSet resultat;
		try {
			state = connex.createStatement();
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
			state = connex.createStatement(); 
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
