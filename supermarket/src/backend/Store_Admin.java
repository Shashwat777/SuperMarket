package backend;

import java.io.Serializable;

public class Store_Admin implements Serializable  {
	public Store mystore;
	public String adminid;
	public  String adminpassword;
	Warehouse wh;
	String query1;
	String query2;

	public Store_Admin(Store st) {
		mystore=st;
	}

	void addcat() {
	}

	void addsubcat() {
	}

	void upitemcost() {

	}

	void setitemk() {

	}

	void setitemh() {

	}

}
