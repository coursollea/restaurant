package libs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import choixClient.VueCreationPersos;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.ModelChoixTapas;
import libs.GrosModel;

public class VueChoixTapas extends ScrollPane {
	
	private int j;
	private ModelChoixTapas modelChoixTapas;
	private VueCreationPersos vu;
	private GrosModel gmdl;
	public void init(ModelChoixTapas modelChoixTapas)
	{
		this.modelChoixTapas = modelChoixTapas;
	}
	
	public void start()
	{
		ArrayList<String> listegens = new ArrayList<String>();
		for (int k = 1 ; k <= GrosModel.getNbPerso() ; k++)
		{
			System.out.println(GrosModel.getNbPerso());
			Personne user = new Personne();
			listegens.add(user.getNomPers(k));
			System.out.println(user.getNomPers(k));
		}
		
		BorderPane container = new BorderPane();
		
		VBox casetapas = new VBox(2);
		
		VBox caseinfo = new VBox(2);
		
		ChoiceBox cb = new ChoiceBox();
		cb.setItems(FXCollections.observableArrayList(listegens));
		
		Text nbTapasrestant = new Text();
	    nbTapasrestant.setText("Tapas Restants : " + String.valueOf(modelChoixTapas.getNbTapasrestant()));
		
	    Text erreur = new Text();
	    erreur.setText("");
	    
	    BorderPane.setMargin(caseinfo, new Insets(20,20,20,20));
		
	    
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
	                System.out.println(butt.getText());
	                System.out.println(cb.getValue());
	                if (cb.getValue() != null)
	                {
	                	modelChoixTapas.setNbTapasrestant(modelChoixTapas.getNbTapasrestant() - 1);
		                nbTapasrestant.setText("Tapas Restants : " + String.valueOf(modelChoixTapas.getNbTapasrestant()));
	                }
	                else
	                {
	                	
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