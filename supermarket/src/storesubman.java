import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

import backend.Category;
import backend.Subcategory;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.applet.Main;

public class storesubman {
	@FXML
	private TextField cat;
	@FXML
	private TextField subcat;
	@FXML
	private TextField nname;
	@FXML
	private AnchorPane mpane;

	public void update(ActionEvent event) throws IOException {
		if ((stadminlogin.currentsta.mystore.inventory.containsKey(cat.getText()))
				&& (stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats
						.containsKey(subcat.getText()))) {
			Subcategory subcats = stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats
					.get(subcat.getText());
			stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats.remove(subcat.getText());
			stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats.put(nname.getText(), subcats);
			subcat.setText("");
			nname.setText("");
			Label lbl = new Label("updated");
			lbl.setLayoutX(0);
			lbl.setLayoutY(0);
			mpane.getChildren().add(lbl);

		} else {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Please enter correct subcategory and category"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});
			cat.setText("");
			subcat.setText("");

		}
	}

	public void add(ActionEvent event) throws IOException {

		if (stadminlogin.currentsta.mystore.inventory.containsKey(cat.getText())) {
			Subcategory subcats = new Subcategory();

			Category ct = stadminlogin.currentsta.mystore.inventory.get(cat.getText());
			ct.subcats.put(subcat.getText(), subcats);
			subcat.setText("");
			nname.setText("");
			Label lbl = new Label("added");
			lbl.setLayoutX(0);
			lbl.setLayoutY(0);
			mpane.getChildren().add(lbl);
		} else {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Please enter category"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});
			cat.setText("");
			subcat.setText("");
		}

	}
	public void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminstore.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}



	public void delete(ActionEvent event) throws IOException {

		if ((stadminlogin.currentsta.mystore.inventory.containsKey(cat.getText()))
				&& (stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats
						.containsKey(subcat.getText()))) {

			stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats.remove(subcat.getText());
			subcat.setText("");
			nname.setText("");
			Label lbl = new Label("deleted");
			lbl.setLayoutX(0);
			lbl.setLayoutY(0);
			mpane.getChildren().add(lbl);
		} else {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Please enter correct subcategory and category"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});
			cat.setText("");
			subcat.setText("");

		}
	}
}
