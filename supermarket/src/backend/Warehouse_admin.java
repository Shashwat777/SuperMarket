package backend;

import java.io.Serializable;

public class Warehouse_admin implements Serializable  {
	public Warehouse mywh;
	String query1;
	String query2;
	public String adminid;
	public String adminpass;


	public Warehouse_admin(Warehouse wh) {
		mywh=wh;
	}

	void addcat() {
	}

	void addsubcat(Category cat) {
	}

	void additem(int price, int qnty) {

	}

	void dltcat() {
	}

	void dltsubcat() {
	}

	void dltitem() {
	}

	void upitemqnty(Item item, int qnty) {
	}

	void upitemprice(Item item, int price) {
	}
	void upitemdescription(Item item, int price) {
	}

	void setd(int val) {
	}

	void setd() {
	}

// To order from other warehouses
	void tkhelp(Item item, int qnty) {
	}

	void replishstore(Item item) {
	}

}
