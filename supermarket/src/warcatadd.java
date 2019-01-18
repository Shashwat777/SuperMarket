import java.io.IOException;

import backend.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class warcatadd {
	@FXML
	private TextField name;

	public void add(ActionEvent event) throws IOException

	{
		Category cat = new Category(name.getText());
		System.out.print(name.getText());
		whadminlogin.currentwha.mywh.inventory.put(name.getText(), cat);
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/warecatadd.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void menue(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminware.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

}
