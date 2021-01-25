package org.keroro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.keroro.domain.Store;

public class StoreDAO {
	static private StoreDAO dao;
	static private List<Store> storeList;

	private StoreDAO() {
	}

	static public StoreDAO getInstance() {
		if (null == dao) {
			dao = new StoreDAO();
		}

		return dao;
	}

	public static List<Store> getList(){
		return storeList;
	}
	
	public static void updateStore() throws Exception {
		storeList = new ArrayList<Store>();

		String driverName = "oracle.jdbc.driver.OracleDriver";
		String jdbcURL = "jdbc:oracle:thin:@192.168.0.108:1521:XE";
		String userName = "dclub";
		String userPW = "dclub";

		String query = "select * from tbl_store";
				
		try(Connection conn = DriverManager.getConnection(jdbcURL, userName, userPW);
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs  = pstmt.executeQuery();
			){
			
			Class.forName(driverName);
			
			ResultSetMetaData md = rs.getMetaData(); 
			int column = md.getColumnCount();
			
			while(rs.next()) {	
				Store store = Store.builder().storeCode(rs.getString(1)) .name(rs.getString(2)).x(rs.getString(3)).y(rs.getString(4)).menu(rs.getString(5)).build();
				storeList.add(store);
				
			}
		
		}
		
		// debug
		for(Store store : storeList) {
			System.out.println(store);
		}

	}

	public String registerStore(HttpServletRequest request, JspWriter out) throws Exception {
		// ============================== REQUEST ===========================//
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String menu = request.getParameter("menu");

		out.print(name + ", ");
		out.print(lat + ", ");
		out.print(lng + ", ");
		out.print(menu);

		String insertQuery = "insert into TBL_STORE (sno, name, lat, lng, menu) "
				+ " values (seq_store.nextval, ?,?,?,? )";

		System.out.println("1 : " + request.getRemoteAddr());

		// =============================== JDBC ===============================//
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String jdbcURL = "jdbc:oracle:thin:@192.168.0.108:1521:XE";
		String userName = "dclub";
		String userPW = "dclub";

		String result = null;

		// Connection conn = null;
		// Statement stmt = null;
		// ResultSet rs = null; // select 만 result set이 발생한다...

		Class.forName(driverName);

		try (Connection conn = DriverManager.getConnection(jdbcURL, userName, userPW);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);) {
			System.out.println("jdbc connection completed. : " + conn);
			pstmt.setString(1, name);
			pstmt.setDouble(2, lat);
			pstmt.setDouble(3, lng);
			pstmt.setString(4, menu);

			System.out.println("Result = " + pstmt.executeUpdate());

		} catch (Exception e) {
			throw e;

		} finally {

		}

		return result;
	}

}
