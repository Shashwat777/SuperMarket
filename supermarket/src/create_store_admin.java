import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import java.io.IOException;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import com.sun.glass.events.MouseEvent;
import backend.Store;
import backend.Store_Admin;
import backend.supermarket;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.applet.Main;

public class create_store_admin {
	@FXML

	private TextField chid;
	@FXML

	private PasswordField chpassword;
	@FXML

	private PasswordField renterpassword;
	@FXML

	private TextField stid;

	public void create(ActionEvent event) throws IOException {
		for (Entry<String, Store_Admin> entry : supermarket.stadmins.entrySet())

		{
			if (entry.getValue().adminid.equals(chid.getText())) {

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				Button close = new Button("close");
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(window);
				VBox dialogVbox = new VBox(20);
				dialogVbox.getChildren().add(close);
				dialogVbox.getChildren().add(new Text("Id exists"));
				Scene dialogScene = new Scene(dialogVbox, 300, 200);
				dialog.setScene(dialogScene);
				dialog.show();
				close.setOnAction(e -> {
					dialog.close();

				});

				chid.setText("");

			}
		}
		if (chpassword.getText().equals(renterpassword.getText()) == false) {

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Password do not match"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});

			chpassword.setText("");
			renterpassword.setText("");

		} else if (supermarket.My_Stores.containsKey(stid.getText()) == false) {
			

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Please enter valid store id"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});

			stid.setText("");
		

		} else {
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("/store_admin_created.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			Store st=supermarket.My_Stores.get(stid.getText());
			Store_Admin sa=new Store_Admin(st);
			sa.adminid=chid.getText();
			sa.adminpassword=chpassword.getText();
			supermarket.stadmins.put(chid.getText(),sa);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();
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