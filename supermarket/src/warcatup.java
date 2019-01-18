import java.io.IOException;

import backend.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class warcatup {

	@FXML
	private AnchorPane mpane;
	@FXML
	private TextField upname;

	public void update(ActionEvent event) throws IOException

	{
		String catname = warcatman.al.get(0);
		Category cat = whadminlogin.currentwha.mywh.inventory.get(catname);
		cat.name = upname.getText();
		whadminlogin.currentwha.mywh.inventory.remove(catname);
		whadminlogin.currentwha.mywh.inventory.put(upname.getText(), cat);

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/warecatup.fxml"));
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
