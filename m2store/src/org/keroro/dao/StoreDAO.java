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

import org.keroro.common.DebugManager;
import org.keroro.common.DriverInfo;
import org.keroro.domain.Store;

// dao에서 입출력하지 마라.
// jsp에서 request 가져 오지 마라.
public class StoreDAO {

	static private StoreDAO dao;
	static private List<Store> storeList;

	public StoreDAO() {
	}

	// singleton
	static public StoreDAO getInstance() {
		if (null == dao) {
			dao = new StoreDAO();
		}

		return dao;
	}

	// db에 isnert
	public void insert(Store store) throws Exception {
		// debug
		System.out.println("debug : insert + " + store);

		// url을 이동시켜 더이상 f5를 쓰지 못하게 막는다!!!

		// 1. sql문
		String query = "insert into tbl_store (sno, name, lat, lng, menu) " + "values(seq_store.nextval, ?,?,?,?)";

		Class.forName(DriverInfo.driverName);
		
		// 2. connection
		// 3. preparedStatement
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setString(1, store.getName());
			pstmt.setDouble(2, store.getLat());
			pstmt.setDouble(3, store.getLng());
			pstmt.setString(4, store.getMenu());

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		// 4. close
	}

	// 먹쉬돈나
	// 따라서 query가 빨라야한다.
	public List<Store> selectAll() throws Exception {
		// 1. sql문
		String query = "SELECT sno, name, lat, lng, menu," + "regdate, updatedate FROM TBL_STORE ORDER BY sno DESC";

		// 2. Connection
		// 3. PreparedStatement
		// 3-1. ResultSet

		Class.forName(DriverInfo.driverName);

		List<Store> list = new ArrayList<>();

		// 시간 재보자
		long beforeTime = System.currentTimeMillis();
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				Store store = Store.builder().storeCode(rs.getLong(1)).name(rs.getString(2)).lat(rs.getDouble(3))
						.lng(rs.getDouble(4)).menu(rs.getString(5)).regdate(rs.getDate(6)).updatedate(rs.getDate(7))
						.build();

				list.add(store);
			}

			long afterTime = System.currentTimeMillis();
			long secDiffTime = (afterTime - beforeTime); //
			System.out.println("StoreDAO db 시간 : " + secDiffTime);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// 4. close

		return list;
	}

	public static List<Store> getList() {
		return storeList;
	}

	public static void updateStore() throws Exception {
		storeList = new ArrayList<Store>();

		String query = "select * from tbl_store";

		Class.forName(DriverInfo.driverName);
		
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {

		

			ResultSetMetaData md = rs.getMetaData();
			int column = md.getColumnCount();

//			while(rs.next()) {	
//				Store store = Store.builder().storeCode(rs.getString(1)) .name(rs.getString(2)).x(rs.getString(3)).y(rs.getString(4)).menu(rs.getString(5)).build();
//				storeList.add(store);
//			}

		}

		// debug
		for (Store store : storeList) {
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

		String result = null;

		// Connection conn = null;
		// Statement stmt = null;
		// ResultSet rs = null; // select 만 result set이 발생한다...

		Class.forName(DriverInfo.driverName);

		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
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

	public Store selectOne(Long sno) throws Exception {
		String query = "SELECT sno, name, lat, lng, menu," + "regdate, updatedate FROM TBL_STORE WHERE sno =?";

		// 2. Connection
		// 3. PreparedStatement
		// 3-1. ResultSet

		Class.forName(DriverInfo.driverName);

		Store result = new Store();

		// 시간 재보자
		long beforeTime = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, sno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.setStoreCode(rs.getLong(1));
				result.setName(rs.getString(2));
				result.setLat(rs.getDouble(3));
				result.setLng(rs.getDouble(4));
				result.setMenu(rs.getString(5));
				result.setRegdate(rs.getDate(6));
				result.setUpdatedate(rs.getDate(7));
			}

			long afterTime = System.currentTimeMillis();
			long secDiffTime = (afterTime - beforeTime); //
			System.out.println("StoreDAO db 시간 : " + secDiffTime + "ms");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}

		return result;
	}

	// delete from TBL_STORE where sno = 32;
	public void delete(Long sno) throws Exception {
		// debug
		DebugManager.printDebug("delete " + sno);

		// url을 이동시켜 더이상 f5를 쓰지 못하게 막는다!!!

		// 1. sql문
		String query = "DELETE FROM TBL_STORE where sno = ?";

		// 2. connection
		// 3. preparedStatement
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setLong(1, sno);

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// 4. close
	}

	// update tbl_store set name = ?, lat = ?, lng = ?, menu = ?, updatedate =
	// sysdate where sno = ?
	public void update(Long sno) throws Exception {
		
		// debug
		System.out.println("[debug : update " + sno);

		// url을 이동시켜 더이상 f5를 쓰지 못하게 막는다!!!

		Class.forName(DriverInfo.driverName);
		
		// 1. sql문
		String sql = "update tbl_store set name = ?, lat = ?, lng = ?, menu = ?, updatedate = sysdate where sno = ?";

		Class.forName(DriverInfo.driverName);
		
		// 2. connection
		// 3. preparedStatement
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setLong(1, sno);

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// 4. close

	}

}
