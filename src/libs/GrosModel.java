package libs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tool.Connexion;

public class GrosModel {
	
	private static int _nbPerso;
	private static int _numTable;
	private static ArrayList<Personne> listegens = new ArrayList<Personne>();
	
	public static ArrayList<Personne> getListegens() {
		return listegens;
	}
	
	public static Personne getPersonneById(int idCli)
	{
		return listegens.get(idCli);
	}
	
	public static void addPersonne(Personne perso)
	{
		listegens.add(perso);
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
