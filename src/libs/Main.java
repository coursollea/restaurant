package libs;

import java.nio.channels.NetworkChannel;

import changeWindows.ChangerWindows;
import choixClient.VueCreationPersos;
import javafx.application.Application;
import javafx.stage.Stage;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
 
public class Main extends Application {
 
    @Override
    public void start(Stage stage) {
    	
 
    	ChangerWindows.setStage(stage);
    	ChangerWindows.changeWindows("choixClient");
 
        stage.setTitle("Si l'As de Tapas, esta nosotros!!!");
        stage.show();
       
    }
 
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
