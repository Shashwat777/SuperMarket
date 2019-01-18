import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;

public class setd {

	@FXML
	private TextField tf;

	public void back(ActionEvent event) throws IOException {
		System.out.println("gh");
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminware.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void set(ActionEvent event) throws IOException {
		whadminlogin.currentwha.mywh.d=Integer.valueOf(tf.getText());
	

	}
}