package libs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MainApp extends Application
{
	public void start(Stage primaryStage) throws SQLException
	{
		
		View vue = new View();
		Model mdl = new Model();
		
		vue.init(mdl);
		mdl.init(vue);
		
		vue.start();
		
		Scene scene = new Scene(vue,920,520,Color.BLACK);
		primaryStage.setTitle("Tapas ShopZ");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/images/icon.png")));
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(MainApp.class);
		/*BDD.stop();*/
	}
}