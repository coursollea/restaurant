package model;

import java.util.ArrayList;
import java.util.Collections;
import libs.View;

public class Model {
	
	private int nbPersonnes;
	private int nbTapasMax;
	private int nbTapas;
	private View vue;
	
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	
	public int getNbTapas() {
		return nbTapas;
	}
	public void setTapas(int nbTapas) {
		this.nbTapas = nbTapas;
	}
	
	public void init(View vue)
	{
		this.vue = vue;
	}
	
	public void start()
	{
		
	}
}
