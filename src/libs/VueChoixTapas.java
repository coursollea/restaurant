package libs;

import choixClient.VueCreationPersos;
import classeMetier.Choix_Client;
import classeMetier.Commande;
import classeMetier.Tapas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.ModelChoixTapas;
import libs.GrosModel;

public class VueChoixTapas extends ScrollPane {
	
	private int j;
	private Personne actuel;
	private ModelChoixTapas modelChoixTapas;
	private VueCreationPersos vu;
	private GrosModel gmdl;
	
	public void init(ModelChoixTapas modelChoixTapas)
	{
		this.modelChoixTapas = modelChoixTapas;
	}
	
	public void start()
	{
		BorderPane container = new BorderPane();
		
		VBox casetapas = new VBox(2);
		
		VBox caseinfo = new VBox(2);
		
		ChoiceBox cb = new ChoiceBox();
		cb.setItems(FXCollections.observableArrayList(gmdl.getListegens()));
		
		Text nbTapasrestant = new Text();
	    nbTapasrestant.setText("Tapas Restants : " + String.valueOf(modelChoixTapas.getNbTapasrestant()));
		
	    Text erreur = new Text();
	    erreur.setText("");
	    
	    BorderPane.setMargin(caseinfo, new Insets(20,20,20,20));
		
	    Commande.setDateCommande();
	    Commande.saveCommande();
	    
		for(j = 1 ; j < modelChoixTapas.getNbTapastotal() + 1 ; j++)
		{
			Text ligne = new Text();
			ligne.setText("__________________________________________");
			
			HBox tapas = new HBox();
			
			Text nomTapas = new Text();
			nomTapas.setText(modelChoixTapas.getNomTapas(j));
			
			Button butt = new Button();
			butt.setText(String.valueOf(j));
			butt.setOnAction(new EventHandler<ActionEvent>() 
			{
	            public void handle(ActionEvent event) {
	                
	                if (cb.getValue() != null)
	                {
	                	Personne current = (Personne) cb.getValue();
	                	if(current.getNbTapasRest() > 0)
	                	{
	                		System.out.println("idTapas choisi : " + butt.getText());
	    	                System.out.println("currentPersonne : " + cb.getValue());
		                	System.out.println("nbTapas restant : " + current.getNbTapasRest());
		                	
		                	current.setNbTapasRest(current.getNbTapasRest() - 1);
			                nbTapasrestant.setText("Tapas Restants : " + String.valueOf(current.getNbTapasRest()));
			                
			                Tapas.fillTapas(Integer.valueOf(butt.getText()));
			                Choix_Client choixcli = new Choix_Client(Commande.getID(), current.get_idClient(), Integer.valueOf(butt.getText()));
			                Choix_Client.saveChoix();
	                	}
	                	else
	                	{
	                		System.out.println("Il ne reste plus de tapas pour " + cb.getValue());
	                	}
	                }
	            }
	        });
			
			HBox.setMargin(butt, new Insets(1,0,1,10));
			tapas.getChildren().add(nomTapas);
			tapas.getChildren().add(butt);
			
			casetapas.getChildren().add(ligne);
			casetapas.getChildren().add(tapas);
			
		}


	    caseinfo.getChildren().add(cb);
	    caseinfo.getChildren().add(nbTapasrestant);
	    
		container.setLeft(caseinfo);
		container.setRight(casetapas);
		this.setContent(container);
		
	}
}