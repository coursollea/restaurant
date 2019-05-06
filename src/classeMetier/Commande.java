package classeMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import tool.DataBaseManager;

public class Commande 
{

	private static int ID; 
	private static String dateCommande;
	
	public void fillCommande(int ID)
	{
		
		ResultSet result; 
		DataBaseManager connex = new DataBaseManager(); // se co à la bdd
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Commande Where Commande.ID = " + ID); // récupérer les infos de la table Categorie correspondant à l'id en paramètre
			
			ResultSetMetaData resultMeta = result.getMetaData();
			result.next();

			this.dateCommande = result.getObject(2).toString();
			this.ID = ID; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void saveCommande()
	{
		DataBaseManager connex = new DataBaseManager();
		ResultSet result;
		Connection bdd = connex.connectBDD(); 
		Statement state;
		long key = -1L;
		int idComm;
		try {
			state = bdd.createStatement();
			state.executeUpdate("insert into Commande(dateCommande) values('" + dateCommande + "')", PreparedStatement.RETURN_GENERATED_KEYS);

			ResultSet rs = state.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    key = rs.getLong(1);
			    ID = (int) key;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getID() 
	{
		return ID;
	}
	
	public void setID(int iD)
	{
		ID = iD;
	}
	
	public String getDateCommande() 
	{
		return dateCommande;
	}
	
	public static void setDateCommande() 
	{
		dateCommande = GetCurrentDateTime();
	}

	private static String GetCurrentDateTime()
	{
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    String la_date = dateFormat.format(cal.getTime());
		return la_date;
	}
}
