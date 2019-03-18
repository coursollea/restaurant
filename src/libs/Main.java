package libs;

import java.nio.channels.NetworkChannel;

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
    	
    	Vue vue = new Vue(); 
    	Scene scene = new Scene(vue, 1000, 400);
    	 
        stage.setTitle("Si l'As de Tapas, esta nosotros!!!");
        stage.setScene(scene);
        stage.show();
    }
 
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
