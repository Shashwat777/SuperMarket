import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import backend.Item;
import backend.Store;
import backend.supermarket;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;

public class my_cart implements Initializable {
	@FXML
	private AnchorPane mpane;

	public void initialize(URL url, ResourceBundle rb) {
		int x = 0;
		int y = 0;
		Label namee = new Label("Name");
		Label quantyy = new Label("Quantity");
		Label pricee = new Label(" total cost ");

		namee.setLayoutX(x);
		namee.setLayoutY(y);
		quantyy.setLayoutX(x + 50);
		quantyy.setLayoutY(y);
		pricee.setLayoutX(x + 100);
		pricee.setLayoutY(y);
		mpane.getChildren().add(namee);
		mpane.getChildren().add(quantyy);
		mpane.getChildren().add(pricee);
		y = y + 50;
		int totalsum = 0;

		for (Entry<Item, Integer> entry : home.cust.cart.entrySet()) {
			Item itm = entry.getKey();
			int qnty = entry.getValue();
			Button remove = new Button("REMOVE");

			Label name = new Label(itm.myname);
			Label quantity = new Label(String.valueOf(qnty));
			Label price = new Label(String.valueOf(itm.pricest * qnty));
			totalsum = totalsum + itm.pricest * qnty;

			name.setLayoutX(x);
			name.setLayoutY(y);
			quantity.setLayoutX(x + 50);
			quantity.setLayoutY(y);
			price.setLayoutX(x + 100);
			price.setLayoutY(y);
			remove.setLayoutX(x + 150);
			remove.setLayoutY(y);

			y = y + 50;
			mpane.getChildren().add(name);
			mpane.getChildren().add(quantity);
			mpane.getChildren().add(price);
			mpane.getChildren().add(remove);

			remove.setOnAction(e -> {
				home.cust.cart.remove(itm);

				Parent tableViewParent = null;
				try {
					tableViewParent = FXMLLoader.load(getClass().getResource("/my_cart.fxml"));
					
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

		}
		Label total = new Label("TOTAL BILL");
		Label totalee = new Label(String.valueOf(totalsum));
		total.setLayoutX(0);
		total.setLayoutY(y);
		totalee.setLayoutX(100);
		totalee.setLayoutY(y);
		mpane.getChildren().add(total);
		mpane.getChildren().add(totalee);

	}

	public void checkout(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Payment_mode.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("search.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
}