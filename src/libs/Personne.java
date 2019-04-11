package libs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DataBaseManager;

public class Personne {
	
	private int _idClient;
	private int _nbTapasRest = 5;
	private String _couleur;
	private String _pseudo;
	private int _idGroupe;
	
	public void savePersonne()
	{
		Statement state;
		int resultat;
		try {

			state = DataBaseManager.connectBDD().createStatement();
<<<<<<< HEAD

			resultat = state.executeUpdate("insert into client(idclient, pseudo, couleur, idGroupe) values ('" + _idClient +"','" + _pseudo +"','"+ _couleur +"','"+ _idGroupe +"')");
=======
			resultat = state.executeUpdate("insert into client(idcligrp, pseudo, couleur, idGroupe) values ('" + _idClient +"','" + _pseudo +"','"+ _couleur +"','"+ _idGroupe +"')");
>>>>>>> refs/remotes/origin/master

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
