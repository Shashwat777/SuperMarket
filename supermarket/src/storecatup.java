import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

import backend.Category;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;

public class storecatup {
	@FXML
	private AnchorPane mpane;
	@FXML
	private TextField upname;
	
	public void update(ActionEvent event) throws IOException

	{
		String catname = storecatman.al.get(0);
		Category cat = stadminlogin.currentsta.mystore.inventory.get(catname);
		cat.name = upname.getText();
		stadminlogin.currentsta.mystore.inventory.remove(catname);
		stadminlogin.currentsta.mystore.inventory.put(upname.getText(), cat);

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storecatman.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void menue(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/storecatman.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}


}
