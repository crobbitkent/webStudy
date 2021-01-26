package org.keroro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TimeDAO {
	// driver class name
	// url
	// username
	// pwd
	
	public String getTime() throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String jdbcURL = "jdbc:oracle:thin:@192.168.0.108:1521:XE";
		String userName = "dclub";
		String userPW = "dclub";
		
		String result = null;
		
		// Connection conn = null;
		// Statement stmt = null;
		// ResultSet rs = null; // select 만 result set이 발생한다... 
		
		Class.forName(driverName);
		
		String query = "select sysdate from dual";
		
		try(Connection conn = DriverManager.getConnection(jdbcURL, userName, userPW);
			PreparedStatement pstmt = conn.prepareStatement(query);
				// 블락처리... 일반적으로 3초안에 수행되기를 희망
			ResultSet rs = pstmt.executeQuery();
				){
			System.out.println("jdbc connection completed. : " + conn);
			
			rs.next();
			
			result = rs.getString(1);
			
			
		}catch(Exception e) {
			throw e;
			
		}finally{
			
		}
		
		
		return result;
	}
	
	
}
