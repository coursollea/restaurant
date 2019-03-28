package choixClient;



import changeWindows.ChangerWindows;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import libs.View;
import libs.GrosModel;

public class Vue extends VBox
{
	private VBox panelClient; 
	private final Spinner<Integer> spinner = new Spinner<Integer>(); 
	private int oldSpinnerValue; 
	VBox vuePrincipale = new VBox(); 
	private Modele mdl; 
	private View view; 

	public Vue()
    {
    	mdl = new Modele();
    	view = new View(); 
    	
        Label label = new Label("Selectionner le nombre de personnes:");
        label.setStyle("-fx-background-color: white"); 
        //final Spinner<Integer> spinner = new Spinner<Integer>();
 
        final int initialValue = 1;
 
        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, initialValue);
        spinner.setValueFactory(valueFactory);
        oldSpinnerValue = spinner.getValue();
        
        GrosModel.setNbPerso(spinner.getValue());
        
        spinner.valueProperty().addListener(
        		(obs, oldValue, newValue) -> 
        		manageClient());
        this.getChildren().add(label); 
        this.getChildren().add(spinner);
 
        
        panelClient = new VBox(); 
        this.getChildren().add(panelClient); 
        //change la dimension de la page
        this.setPrefSize(640, 400);
        
        addBox();
        //changer l'arrière plan de la fenêtre de javafx
        this.setStyle("-fx-background-image: url(\"image/tapas.jpg\")");
        
        Button button = new Button("Valider"); 
        EventHandler<MouseEvent> monEvent = new EventHandler<MouseEvent>()
        {
	        @Override 
	        public void handle(MouseEvent e)
	        { 
	        	 for (int i = 0; i < panelClient.getChildren().size(); i++ )
	        	 {
		        	HBox hbox = (HBox) panelClient.getChildren().get(i); 
		        	TextField pseudo = (TextField) hbox.getChildren().get(0); 
		        	System.out.println(pseudo.getText());
		        	ColorPicker color = (ColorPicker) hbox.getChildren().get(1); 
		        	String hex1 = Integer.toHexString(color.getValue().hashCode()); 
		        	System.out.println(hex1);
		        	
		        	mdl.addClient(pseudo.getText(), hex1);
		        	
	        	 }
	        	 ChangerWindows.changeWindows("libs");
        
	        } 
        }; 
        
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, monEvent);
        
       
        this.getChildren().add(button); 
 
    }
   
    
    
    
    
    public void manageClient()
    {
    	int newValue = spinner.getValue();
    	
    	if (newValue > oldSpinnerValue)
    	{
    		addBox();
    	}
    	else
    	{
    		panelClient.getChildren().remove(panelClient.getChildren().size() -1);
    	}
    	
    	oldSpinnerValue = newValue;
    	
    }
    
    private void addBox() 
    {
    	HBox newClient = new HBox(); 
		TextField pseudoClient = new TextField(); 
		ColorPicker color = new ColorPicker();  
		newClient.getChildren().add(pseudoClient); 
		newClient.getChildren().add(color); 
		panelClient.getChildren().add(newClient); 
    }
    
    
}
