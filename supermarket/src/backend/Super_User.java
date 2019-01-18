package backend;

import java.io.Serializable;

public class Super_User implements Serializable {
	String query1;
	String query2;

	Super_User() {
	}

	public static void Link(String q1, String q2) {

		Store st = supermarket.My_Stores.get(q1);
		Warehouse wh = supermarket.My_Warehouses.get(q2);
		st.wh = wh;
		wh.myst = st;
	}

	void add_warehouse() {
	}

	void add_store() {
	}

	void view_store() {
	}

	void view_warehouse() {
	}

	void crtwhadmin() {
	}

	void crtstadmin() {
	}

}
