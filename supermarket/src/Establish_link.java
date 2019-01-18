import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

import backend.Super_User;
import backend.supermarket;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.applet.Main;

public class Establish_link {
	static String var;
	static String var2;
	@FXML
	private TextField stid;
	@FXML
	private TextField whid;

	public void link(ActionEvent event) throws IOException{

		String storeid = stid.getText();
		
		var = storeid;
		String warehouseid = whid.getText();
		var2 = warehouseid;
		if (supermarket.My_Stores.containsKey(storeid) && supermarket.My_Warehouses.containsKey(warehouseid)) {

			Super_User.Link(storeid, warehouseid);
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("/linked.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();
		} else {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Please enter correct store and warehouse Id"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();
				stid.setText("");
				whid.setText("");

			});

		}
		// if(supermarket.My_Stores.containsKey(q1) &&
		// supermarket.My_Stores.containsKey(q1)) {

	}

	public void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/super user menue.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
}