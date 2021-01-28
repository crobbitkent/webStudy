package org.keroro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.keroro.common.DriverInfo;
import org.keroro.domain.Review;
import org.keroro.domain.Store;
import org.keroro.dto.ReviewDTO;

public class ReviewDAO {
	
	
	// db에 isnert
	public void insert(Review review) throws Exception {
		// debug
		System.out.println("debug : review insert + " + review);

		// url을 이동시켜 더이상 f5를 쓰지 못하게 막는다!!!

		// 1. sql문
		String query = "insert into TBL_REVIEW(rno, sno, mid, score, text) VALUES (seq_review.nextval, ?, ?, ?, ?)";

		Class.forName(DriverInfo.driverName);
		
		// 2. connection
		// 3. preparedStatement
		try (Connection conn = DriverManager.getConnection(DriverInfo.jdbcURL, DriverInfo.userName, DriverInfo.userPW);
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setLong(1, review.getSno());
			pstmt.setString(2, review.getMid());
			pstmt.setLong(3, review.getScore());
			pstmt.setString(4, review.getText());

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		// 4. close
	}
	
	
	
	public List<ReviewDTO> selectAll(Long sno) throws Exception {
		// 1. sql문
		String query = "select R.rno, S.name, R.mid, R.text, R.score, R.REVIEWDATE, R.UPDATEDATE from tbl_store S, tbl_review R "
				+ "where S.sno = R.sno and S.sno = ? order by R.rno DESC";

		// 2. Connection
		// 3. PreparedStatement
		// 3-1. ResultSet

		Class.forName(DriverInfo.driverName);

		List<ReviewDTO> list = new ArrayList<>();

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
				ReviewDTO review = ReviewDTO.builder().rno(rs.getLong(1)).storeName(rs.getString(2)).mid(rs.getString(3)).text(rs.getString(4))
						.score(rs.getLong(5)).reviewdate(rs.getDate(6)).updatedate(rs.getDate(7))
						.build();

				list.add(review);
			}

			long afterTime = System.currentTimeMillis();
			long secDiffTime = (afterTime - beforeTime); //
			System.out.println("ReviewDTO selectAll db 시간 : " + secDiffTime);

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

		// 4. close

		return list;
	}
	
}
