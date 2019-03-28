package libs;
import model.Model;


public class Personne {
	
	

	private int _nbTapasRest = 5;
	private String _couleur;
	private String _pseudo;
	private int _idGroupe;
	
	public Personne(String _couleur, String _pseudo, int idGroupe) {
		
		this._nbTapasRest = _nbTapasRest;
		this._couleur = _couleur;
		this._pseudo = _pseudo;
		this._idGroupe = _idGroupe;
	}
	
	public int getNbTapasRest() {
		return _nbTapasRest;
	}

	public void setNbTapasRest(int nbTapasMax) {
		this._nbTapasRest = nbTapasMax;
	}
	
	public void assign(String couleurPersonne, String pseudoPersonne)
	{
		_nbTapasRest = 5;
	}
	
}
