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

public class Main extends Application
{
	public void start(Stage primaryStage)
	{
		View vue = new View();
		Model mdl = new Model();
		
		vue.init(mdl);
		mdl.init(vue);
		
		mdl.start();
		vue.start();
		
		Scene scene = new Scene(vue, Color.BLACK);
		primaryStage.setTitle("Démineur");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/icon.png")));
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(Main.class);
		try {
			Connection connex = DriverManager.getConnection ("jdbc:mysql://localhost:3306/site_sql", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}