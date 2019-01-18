import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import backend.Category;
import backend.Item;
import backend.Store;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
public class search implements Initializable {
	
		public void initialize(URL url, ResourceBundle rb) {
			MenuButton m = new MenuButton("View");
			for (Entry<String ,Category> entry : home.cust.st.inventory.entrySet()) {
				String key = entry.getKey();
				Category val = entry.getValue();
				m.getItems().add(new MenuItem(key));
				
			}
			m.setLayoutX(0);
			m.setLayoutY(100);
			mpane.getChildren().add(m);
			MenuButton k =new MenuButton("Items");
			
			for (Entry<String , Item> entry : home.cust.st.items.entrySet()) {
				String key = entry.getKey();
				k.getItems().add(new MenuItem(key));
				
			}
			m.setLayoutX(0);
			m.setLayoutY(200);
			mpane.getChildren().add(k);
	
		}
		

	@FXML
	private TextField search;
	@FXML
	private AnchorPane mpane;

	public void enter(ActionEvent event) throws IOException {
		String sritem = search.getText();
		if (home.cust.st.items.containsKey(sritem)) {
			Item srditem = home.cust.st.items.get(sritem);
			srditem.myname = sritem;
			
			Label lblname = new Label(sritem);
			lblname.setLayoutX(0);
			lblname.setLayoutY(50);
			Label cost = new Label("Price:    " + Integer.toString(srditem.pricest));
			cost.setLayoutX(0);
			cost.setLayoutY(75);

			Label qnty = new Label("quantity:   " + Integer.toString(srditem.qntyst));

			Label description = new Label(srditem.description);
			TextField enterqnty = new TextField();
			enterqnty.setPromptText("enter quantity");
			enterqnty.setLayoutX(0);
			enterqnty.setLayoutY(150);

			
			qnty.setLayoutX(0);
			qnty.setLayoutY(100);
			description.setLayoutX(0);
			description.setLayoutY(125);

			mpane.getChildren().add(lblname);
			mpane.getChildren().add(qnty);
			mpane.getChildren().add(description);
			mpane.getChildren().add(cost);
			Button addtoc = new Button("Add to cart");
			addtoc.setLayoutX(250);
			addtoc.setLayoutY(150);
			mpane.getChildren().add(addtoc);
			mpane.getChildren().add(enterqnty);

			addtoc.setOnAction(e -> {
				if (Integer.parseInt(enterqnty.getText()) > srditem.qntyst) {

					Label invalid = new Label("invalid quantity");
					lblname.setLayoutX(300);
					lblname.setLayoutY(150);
					mpane.getChildren().add(invalid);

				} else {

					try {
						home.cust.cart.put(srditem, Integer.parseInt(enterqnty.getText()));
						Parent tableViewParent = null;

						tableViewParent = FXMLLoader.load(getClass().getResource("search.fxml"));
						Scene tableViewScene = new Scene(tableViewParent);

						// This line gets the Stage information
						Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

						window.setScene(tableViewScene);
						window.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			});

		} else {
			System.out.println("else");
		}
		/*
		 * Parent tableViewParent =
		 * FXMLLoader.load(getClass().getResource("items.fxml")); Scene tableViewScene =
		 * new Scene(tableViewParent);
		 * 
		 * // This line gets the Stage information Stage window = (Stage) ((Node)
		 * event.getSource()).getScene().getWindow();
		 * 
		 * window.setScene(tableViewScene); window.show();
		 */
	}

	public void select_store(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("storechoice.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void cart(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("my_cart.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
}