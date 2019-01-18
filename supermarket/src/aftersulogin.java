import java.net.URL;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import backend.Category;
import backend.Item;
import backend.Store;
import backend.Warehouse;
import backend.supermarket;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class aftersulogin implements Initializable {
	public void initialize(URL url, ResourceBundle rb) {
		int x = 0;
		int y = 0;
		Label namee = new Label("Store");
		Label lwh = new Label("linked warehouse");
		Label rev = new Label("Review");
		
		Label ts = new Label("Total sale");
		namee.setLayoutX(x);
		namee.setLayoutY(y);
		lwh.setLayoutX(x+100);
		lwh.setLayoutY(y);
		rev.setLayoutX(x+200);
		rev.setLayoutY(y);
		ts.setLayoutX(x+300);
		ts.setLayoutY(y);
		y=y+100;


		
		for (Entry<String, Store> entry : supermarket.My_Stores.entrySet()) {
			String key = entry.getKey();
			Store val = entry.getValue();
			Label sn=new Label(key);
			Label linwh=new Label(val.wh.id);
			Label review=new Label(Integer.toString(val.rating));
			Label tsale=new Label(Integer.toString(val.totalsale));
			sn.setLayoutX(x);
			sn.setLayoutY(y);
			linwh.setLayoutX(x+50);
			linwh.setLayoutY(y);
			review.setLayoutX(x+100);
			review.setLayoutY(y);
			tsale.setLayoutX(x+150);
			tsale.setLayoutY(y);
			y=y+50;
			
			
			
			
		}
		Label ware= new Label("Warehouse");
		Label linkedst = new Label("categories");
		ware.setLayoutX(x);
		ware.setLayoutY(y);
		
		linkedst.setLayoutX(x+50);
		linkedst.setLayoutY(y);
		for (Entry<String, Warehouse> entry : supermarket.My_Warehouses.entrySet()) {
			String key = entry.getKey();
			Warehouse val = entry.getValue();
			Label wn=new Label(key);
			wn.setLayoutX(x);
			wn.setLayoutX(y);
			for (Entry<String, Category> entry2 : val.inventory.entrySet()) {
				String keyy = entry.getKey();
				Label cat=new Label(keyy);
				linkedst.setLayoutX(x+50);
				linkedst.setLayoutY(y);
				
			}
			
			
			
		}
		
		
		
		
		

		
	}

}
