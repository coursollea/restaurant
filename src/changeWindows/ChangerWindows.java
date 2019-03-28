package changeWindows;

import choixClient.VueCreationPersos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import libs.VueChoixTapas;
import model.ModelChoixTapas;

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
			VueCreationPersos vueCreationPersos = new VueCreationPersos(); 
			Scene scene = new Scene(vueCreationPersos, 640, 400);
			
			_stage.setScene(scene);
		}
		
		if (nomPage == "libs")
		{
			VueChoixTapas vue = new VueChoixTapas(); 
			vue.init(new ModelChoixTapas());
			vue.start();
			Scene scene = new Scene(vue, 640, 400);
			
			_stage.setScene(scene);
			
			
		}
		
	}
}
