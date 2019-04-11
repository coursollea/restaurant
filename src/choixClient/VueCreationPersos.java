package choixClient;



import changeWindows.ChangerWindows;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import libs.VueChoixTapas;
import libs.GrosModel;
import libs.Personne;

public class VueCreationPersos extends VBox
{
	private VBox panelClient; 
	private Spinner<Integer> spinner = new Spinner<Integer>(); 
	private Spinner<Integer> spinnerTable = new Spinner<Integer>();
	
	private int oldSpinnerValue;
	private int newSpinnerValue;
	
	private int oldTableSpinnerValue;
	private int newTableSpinnerValue;
	
	VBox vuePrincipale = new VBox(); 
	private ModelCreationPersos mdl; 
	private VueChoixTapas vueChoixTapas; 
	private GrosModel gmdl;
	private int initialValue = 1;
	
    
	public VueCreationPersos()
    {
    	mdl = new ModelCreationPersos();
    	vueChoixTapas = new VueChoixTapas(); 
    	
        Label label = new Label("Selectionner le nombre de personnes : ");
        label.setStyle("-fx-background-color: white"); 
        Label labelTable = new Label("Selectionner le numero de la table : ");
        labelTable.setStyle("-fx-background-color: white"); 
        //final Spinner<Integer> spinner = new Spinner<Integer>();
 
        final int initialValue = 1;
 
        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, initialValue);

        SpinnerValueFactory<Integer> valueFactoryTable = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, initialValue);
        
        spinner.setValueFactory(valueFactory);
        spinnerTable.setValueFactory(valueFactoryTable);
        
        oldTableSpinnerValue = spinner.getValue();
        newTableSpinnerValue = spinner.getValue();
        
        oldSpinnerValue = spinner.getValue();
        newSpinnerValue = spinner.getValue();
        
        spinner.valueProperty().addListener(
        		(obs, oldValue, newValue) -> 
        		manageClient());
        this.getChildren().add(label); 
        this.getChildren().add(spinner);
        this.getChildren().add(labelTable); 
        this.getChildren().add(spinnerTable);
 
        
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
	        	Color red = Color.RED; 
	        	Color blue = Color.BLUE; 
	        	Color yellow = Color.YELLOW; 
	        	Color green = Color.GREEN; 
	        	
	        	newTableSpinnerValue = spinnerTable.getValue();
	        	GrosModel.setNumTable(newTableSpinnerValue);
	        	
	        	for (int i = 1; i < panelClient.getChildren().size()+1; i++ )
	        	{
	        		HBox hbox = (HBox) panelClient.getChildren().get(i); 
		        	TextField pseudo = (TextField) hbox.getChildren().get(0);
		        	String hex = new String(); 
		        	if (i == 0)
		        	{
		        		hex = "#" + Integer.toHexString(Color.RED.hashCode());
		        	}
		        	else if (i == 1)
		        	{
		        		hex = "#" + Integer.toHexString(Color.BLUE.hashCode());
		        	}
		        	else if (i == 2)
		        	{
		        		hex = "#" + Integer.toHexString(Color.YELLOW.hashCode());
		        	}
		        	else if (i == 3)
		        	{
		        		hex = "#" + Integer.toHexString(Color.GREEN.hashCode());
		        	}
		        	
		        	
		        	mdl.addClient(i, pseudo.getText(), hex, newTableSpinnerValue);
	        	}
	        	 
	        	 GrosModel.setNbPerso(newSpinnerValue);
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
		Rectangle color = new Rectangle();
		color.setHeight(25); 
		color.setWidth(25);
		switch (spinner.getValue())
		{
			case 1:
				color.setFill(Color.RED);
				break;
			case 2:
				color.setFill(Color.BLUE);
				break;
			case 3:
				color.setFill(Color.YELLOW);
				break;
			case 4:
				color.setFill(Color.GREEN);
				break;
		}
		newClient.getChildren().add(pseudoClient); 
		newClient.getChildren().add(color);
		panelClient.getChildren().add(newClient); 
    }
    
     
}
