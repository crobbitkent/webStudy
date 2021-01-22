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
import org.keroro.util.JdbcManager;

public class StoreDAO {
	private static StoreDAO dao;
	private List<Store> storeList;
	private static int currentIndex;

	private StoreDAO() {
		this.currentIndex = 0;
	}

	public static StoreDAO getInstance() {
		if (null == dao) {
			dao = new StoreDAO();
		}

		return dao;
	}

	public List<Store> getList(){
		return this.storeList;
	}
	
	public void updateStore() throws Exception {
		String query = "select * from tbl_store";
				
		try(Connection conn = DriverManager.getConnection(
				JdbcManager.URL, JdbcManager.USER_ID, JdbcManager.USER_PW);
				
			// ResultSet 양방향 이동을 가능하게 하기 위한 파라미터
			PreparedStatement pstmt = 
					conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs  = pstmt.executeQuery();
			){
			
			Class.forName(JdbcManager.DRIVER_NAME);
			
			// 새로 만들면... 첫 접속이기 때문에 모든 데이터를 가져온다.
			if(null == this.storeList) {			
				this.storeList = new ArrayList<Store>();
			// 아니라면 마지막에 있던 부분부터 데이터를 가져온다.	
			} else {
				rs.absolute(storeList.size());
			}
			
			while(rs.next()) {	
				Store store = Store.builder().storeCode(rs.getString(1)).name(rs.getString(2)).x(rs.getString(3)).y(rs.getString(4)).menu(rs.getString(5)).build();
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
		
		String insertQuery = "insert into TBL_STORE (sno, name, lat, lng, menu) "
				+ " values (seq_store.nextval, ?,?,?,? )";
		
		String name = request.getParameter("name");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String menu = request.getParameter("menu");

		
		out.print(name + ", ");
		out.print(lat + ", ");
		out.print(lng + ", ");
		out.print(menu + " (이)가 맛집으로 등록되었습니다.");
		out.print("<br/>");

		System.out.println("1 : " + request.getRemoteAddr());

		// =============================== JDBC ===============================//
		String result = null;

		// Connection conn = null;
		// Statement stmt = null;
		// ResultSet rs = null; // select 만 result set이 발생한다...

		Class.forName(JdbcManager.DRIVER_NAME);

		try (Connection conn = DriverManager.getConnection(
				JdbcManager.URL, JdbcManager.USER_ID, JdbcManager.USER_PW);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);
				) {
			System.out.println("jdbc connection completed. : " + conn);
			pstmt.setString(1, name);
			pstmt.setDouble(2, lat);
			pstmt.setDouble(3, lng);
			pstmt.setString(4, menu);

			System.out.println("Result = " + pstmt.executeUpdate());

		} catch (Exception e) {
			throw e;
		}

		return result;
	}

}
