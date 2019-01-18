import java.io.IOException;


import backend.Item;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class storeadditem {
	@FXML
	private AnchorPane mpane;

	@FXML
	private TextField price;

	@FXML
	private TextField qnty;

	@FXML
	private TextField name;

	@FXML
	private TextField h;

	@FXML
	private TextArea description;

	@FXML
	private TextField k;

	@FXML
	void add(ActionEvent event) {
		if (stadminlogin.currentsta.mystore.wh.Items.containsKey(name.getText())) {
			if ((stadminlogin.currentsta.mystore.wh.Items.get(name.getText()).qntywh) > 1
					+ Integer.parseInt(qnty.getText())) {
				Item itm = stadminlogin.currentsta.mystore.wh.Items.get(name.getText());

				stadminlogin.currentsta.mystore.items.put(name.getText(),
						stadminlogin.currentsta.mystore.wh.Items.get(name.getText()));
				stadminlogin.currentsta.mystore.inventory.get(storeitemman.cate).subcats.get(storeitemman.subcate).items
						.put(name.getText(), stadminlogin.currentsta.mystore.wh.Items.get(name.getText()));
				itm.qntywh = itm.qntywh - Integer.parseInt(qnty.getText());
				itm.description = description.getText();
				if(h.getText().equals("")==false) {
				itm.h = Integer.parseInt(h.getText());}
				if(k.getText().equals("")==false) {
				itm.k = Integer.parseInt(k.getText());}
				itm.qntyst = Integer.parseInt(qnty.getText());
				itm.pricest = Integer.parseInt(price.getText());
                 System.out.print("added");
				Label lbl = new Label("added");
				lbl.setLayoutX(0);
				lbl.setLayoutY(0);
				mpane.getChildren().add(lbl);

			}

		} else if (stadminlogin.currentsta.mystore.wh.Items.containsKey(name.getText()) == false) {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Button close = new Button("close");
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(window);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(close);
			dialogVbox.getChildren().add(new Text("Item not in the warehouse "));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			close.setOnAction(e -> {
				dialog.close();

			});

			name.setText("");

		}

	}

	@FXML
	void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storeitemman.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

}
