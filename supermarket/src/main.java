import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import sun.applet.Main;

public class main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	

	public void start(Stage primarystage) throws Exception {
		Pane mainPane=(Pane) FXMLLoader.load(Main.class.getResource("/home.fxml"));
		primarystage.setScene(new Scene(mainPane));
				primarystage.show();
	}

}
