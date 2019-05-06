package classeMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DataBaseManager;

public class GroupeTable 
{
	private static int ID;
	private static int numeroTable; 

	
	public static void fillChoix(int idGroupe)
	{
		ResultSet result; 
		DataBaseManager connex = new DataBaseManager();
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Groupe WHERE idGroupe LIKE '"+ idGroupe + "'");
			
			ResultSetMetaData resultMeta = result.getMetaData();
			result.next();

			int numerotable = result.getInt("numeroTable");
					//Integer.valueOf((String) result.getObject(1));
			
			ID = idGroupe;
			numeroTable = numerotable;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static int saveChoix(int numTab)
	{
		numeroTable = numTab;
		DataBaseManager connex = new DataBaseManager();
		ResultSet result;
		Connection bdd = connex.connectBDD(); 
		Statement state;
		try {
			state = bdd.createStatement();
			result = state.executeQuery("Select * From Groupe");
			result.next();

			ID = state.executeUpdate("insert into Groupe(numeroTable) values('" + numeroTable + "')", Statement.RETURN_GENERATED_KEYS);
			return ID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
		
	}
}
