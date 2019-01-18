package backend;

import java.io.Serializable;
import java.util.HashMap;

public class Category implements Serializable {
	int t = 0;
	public String name;
	public HashMap<String, Subcategory> subcats=new HashMap<String, Subcategory> ();

	public Category(String name){this.name=name;
	HashMap<String, Subcategory> subcats=new HashMap<String, Subcategory> ();
	}

}
