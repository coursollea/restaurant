package classeMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DataBaseManager;

public class Choix_Client {
	
	private static int idchoix;
	private static int idcommande;
	private static int idclient;
	private static int idtapas;
	
	public static void fillChoix(int idChoix, int idCommande, int Client, int Tapas)
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

			int tapas = Integer.valueOf((String) result.getObject(2));
			int client = Integer.valueOf((String) result.getObject(3));
			int commande = Integer.valueOf((String) result.getObject(4));
			
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
		ResultSet result;
		Connection bdd = connex.connectBDD(); 
		Statement state;
		int idChoix;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Choix_Client");
			result.next();

			idChoix = Integer.valueOf((String) result.getObject(1));
			if (idChoix == idchoix)
			{
				state.executeUpdate("Update Choix_Client SET idCommande = '" + idcommande + "' , idClient = '" + idclient + "' idTapas = '" + idtapas + "' WHERE idChoix LIKE '" + idchoix);
			}
			else
			{
				idchoix = state.executeUpdate("insert into Choix_Client(idCommande, idClient, idTapas) values('" + idcommande + "' , '" + idclient + "' , '" + idtapas + "')", Statement.RETURN_GENERATED_KEYS);
				System.out.println(idchoix);
			}
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
