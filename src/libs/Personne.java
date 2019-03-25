package libs;
import model.Model;


public class Personne {
	
	private int nbTapasRest = 5;
	private String couleur;
	private String pseudo;
	
	public int getNbTapasRest() {
		return nbTapasRest;
	}

	public void setNbTapasRest(int nbTapasMax) {
		this.nbTapasRest = nbTapasMax;
	}
	
	public void assign(String couleurPersonne, String pseudoPersonne)
	{
		nbTapasRest = 5;
	}
}
