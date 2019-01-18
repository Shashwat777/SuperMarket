import java.io.IOException;
import java.util.Map.Entry;

import backend.Item;
import backend.Store_Admin;
import backend.Warehouse_admin;
import backend.supermarket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class whadminlogin {
	@FXML
	private TextField id;
	@FXML
	private PasswordField password;
	public static Warehouse_admin currentwha;

	public void Display_menue(ActionEvent event) throws IOException {
		String ide = id.getText();
		if (supermarket.whadmins.containsKey(ide)
				&& supermarket.whadmins.get(ide).adminpass.equals(password.getText())) {
			currentwha = supermarket.whadmins.get(ide);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(new Text("Low inventory items"));

			dialogVbox.getChildren().add(close);
		int x=0 ;
		int y=0;
			for (Entry<String, Item> entry : currentwha.mywh.lwinventory.entrySet() ){
				String itm = entry.getKey();
				Label ln=new Label(itm);
				ln.setLayoutX(x);
				ln.setLayoutY(y);
				y=y+50;
				dialogVbox.getChildren().add(ln);
				
				
			}
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});

		}
		if (supermarket.whadmins.containsKey(ide)
				&& supermarket.whadmins.get(ide).adminpass.equals(password.getText())) {
			currentwha = supermarket.whadmins.get(ide);

			Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminware.fxml"));
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
