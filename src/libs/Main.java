package libs;

import changeWindows.ChangerWindows;
import javafx.application.Application;
import javafx.stage.Stage;

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
