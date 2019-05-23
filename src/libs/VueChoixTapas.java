package libs;

import java.io.InputStream;

import choixClient.VueCreationPersos;
import classeMetier.Choix_Client;
import classeMetier.Commande;
import classeMetier.Personne;
import classeMetier.Tapas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Text nbTapasrestant;
   
	
	public void init(ModelChoixTapas modelChoixTapas)
	{
		this.modelChoixTapas = modelChoixTapas;
	}
	
	public void start()
	{
		
		nbTapasrestant = new Text();
		
		BorderPane container = new BorderPane();
		container.setStyle("-fx-background-image: url('image/tapasCommande_modif.jpg')");
		container.setPrefWidth(638);
		container.setPrefHeight(398);
		VBox casetapas = new VBox(2);
		
		VBox caseinfo = new VBox(2);
		
		ChoiceBox cb = new ChoiceBox();
		cb.setItems(FXCollections.observableArrayList(gmdl.getListegens()));
		
		ChangeListener<Personne> changeListener = new ChangeListener<Personne>() {
			 
            @Override
            public void changed(ObservableValue<? extends Personne> observable, //
                    Personne oldValue, Personne newValue) {
                if (newValue != null) {
                	Personne current = (Personne) cb.getValue();
                	nbTapasrestant.setText("Tapas Restants : " + String.valueOf(current.getNbTapasRest()));
                }
            }
        };
        
        cb.getSelectionModel().selectedItemProperty().addListener(changeListener);
		
	    Text erreur = new Text();
	    erreur.setText("");
	    
	    BorderPane.setMargin(caseinfo, new Insets(20,20,20,20));
		
	    Commande.setDateCommande();
	    Commande.saveCommande();
	    
		for(j = 1 ; j < modelChoixTapas.getNbTapastotal() + 1 ; j++)
		{
			Text ligne = new Text();
			ligne.setText("______________________________________________________________________");
			TapasBox boite = new TapasBox();
			
			HBox lignetapas = new HBox();
			
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
		                	current.setNbTapasRest(current.getNbTapasRest() - 1);
			                nbTapasrestant.setText("Tapas Restants : " + String.valueOf(current.getNbTapasRest()));
			                for (int cpt = 1 ; cpt < 5 ; cpt++) {
			                	int cptlongcb = 0;
			                	if((cb.getItems().size()) == cpt) {
				               		if (cpt >= 1) {
				               			if (cb.getValue() == gmdl.getListegens().get(0)) {
						                	TapasBox.set_nbClickpers1(TapasBox.get_nbClickpers1() + 1);
						                	System.out.println(TapasBox.get_nbClickpers1());
						                }
				               		}
				               		
				               		if (cpt >= 2) {
				               			if (cb.getValue() == gmdl.getListegens().get(1)) {
						                	TapasBox.set_nbClickpers2(TapasBox.get_nbClickpers2() + 1);
						                	System.out.println(TapasBox.get_nbClickpers2());
						                }
				               		}
				               		
				               		if (cpt >= 3) {
				               			if (cb.getValue() == gmdl.getListegens().get(2)) {
						                	TapasBox.set_nbClickpers3(TapasBox.get_nbClickpers3() + 1);
						                	System.out.println(TapasBox.get_nbClickpers3());
						                }
				               		}
				               		
				               		if (cpt >= 4) {
				               			if (cb.getValue() == gmdl.getListegens().get(3)) {
						                	TapasBox.set_nbClickpers4(TapasBox.get_nbClickpers4() + 1);
						                	System.out.println(TapasBox.get_nbClickpers4());
						                }
				               		}
				               	}
			                }
			               	
			                Tapas.fillTapas(Integer.valueOf(butt.getText()));
			                Choix_Client choixcli = new Choix_Client(Commande.getID(), current.get_idClient(), Integer.valueOf(butt.getText()));
			                Choix_Client.saveChoix();
	                	}
	                	else
	                	{
	                		System.out.println("Stop! Va manger tes tapas " + cb.getValue());
	                	}
	                }
	            }
	        });
			
		
			
			HBox.setMargin(butt, new Insets(1,0,1,10));
			tapas.getChildren().add(nomTapas);
			tapas.getChildren().add(butt);
			
			lignetapas.getChildren().add(tapas);
			
			boite.start();
			lignetapas.getChildren().add(boite);
					
			casetapas.getChildren().add(ligne);
			casetapas.getChildren().add(lignetapas);
		}
		
		Button boutton = new Button("Recommander"); 
		boutton.setOnAction(new EventHandler<ActionEvent>() 
		{
            public void handle(ActionEvent event) {
            	Choix_Client deleteChoixClient = new Choix_Client(Commande.getID(), current.get_idClient(), Integer.valueOf(boutton.getText()));
            }
		});
                

		
	    caseinfo.getChildren().add(cb);
	    caseinfo.getChildren().add(nbTapasrestant);
	    caseinfo.getChildren().add(boutton);
		container.setLeft(caseinfo);
		container.setCenter(casetapas);
		this.setContent(container);
		
		
	}
}