import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

import backend.Item;
import backend.Super_User;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.applet.Main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class waritemman {

	@FXML
	private TextField cost;

	@FXML
	private AnchorPane mpane;
	

	@FXML
	private TextField cat;

	@FXML
	private TextField qnty;

	@FXML
	private TextField name;

	@FXML
	private TextField subcat;

	@FXML
	void delete(ActionEvent event) {
		try {
			if (whadminlogin.currentwha.mywh.inventory.containsKey(cat.getText())
					&& whadminlogin.currentwha.mywh.inventory.get(cat.getText()).subcats.get(subcat.getText()).items
							.containsKey(name.getText())) {
				whadminlogin.currentwha.mywh.inventory.get(cat.getText()).subcats.get(subcat.getText()).items
						.remove(name.getText());
				whadminlogin.currentwha.mywh.Items.remove(name.getText());
				Label lbl = new Label("deleted");
				lbl.setLayoutX(0);
				lbl.setLayoutY(0);
				mpane.getChildren().add(lbl);

			}

			else {
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				Button close = new Button("close");
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(window);
				VBox dialogVbox = new VBox(20);
				dialogVbox.getChildren().add(close);
				dialogVbox.getChildren().add(new Text("Please enter correct data"));
				Scene dialogScene = new Scene(dialogVbox, 300, 200);
				dialog.setScene(dialogScene);
				dialog.show();
				close.setOnAction(e -> {
					dialog.close();

				});

			}
		} catch (Exception e) {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);

			dialogVbox.getChildren().add(new Text("Please enter correct data"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();

		}

	}

	@FXML
	void update(ActionEvent event) {
		try {
			if (whadminlogin.currentwha.mywh.inventory.containsKey(cat.getText())
					&& whadminlogin.currentwha.mywh.inventory.get(cat.getText()).subcats.get(subcat.getText()).items
							.containsKey(name.getText())) {
				Item itm = whadminlogin.currentwha.mywh.Items.get(name.getText());
				if (qnty.getText().equals("")) {
				} else {
					itm.qntywh = Integer.parseInt(qnty.getText());
				}
				if (cost.getText().equals("")) {
				} else {
					itm.pricewh = Integer.parseInt(cost.getText());
				}
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
				dialogVbox.getChildren().add(new Text("Please enter correct data"));
				Scene dialogScene = new Scene(dialogVbox, 300, 200);
				dialog.setScene(dialogScene);
				dialog.show();
				close.setOnAction(e -> {
					dialog.close();

				});

			}
		} catch (Exception e) {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);

			dialogVbox.getChildren().add(new Text("Please enter correct data"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();

		}

	}

	@FXML
	void add(ActionEvent event) {
		try {
			if (whadminlogin.currentwha.mywh.inventory.containsKey(cat.getText())
					&& whadminlogin.currentwha.mywh.inventory.get(cat.getText()).subcats
							.containsKey(subcat.getText())) {
				Item itm = new Item();
				itm.pricewh = Integer.parseInt(cost.getText());
				itm.qntywh = Integer.parseInt(qnty.getText());
				whadminlogin.currentwha.mywh.Items.put(name.getText(), itm);
				whadminlogin.currentwha.mywh.inventory.get(cat.getText()).subcats.get(subcat.getText()).items
						.put(name.getText(), itm);
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
				dialogVbox.getChildren().add(new Text("Please enter correct data"));
				Scene dialogScene = new Scene(dialogVbox, 300, 200);
				dialog.setScene(dialogScene);
				dialog.show();
				close.setOnAction(e -> {
					dialog.close();

				});

			}

		} catch (Exception e) {
			e.printStackTrace();

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);

			dialogVbox.getChildren().add(new Text("Please enter correct data"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();

		}

	}

	@FXML
	public void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminware.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

}