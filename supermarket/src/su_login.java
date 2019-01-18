
import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Map.Entry;

import com.sun.glass.events.MouseEvent;

import backend.Category;
import backend.Store;
import backend.Warehouse;
import backend.supermarket;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.applet.Main;

public class su_login {
	@FXML

	private TextField id;
	@FXML

	private PasswordField password;

	public void Display_menue(ActionEvent event) throws IOException {
		String inpid = id.getText();
		String inppass = password.getText();
		if (inpid.equals(supermarket.get_suid()) & inppass.equals(supermarket.get_supassword())) {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			int x = 0;
			int y = 0;
			Label namee = new Label("Store");
			Label lwh = new Label("linked warehouse");
			Label rev = new Label("Review");

			Label ts = new Label("Total sale");
			namee.setLayoutX(x);
			namee.setLayoutY(y);
			lwh.setLayoutX(x + 100);
			lwh.setLayoutY(y);
			rev.setLayoutX(x + 200);
			rev.setLayoutY(y);
			ts.setLayoutX(x + 300);
			ts.setLayoutY(y);
			y = y + 100;
			dialogVbox.getChildren().add(namee);
			dialogVbox.getChildren().add(lwh);
			dialogVbox.getChildren().add(rev);
			dialogVbox.getChildren().add(ts);
			for (Entry<String, Store> entry : supermarket.My_Stores.entrySet()) {
				String key = entry.getKey();
				Store val = entry.getValue();
				Label sn = new Label(key);
				try {
					if (val.wh.id != null) {
						Label linwh = new Label(val.wh.id);
						linwh.setLayoutX(x + 50);
						linwh.setLayoutY(y);
						dialogVbox.getChildren().add(linwh);
					}
				} catch (Exception e) {
				}
				Label review = new Label(Integer.toString(val.rating));
				Label tsale = new Label(Integer.toString(val.totalsale));
				sn.setLayoutX(x);
				sn.setLayoutY(y);

				review.setLayoutX(x + 100);
				review.setLayoutY(y);
				tsale.setLayoutX(x + 150);
				tsale.setLayoutY(y);
				y = y + 50;

				dialogVbox.getChildren().add(sn);

				dialogVbox.getChildren().add(review);
				dialogVbox.getChildren().add(tsale);

			}
			Label ware = new Label("Warehouse");
			Label linkedst = new Label("categories");
			ware.setLayoutX(x);
			ware.setLayoutY(y);
			dialogVbox.getChildren().add(ware);
			dialogVbox.getChildren().add(linkedst);
			linkedst.setLayoutX(x + 50);
			linkedst.setLayoutY(y);
			for (Entry<String, Warehouse> entry : supermarket.My_Warehouses.entrySet()) {
				String key = entry.getKey();
				Warehouse val = entry.getValue();
				Label wn = new Label(key);
				wn.setLayoutX(x);
				wn.setLayoutX(y);
				dialogVbox.getChildren().add(wn);
				for (Entry<String, Category> entry2 : val.inventory.entrySet()) {
					String keyy = entry.getKey();
					Label cat = new Label(keyy);
					linkedst.setLayoutX(x + 50);
					linkedst.setLayoutY(y);
					ware.setLayoutY(y);

					dialogVbox.getChildren().add(cat);
				}

			}

			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});

			id.setText("");
			password.setText("");

		}

		if (inpid.equals(supermarket.get_suid()) & inppass.equals(supermarket.get_supassword())) {

			Parent tableViewParent = FXMLLoader.load(getClass().getResource("/super user menue.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();

		}

		else {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Please enter correct Id or password"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});

			id.setText("");
			password.setText("");

		}

	}

	public void open_menue(ActionEvent event) throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/home.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

}
