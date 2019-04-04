package libs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tool.DataBaseManager;

public class GrosModel {
	
	private static int _nbPerso;
	private static int _numTable;
	private static ArrayList<String> listegens;
	
	public static ArrayList<String> getListegens() {
		return listegens;
	}

	public static ArrayList<String> setListeGens(int idgrp)
	{
		Statement state;
		ResultSet resultat;
		try {
			state = DataBaseManager.connectBDD().createStatement();
			resultat = state.executeQuery("SELECT * FROM Client WHERE idGroupe LIKE " + idgrp);
			ResultSetMetaData resultMeta = resultat.getMetaData();
			for (int k = 1 ; k <= _nbPerso ; k++)
			{
				System.out.println(_nbPerso);
				//Personne user = new Personne();
				
				listegens.add(resultat.getObject(2).toString());
				resultat.next();
				System.out.println("Personnage " + resultat.getObject(3).toString() + " " + resultat.getObject(2).toString() + " Créé à la table " + resultat.getObject(4).toString());
				
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listegens;
	}
	
	
	public static int getNumTable() {
		return _numTable;
	}

	public static void setNumTable(int numTable) {
		_numTable = numTable;
	}

	public static int getNbPerso() {
		return _nbPerso;
	}

	public static void setNbPerso(int nbPerso) {
		_nbPerso = nbPerso;
	}
}
