package libs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DataBaseManager;

public class Personne {
	
	private int _idClient;
	public int get_idClient() {
		return _idClient;
	}

	public void set_idClient(int _idClient) {
		this._idClient = _idClient;
	}

	public String get_pseudo() {
		return _pseudo;
	}

	public void set_pseudo(String _pseudo) {
		this._pseudo = _pseudo;
	}

	private int _nbTapasRest = 5;
	private String _couleur;
	private String _pseudo;
	private int _idGroupe;
	
	public void savePersonne()
	{
		Statement state;
		try {

			state = DataBaseManager.connectBDD().createStatement();
			state.executeUpdate("insert into client(idClientGroupe, pseudo, couleur, idGroupe) values ('" + _idClient +"','" + _pseudo +"','"+ _couleur +"','"+ _idGroupe +"')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString()
	{
		return _pseudo;
	}
	
	public int getNbTapasRest() { 
		return _nbTapasRest;
	}

	public void setNbTapasRest(int nbTapasMax) {
		this._nbTapasRest = nbTapasMax;
	}
	
	public Personne(int idClient, String _couleur, String _pseudo, int _idGroupe)
	{
		this._idClient = idClient;
		this._nbTapasRest = 5;
		this._couleur = _couleur;
		this._pseudo = _pseudo;
		this._idGroupe = _idGroupe;
	}

}
