package libs;

import java.io.InputStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Model;


public class View extends BorderPane {
	
	private Model model;
	
	public void init(Model model)
	{
		this.model = model;
	}
	
	public void start()
	{
		ScrollPane scrollpanel = new ScrollPane();
		BorderPane tapaslist = new BorderPane();
		scrollpanel.addcontent(tapaslist);
		int nombretapas = model.getNbTapas();
		
		for(int i = 1 ; i < nombretapas ; i++)
		{
			Button butt = new Button();
			EventHandler<MouseEvent> monEvent = new EventHandler<MouseEvent>()
			{
				public void handle(MouseEvent e)
				{ 
					System.out.println("Click");            
				} 
			};
			butt.addEventHandler(MouseEvent.MOUSE_CLICKED, monEvent);
		}
	}
}
