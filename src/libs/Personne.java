package libs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.Connexion;

public class Personne {
	
	
	private int idClient;
	private int _nbTapasRest = 5;
	private String _couleur;
	private String _pseudo;
	private int _idGroupe;
	
	
	public int getNbTapasRest() {
		return _nbTapasRest;
	}

	public void setNbTapasRest(int nbTapasMax) {
		this._nbTapasRest = nbTapasMax;
	}
	
	public String getNomPers(int idPersonne)
	{
		Statement state;
		ResultSet resultat;
		try {
			state = Connexion.connectBDD().createStatement();
			
			resultat = state.executeQuery("SELECT pseudo FROM Client WHERE idClient = " + idPersonne + " AND idGroupe = " + 1);
			System.out.println("Requète : ");
			System.out.println("SELECT pseudo FROM Client WHERE idClient LIKE " + idPersonne + " AND idGroupe = " + 1);
			
			ResultSetMetaData resultMeta = resultat.getMetaData();
			resultat.next();
			System.out.println(String.valueOf(resultat.getObject(idPersonne)));
			
			return String.valueOf(resultat.getObject(idPersonne));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setInfosPers(String couleur, String pseudo, int idGroupe)
	{
		_nbTapasRest = 5;
		_couleur = couleur;
		_pseudo = pseudo;
		_idGroupe = idGroupe;
	}
}
