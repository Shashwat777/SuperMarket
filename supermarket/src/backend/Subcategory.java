package backend;

import java.io.Serializable;
import java.util.HashMap;

public class Subcategory implements Serializable {
	public HashMap<String, Item> items = new HashMap<String, Item>();

	public Subcategory() {
	}

}
