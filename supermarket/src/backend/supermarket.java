package backend;

import java.util.*;

public class supermarket implements java.io.Serializable {
	public Super_User my_superuser;
	public String st="shashwat";
	private static String suId = "superuser";
	private static String supass = "123";

	public static  HashMap<String, Warehouse> My_Warehouses = new HashMap<>();
	public static  HashMap<String, Store> My_Stores= new HashMap<>();
	public static HashMap<String, Store_Admin> stadmins= new HashMap<>();
	public static HashMap<String, Warehouse_admin> whadmins= new HashMap<>();



	public supermarket() {

	}
	

	public static  String add_warehouse() {
		int ck = 0;

		Warehouse wh = null;
		while (ck == 0) {
			

			Random rand = new Random();
			int random = rand.nextInt(100);
			String id = String.valueOf(random);
			if (My_Warehouses.containsKey(id)) {
			} else {
		
				wh = new Warehouse(id);
			
				ck = 1;

			}
		}
		My_Warehouses.put(wh.id, wh);
		return (wh.id);

	}

	public static  String add_store() {
		int ck = 0;
		
		Store st = null;
		while (ck == 0) {
			

			Random rand = new Random();
			int random = rand.nextInt(100);
			String id = String.valueOf(random);

			if (My_Stores.containsKey(id)) {
			} else {

				
		
				st = new Store(id);
				ck = 1;

				
			}
		}
	
		My_Stores.put(st.id, st);

		return (st.id);
	}

	public Super_User get_superuser() {
		return my_superuser;
	}

	public static  Warehouse get_warehouse(String id) {
		return null;
	}

	public static  String get_suid() {
		return suId;
	}

	public Store get_store(String id) {
		return null;

	}

	public static  String get_supassword() {
		return supass;

	}
	
}
