import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import backend.Category;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;
import javafx.scene.layout.AnchorPane;

public class storecatman implements Initializable {
	static ArrayList<String> al = new ArrayList<String>();
	@FXML
	private AnchorPane mpane;

	public void initialize(URL url, ResourceBundle rb) {
	

		int x = 0;
		int y = 0;
		int ty = 0;
		al = new ArrayList<String>();
	

		for (Entry<String, Category> entry : stadminlogin.currentsta.mystore.inventory.entrySet()) {
			String key = entry.getKey();
		
			RadioButton b = new RadioButton(key);

			b.setLayoutX(150);
			b.setLayoutY(150+y);
			y=y+25;
			mpane.getChildren().add(b);
			b.setOnAction(e -> {
				al.add(key);
				System.out.println("key");

			});

		}
	}

	public void update(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storecatup.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
	public void delete(ActionEvent event) throws IOException {
		String catname = storecatman.al.get(0);
		stadminlogin.currentsta.mystore.inventory.remove(al.get(0));

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storecatman.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
	public void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminstore.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}


	
		public void add(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storecatadd.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
}