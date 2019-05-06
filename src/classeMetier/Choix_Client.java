package classeMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import tool.DataBaseManager;

public class Choix_Client {
	
	private static int idchoix;
	private static int idcommande;
	private static int idclient;
	private static int idtapas;
	
	public Choix_Client(int idCommande, int idClient, int idTapas) {
		idcommande = idCommande;
		idclient = idClient;
		idtapas = idTapas;
	}
	
	public static void fillChoix(int idChoix)
	{
		ResultSet result; 
		DataBaseManager connex = new DataBaseManager();
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Choix_Client WHERE idChoix LIKE '"+ idChoix + "'");
			
			ResultSetMetaData resultMeta = result.getMetaData();
			result.next();

			int tapas = result.getInt("idTapas");
			int client = result.getInt("idClient");
			int commande = result.getInt("idCommande");
			
			idtapas = tapas;
			idclient = client;
			idcommande = commande;
			idchoix = idChoix; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void saveChoix()
	{
		DataBaseManager connex = new DataBaseManager();
		Connection bdd = connex.connectBDD(); 
		Statement state;
		long key = -1L;
		try {
			state = bdd.createStatement();
			System.out.println("insert into Choix_Client(idCommande, idClient, idTapas) values('" + idcommande + "' , '" + idclient + "' , '" + idtapas + "')");
			state.executeUpdate("insert into Choix_Client(idCommande, idClient, idTapas) values('" + idcommande + "' , '" + idclient + "' , '" + idtapas + "')", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = state.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    key = rs.getLong(1);
			    idchoix = (int) key;
			}
			
			System.out.println("id choix : " + idchoix);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getIdChoix() {
		return idchoix;
	}
	public void setIdChoix(int idChoix) {
		idchoix = idChoix;
	}
	
	public int getIdCommande() {
		return idcommande;
	}
	public void setIdCommande(int idCommande) {
		idcommande = idCommande;
	}
	
	public int getClient() {
		return idclient;
	}
	public void setClient(int client) {
		idclient = client;
	}
	
	public int getTapas() {
		return idtapas;
	}
	public void setTapas(int tapas) {
		idtapas = tapas;
	}
	
	
}
