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
import libs.VueChoixTapas;
import libs.GrosModel;

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
    	
        Label label = new Label("   Selectionner le nombre de personnes : ");
        label.setStyle("-fx-background-color: white"); 
        Label labelTable = new Label("   Selectionner le numero de la table : ");
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
        //changer l'arri�re plan de la fen�tre de javafx
        this.setStyle("-fx-background-image: url(\"image/tapas.jpg\")");
        
        Button button = new Button("Valider"); 
        EventHandler<MouseEvent> monEvent = new EventHandler<MouseEvent>()
        {
	        @Override 
	        public void handle(MouseEvent e)
	        {
	        	newTableSpinnerValue = spinnerTable.getValue();
	        	GrosModel.setNumTable(newTableSpinnerValue);
	        	
	        	 for (int i = 0; i < panelClient.getChildren().size(); i++ )
	        	 {
		        	HBox hbox = (HBox) panelClient.getChildren().get(i); 
		        	TextField pseudo = (TextField) hbox.getChildren().get(0);
		        	ColorPicker color = (ColorPicker) hbox.getChildren().get(1); 
		        	String hex1 = Integer.toHexString(color.getValue().hashCode());
		        	
		        	mdl.addClient(pseudo.getText(), hex1, newTableSpinnerValue);
		        	
	        	 }
	        	 
	        	 GrosModel.setNbPerso(newSpinnerValue);
	        	 gmdl.setListeGens(newTableSpinnerValue);
	        	 
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
