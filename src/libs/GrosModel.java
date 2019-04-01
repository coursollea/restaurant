package libs;

import java.util.ArrayList;

public class GrosModel {
	
	private static int _nbPerso;
	private static int _numTable;
	private static ArrayList<String> listegens;
	
	public static ArrayList<String> getListegens() {
		return listegens;
	}

	public static ArrayList<String> setListeGens()
	{
		for (int k = 1 ; k <= _nbPerso ; k++)
		{
			System.out.println(_nbPerso);
			Personne user = new Personne();
			listegens.add(user.getNomPers(k));
			System.out.println(user.getNomPers(k));
		}
		return listegens;
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
