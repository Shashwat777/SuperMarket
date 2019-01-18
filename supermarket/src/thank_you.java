import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import backend.Item;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;

public class thank_you implements Initializable{
	@FXML
	private TextField review;
	public void initialize(URL url, ResourceBundle rb) {
		home.cust.st.custno++;
		for (Entry<Item, Integer> entry : home.cust.cart.entrySet()) {
			Item itm = entry.getKey();
			int qnty = entry.getValue();
			itm.qntyst=itm.qntyst-qnty;
			if(itm.qntyst==0) {
				home.cust.st.wh.lwinventory.put(itm.myname, itm);
				
			}
			
		}
	}

	public void shop_more(ActionEvent event) throws IOException {
	
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/search.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
	public void exit(ActionEvent event) throws IOException {

		System.exit(1);
	}
	public void submit(ActionEvent event) throws IOException {
		home.cust.st.points= home.cust.st.points+Integer.parseInt(review.getText());
		home.cust.st.rating=home.cust.st.points/home.cust.st.custno;
		System.exit(1);
	}
} 