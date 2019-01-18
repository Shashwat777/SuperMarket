import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class storeitemman {

	@FXML
	public  TextField cat;

	@FXML
	public TextField subcat;
	@FXML
	public static TextField name;
	public static String cate;
	public static String subcate;


	@FXML
	void add(ActionEvent event) throws IOException {
		
		System.out.println(cat.getText()+"a");
		cate=cat.getText();
		subcate=subcat.getText();
		
		if (stadminlogin.currentsta.mystore.inventory.containsKey(cat.getText())) {
			if (stadminlogin.currentsta.mystore.inventory.get(cat.getText()).subcats.containsKey(subcat.getText())) {

				Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storeadditem.fxml"));
				Scene tableViewScene = new Scene(tableViewParent);

				// This line gets the Stage information
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(tableViewScene);
				window.show();
			}
		}
	
	}

	@FXML
	void delete(ActionEvent event) {
		

	}

	@FXML
	void modify(ActionEvent event) {

	}
	@FXML
	void back(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminstore.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
		

	}

}
