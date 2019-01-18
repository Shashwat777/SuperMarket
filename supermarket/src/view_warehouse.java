import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

import backend.supermarket;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;
import javafx.scene.layout.AnchorPane;

public class view_warehouse {
	@FXML
	private AnchorPane mpane;
	@FXML
	private TextField tf;

	public void search(ActionEvent event) throws IOException {
		try {
			String whid = tf.getText();

			if (supermarket.My_Warehouses.containsKey(whid)) {
				Label store = new Label("Store");
				store.setLayoutX(0);
				store.setLayoutY(50);
				Label dd = new Label("d value ");
				dd.setLayoutX(50);
				dd.setLayoutY(50);
				mpane.getChildren().add(dd);
				Label d = new Label(Integer.toString(supermarket.My_Warehouses.get(whid).d));
				d.setLayoutX(50);
				d.setLayoutY(100);
				mpane.getChildren().add(d);


				Label mst = new Label(supermarket.My_Warehouses.get(whid).myst.id);
				mst.setLayoutX(0);
				mst.setLayoutY(100);
				mpane.getChildren().add(store);
				mpane.getChildren().add(mst);

			} else {
				Label store = new Label("invalid input ");
				store.setLayoutX(0);
				store.setLayoutY(200);
				mpane.getChildren().add(store);

			}

		} catch (Exception e) {
			Label nostore = new Label("No store");
			nostore.setLayoutX(0);
			nostore.setLayoutY(250);
			mpane.getChildren().add(nostore);

		}
	}

	public void menue(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/super user menue.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
}