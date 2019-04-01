package libs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.Connexion;

public class Personne {
	
	
	private int _idClient;
	private int _nbTapasRest = 5;
	private String _couleur;
	private String _pseudo;
	private int _idGroupe;
	
	public void fillPersonne(int id)
	{
		
	}
	
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
	
	public Personne(int _idClient, String _couleur, String _pseudo, int _idGroupe)
	{
		this._idClient = _idClient;
		this._nbTapasRest = 5;
		this._couleur = _couleur;
		this._pseudo = _pseudo;
		this._idGroupe = _idGroupe;
	}
}
