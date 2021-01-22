package org.keroro.dao;

public class MainDao {
	public static void main(String args[]) {
		StoreDAO dao = StoreDAO.getInstance();
		
		try {
			dao.updateStore();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
