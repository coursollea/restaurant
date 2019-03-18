package libs;



import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Vue extends VBox
{
	private VBox panelClient; 
	private final Spinner<Integer> spinner = new Spinner<Integer>(); 
	private int oldSpinnerValue; 
 
    public Vue()
    {
    	
        Label label = new Label("Selectionner le nombre de personnes:");
        //final Spinner<Integer> spinner = new Spinner<Integer>();
 
        final int initialValue = 1;
 
        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, initialValue);
        spinner.setValueFactory(valueFactory);
        oldSpinnerValue = spinner.getValue(); 
        
        spinner.valueProperty().addListener(
        		(obs, oldValue, newValue) -> 
        		manageClient());
        this.getChildren().add(label); 
        this.getChildren().add(spinner); 
 
        
        panelClient = new VBox(); 
        this.getChildren().add(panelClient); 
        
        addBox();
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
