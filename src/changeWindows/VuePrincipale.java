package changeWindows;

import choixClient.Vue;
import javafx.scene.layout.FlowPane;

public class VuePrincipale extends FlowPane
{
	public void changeWindows(String nomPage)
	{
		if (nomPage == "choixClient")
		{
			Vue vue = new Vue(); 
			this.getChildren().add(vue); 
		}
		
	}
}
