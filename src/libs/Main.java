package libs;

import changeWindows.ChangerWindows;
import classeMetier.Categorie;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
 
    @Override
    public void start(Stage stage) {
    	
 
    	Categorie legume = new Categorie(); 
    	legume.fillCategorie(1);
    	ChangerWindows.setStage(stage);
    	ChangerWindows.changeWindows("choixClient");
 
        stage.setTitle("Si l'As de Tapas, esta nosotros!!!");
        stage.show();
       
    }
 
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
