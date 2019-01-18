import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import java.io.IOException;

import backend.Store_Admin;
import backend.supermarket;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class stadminlogin {
	@FXML
	private TextField id;
	@FXML
	private PasswordField password;
	public static Store_Admin currentsta;
	
	public void Display_menue(ActionEvent event) throws IOException
    {String ide=id.getText();
     if(supermarket.stadmins.containsKey(ide) && supermarket.stadmins.get(ide).adminpassword.equals(password.getText())) {
    	 currentsta=supermarket.stadmins.get(ide);
    	 
     
    
    
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/adminstore.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();}
     else {
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
			Button close = new Button("close"); 
			 final Stage dialog = new Stage();
		        dialog.initModality(Modality.APPLICATION_MODAL);
		        dialog.initOwner(window);
		        VBox dialogVbox = new VBox(20);
		        dialogVbox.getChildren().add(close);
		        dialogVbox.getChildren().add(new Text("Please enter correct Id or password"));
		        Scene dialogScene = new Scene(dialogVbox, 300, 200);
		        dialog.setScene(dialogScene);
		        dialog.show();
				close.setOnAction(e	->	{	
                    dialog.close();
                

	});				
		       
				id.setText("");
				password.setText("");
       	
		}
     }
    

	public void open_menue(ActionEvent event) throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/home.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}


}
