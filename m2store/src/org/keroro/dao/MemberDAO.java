package org.keroro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.keroro.common.DriverInfo;
import org.keroro.domain.Member;
import org.keroro.domain.Store;

public class MemberDAO {

	
	public int insert(Member member) throws Exception {
		
		String sql = "insert into TBL_MEMBER(mid, mpw, mname) VALUES (?,?,?)";
		
		Class.forName(DriverInfo.driverName);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			
			pstmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
			
		}finally {
			if(con != null) { try { con.close(); } catch(Exception e) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(Exception e) { } }
		}
		return 1;
	}
	
	public void modify(Member member) throws Exception{
		
		// debug
		System.out.println("[debug : update " + member);

		// url을 이동시켜 더이상 f5를 쓰지 못하게 막는다!!!

		// 1. sql문
		String sql = "update tbl_member set mpw = ?, mname = ?, updatedate = sysdate where mid = ?";
		
		Class.forName(DriverInfo.driverName);

		// 2. connection
		// 3. preparedStatement
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMid());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// 4. close
	}
	public void delete(Member member) throws Exception{
		
		// debug
		System.out.println("[debug : delete " + member);

		// url을 이동시켜 더이상 f5를 쓰지 못하게 막는다!!!

		// 1. sql문
		String sql = "delete tbl_member where mid=? and mpw=?";
		
		Class.forName(DriverInfo.driverName);

		// 2. connection
		// 3. preparedStatement
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getPw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// 4. close
	}
	

	public List<Member> selectAll () throws Exception {
		
		String sql = "select * from TBL_MEMBER order by mid";
		
		Class.forName(DriverInfo.driverName);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> memberList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member member = Member.builder()
						.mid(rs.getString(1))
						.pw(rs.getString(2))
						.name(rs.getString(3))
						.regdate(rs.getDate(4))
						.updatedate(rs.getDate(5))
						.build();
					
				memberList.add(member);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			if(con != null) { try { con.close(); } catch(Exception e) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(Exception e) { } }
			if(rs != null) { try { rs.close(); } catch(Exception e) { } }
		}
		
		return memberList;
		
	}
	
	public Member selectOne(String id) throws Exception{
		String query = "SELECT * FROM TBL_MEMBER WHERE mid = ?";

		// 2. Connection
		// 3. PreparedStatement
		// 3-1. ResultSet

		Class.forName(DriverInfo.driverName);

		Member result = new Member();

		// 시간 재보자
		long beforeTime = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.setMid(rs.getString(1));
				result.setPw(rs.getString(2));
				result.setName(rs.getString(3));
				result.setRegdate(rs.getDate(4));
				result.setUpdatedate(rs.getDate(5));
			}

			long afterTime = System.currentTimeMillis();
			long secDiffTime = (afterTime - beforeTime); //
			System.out.println("MemberDAO selectOne 시간 : " + secDiffTime + "ms");

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
					pstmt.close();
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
}
