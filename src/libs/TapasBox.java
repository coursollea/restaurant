package libs;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TapasBox extends HBox {
	
	private static int _nbClickpers1 = 0;
	private static int _nbClickpers2 = 0;
	private static int _nbClickpers3 = 0;
	private static int _nbClickpers4 = 0;
	
	private static Text nbTapas1;
	private static Text nbTapas2;
	private static Text nbTapas3;
	private static Text nbTapas4;
	
	public static void set_nbClickpers1(int nbClickpers1) {
		_nbClickpers1 = nbClickpers1;
	}

	public static void set_nbClickpers2(int nbClickpers2) {
		_nbClickpers2 = nbClickpers2;
	}

	public static  void set_nbClickpers3(int nbClickpers3) {
		_nbClickpers3 = nbClickpers3;
	}

	public static  void set_nbClickpers4(int nbClickpers4) {
		_nbClickpers4 = nbClickpers4;
	}
	
	
	public static int get_nbClickpers1() {
		return _nbClickpers1;
	}

	public static int get_nbClickpers2() {
		return _nbClickpers2;
	}

	public static int get_nbClickpers3() {
		return _nbClickpers3;
	}

	public static int get_nbClickpers4() {
		return _nbClickpers4;
	}
	
	
	public void setNbTapas1() {
		nbTapas1.setText(String.valueOf(_nbClickpers1) + "  ");
	}

	public void setNbTapas2() {
		nbTapas2.setText(String.valueOf(_nbClickpers2) + "  ");
	}

	public void setNbTapas3() {
		nbTapas3.setText(String.valueOf(_nbClickpers3) + "  ");
	}

	public void setNbTapas4() {
		nbTapas4.setText(String.valueOf(_nbClickpers4) + "  ");
	}
	
	
	public void start()
	{
		nbTapas1 = new Text();
		nbTapas2 = new Text();
		nbTapas3 = new Text();
		nbTapas4 = new Text();
		
		nbTapas1.setFill(Color.RED);
		nbTapas2.setFill(Color.BLUE);
		nbTapas3.setFill(Color.YELLOW);
		nbTapas4.setFill(Color.GREEN);
		
		this.getChildren().add(nbTapas1);
		this.getChildren().add(nbTapas2);
		this.getChildren().add(nbTapas3);
		this.getChildren().add(nbTapas4);
	}
}