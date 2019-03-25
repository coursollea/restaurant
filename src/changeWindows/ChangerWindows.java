package changeWindows;

import choixClient.Vue;
import javafx.scene.Scene;
import javafx.stage.Stage;
import libs.View;
import model.Model;

public class ChangerWindows
{
	private static Stage _stage;
	
	public static void setStage(Stage stage)
	{
		_stage = stage;
	}
	
	public static void changeWindows(String nomPage)
	{
		if (nomPage == "choixClient")
		{
			Vue vue = new Vue(); 
			Scene scene = new Scene(vue, 640, 400);
			
			_stage.setScene(scene);
		}
		
		if (nomPage == "libs")
		{
			View vue = new View(); 
			vue.init(new Model());
			vue.start();
			Scene scene = new Scene(vue, 640, 400);
			
			_stage.setScene(scene);
			
			
		}
		
	}
}
