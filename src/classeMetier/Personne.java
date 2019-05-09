package classeMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import tool.DataBaseManager;

public class Personne {
	
	private int _idClient;
	private int _nbTapasRest = 5;
	private String _couleur;
	private String _pseudo;
	private int _idGroupe;
	
	public int get_idClient() {
		return _idClient;
	}

	public String get_pseudo() {
		return _pseudo;
	}

	public void set_pseudo(String _pseudo) {
		this._pseudo = _pseudo;
	}

	public void savePersonne()
	{
		Statement state;
		long key = -1L;
		try {

			state = DataBaseManager.connectBDD().createStatement();
			System.out.println("insert into client(pseudo, couleur, idGroupe) values ('" + _pseudo +"','"+ _couleur +"','"+ _idGroupe +"')");
			state.executeUpdate("insert into client(pseudo, couleur, idGroupe) values ('" + _pseudo +"','"+ _couleur +"','"+ _idGroupe +"')", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = state.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    key = rs.getLong(1);
			    _idClient = (int) key;
			}
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
	
	public Personne(String _couleur, String _pseudo, int _idGroupe)
	{
		this._nbTapasRest = 5;
		this._couleur = _couleur;
		this._pseudo = _pseudo;
		this._idGroupe = _idGroupe;
	}

}
