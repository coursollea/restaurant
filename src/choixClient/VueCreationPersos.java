package choixClient;



import changeWindows.ChangerWindows;
import classeMetier.GroupeTable;
import classeMetier.Personne;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import libs.VueChoixTapas;
import libs.GrosModel;

public class VueCreationPersos extends VBox
{
	private VBox panelClient;
	private Spinner<Integer> spinner = new Spinner<Integer>(); 
	private Spinner<Integer> spinnerTable = new Spinner<Integer>();
	private VBox container;
	
	private int oldSpinnerValue;
	private int newSpinnerValue;
	
	private int oldTableSpinnerValue;
	private int newTableSpinnerValue;
	
	VBox vuePrincipale = new VBox(); 
	private ModelCreationPersos mdl; 
	private VueChoixTapas vueChoixTapas; 
	private GrosModel gmdl;
	private int initialValue = 1;
	
	private int groupverif = 0;
	
    
	public VueCreationPersos()
    {
		this.setStyle("-fx-background-image: url(\"image/tapas.jpg\")");
		this.setAlignment(Pos.CENTER);
		
    	mdl = new ModelCreationPersos();
    	vueChoixTapas = new VueChoixTapas(); 
    	
    	container = new VBox();
    	container.setMaxSize(230, 150);
    	container.setStyle("-fx-background-color: #FFF");
    	container.setAlignment(Pos.CENTER);
    	
    	
        Label label = new Label("Selectionner le nombre de personnes : ");
        label.setTextFill(Color.RED);
        VBox.setMargin(label, new Insets (5));
        Label labelTable = new Label("Selectionner le numero de la table : ");
        labelTable.setStyle("-fx-color: blue"); 
        //final Spinner<Integer> spinner = new Spinner<Integer>();
        VBox.setMargin(labelTable, new Insets(5));
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
        container.getChildren().add(label); 
        container.getChildren().add(spinner);
        container.getChildren().add(labelTable); 
        container.getChildren().add(spinnerTable);
 
        
        panelClient = new VBox(); 
        panelClient.setAlignment(Pos.CENTER);
        panelClient.setSpacing(10);
        container.getChildren().add(panelClient); 
        //change la dimension de la page
        container.setPrefSize(640, 400);
        
        addBox();
        //changer l'arrière plan de la fenêtre de javafx
        
        
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
	        	mdl.creerGrp(newTableSpinnerValue);
	        	for (int i = 0; i < panelClient.getChildren().size(); i++ )
	        	{
	        		
	        		HBox hbox = (HBox) panelClient.getChildren().get(i); 
	        		hbox.setPadding(new Insets(15, 12, 15, 12));
	        	    
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
		        	
		        	mdl.addClient(pseudo.getText(), hex);
	        	}
	        	
	        	GrosModel.setNbPerso(newSpinnerValue);
	        	ChangerWindows.changeWindows("libs");
	        } 
        }; 
        
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, monEvent);
        VBox.setMargin(button, new Insets(15));
       
        container.getChildren().add(button);
        
        this.getChildren().add(this.container);
 
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
    	newClient.setAlignment(Pos.CENTER);
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
