import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import com.sun.javafx.collections.MappingChange.Map;

import backend.Store;
import backend.supermarket;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import javafx.stage.Stage;

import sun.applet.Main;


public class store_choice implements Initializable {

	@FXML
	private AnchorPane mpane;

	public void initialize(URL url, ResourceBundle rb) {
		int x = 0;
		int y = 0;
		int ty=0;

		for (Entry<String, Store> entry : supermarket.My_Stores.entrySet()) {
			String key = entry.getKey();
			Store val = entry.getValue();
			Button b = new Button("visit");

			Label stname = new Label(key);
			Label review = new Label(String.valueOf(val.rating));
			b.setLayoutX(x);
			b.setLayoutY(y);
			stname.setLayoutX(x + 250);
			stname.setLayoutY(y);
			review.setLayoutX(x + 150);
			review.setLayoutY(y);

			y = y + 100;
			mpane.getChildren().add(b);
			mpane.getChildren().add(stname);
			mpane.getChildren().add(review);
			b.setOnAction(e -> {
				home.cust.st = val;
				Parent tableViewParent = null;
				try {
					tableViewParent = FXMLLoader.load(getClass().getResource("/search.fxml"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Scene tableViewScene = new Scene(tableViewParent);

				// This line gets the Stage information
				Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

				window.setScene(tableViewScene);
				window.show();

			});
			// ...
		}

	}

	public void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/home.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
}