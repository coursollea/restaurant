package libs;

import java.sql.Connection;
import java.sql.SQLException;

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
import model.Model;


public class View extends ScrollPane {
	
	private int j;
	private Model model;
	
	public void init(Model model)
	{
		this.model = model;
	}
	
	public void start()
	{
		BorderPane container = new BorderPane();
		
		VBox casetapas = new VBox(2);
		
		VBox caseinfo = new VBox(2);
		
		ChoiceBox cb = new ChoiceBox();
		cb.setItems(FXCollections.observableArrayList("Rouge", "Bleu", "Vert", "Jaune"));
		
		Text nbTapasrestant = new Text();
	    nbTapasrestant.setText("Tapas Restants : " + String.valueOf(model.getNbTapasrestant()));
		
	    Text erreur = new Text();
	    erreur.setText("");
	    
	    BorderPane.setMargin(caseinfo, new Insets(20,20,20,20));
		
	    
		for(j = 1 ; j < model.getNbTapastotal() + 1 ; j++)
		{
			Text ligne = new Text();
			ligne.setText("__________________________________________");
			
			HBox tapas = new HBox();
			
			Text nomTapas = new Text();
			nomTapas.setText(model.getNomTapas(j));
			
			
			
			Button butt = new Button();
			butt.setText(String.valueOf(j));
			butt.setOnAction(new EventHandler<ActionEvent>() 
			{
	            public void handle(ActionEvent event) {
	                System.out.println(butt.getText());
	                System.out.println(cb.getValue());
	                if (cb.getValue() != null)
	                {
	                	model.setNbTapasrestant(model.getNbTapasrestant() - 1);
		                nbTapasrestant.setText("Tapas Restants : " + String.valueOf(model.getNbTapasrestant()));
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