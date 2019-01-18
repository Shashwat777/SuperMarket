package backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public class Warehouse implements Serializable {
	Warehouse_admin myadmin;
	public Store myst;
	public String id;
	public int d;
	

	String query1;
	String query2;
	public HashMap<String, Category> inventory = new HashMap<String, Category>();
	public HashMap<String, Item> Items = new HashMap<String, Item>();
	public HashMap<String, Item> lwinventory = new HashMap<String, Item>();

	Warehouse(String id) {
		this.id = id;
		inventory = new HashMap<String, Category>();
	}

	void setadmin() {
	}

	void login() {
	}

	double getEOQ(int d, int k, int h) {
		return (Math.pow(2 * d * k / h, 0.5));

	}

	public void uplwinventory() {
		

		for (Entry<String, Item> entry : lwinventory.entrySet()) {
			double demand=getEOQ(d,entry.getValue().h,entry.getValue().k);
			Integer i =(int) demand;
	
				if(Items.get(entry.getKey()).qntywh> i) {  // checks in warehouse if the required qnty is present 
					Items.get(entry.getKey()).qntywh=Items.get(entry.getKey()).qntywh-i;
					Items.get(entry.getKey()).qntyst=i;
					i=0;
			
				}
				else if(Items.get(entry.getKey()).qntywh>0) {// if less  then consumes whole lot
					i=i-Items.get(entry.getKey()).qntywh;
					
					Items.get(entry.getKey()).qntyst=Items.get(entry.getKey()).qntywh;
					Items.get(entry.getKey()).qntywh=0;
					
				}
				else if(i>0) {  // checks for left in other warehouses 
					for (Entry<String, Warehouse> entry2 : supermarket.My_Warehouses.entrySet()) {
						if(i<1) {
							break;
						}
						Warehouse val=entry2.getValue();
						if(val.Items.containsKey(entry.getKey())) {
							if(Items.get(entry.getKey()).qntywh> i) {
								Items.get(entry.getKey()).qntywh=Items.get(entry.getKey()).qntywh-i;
								Items.get(entry.getKey()).qntyst=i;
								i=0;
						
							}
							else if(Items.get(entry.getKey()).qntywh>0) {
								i=i-Items.get(entry.getKey()).qntywh;
								
								Items.get(entry.getKey()).qntyst=Items.get(entry.getKey()).qntywh;
								Items.get(entry.getKey()).qntywh=0;
								
							}
						}
						
						
					}
					
				
				
			}
			

		}

	};

}
