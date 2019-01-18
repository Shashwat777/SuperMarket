package backend;

import java.io.Serializable;
import java.util.HashMap;

public class Store implements Serializable {
	Store_Admin myadmin;
	public int custno=0;
	public int points=0;
	public Warehouse wh=null;
	public int totalsale;
	public int rating;
	public String adminid;
	public String adminpass;
	String query1;
	public String id;
	String query2;
	public HashMap<String, Category> inventory=new  HashMap<String, Category>();
	public HashMap<String, Item> items=new  HashMap<String, Item>();;

	Store(String id) {
		this.id=id;
	}

	void setadmin() {
	}

	void adminlogin() {
	}

	void search() {
	}

	void alphabeticalsort() {
	}

	void lwtohisort() {
	}

}