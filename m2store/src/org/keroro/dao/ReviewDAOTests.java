package org.keroro.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.domain.Member;
import org.keroro.domain.Review;
import org.keroro.dto.ReviewDTO;

public class ReviewDAOTests {

	ReviewDAO dao;
	
	@Before
	public void ready() {
		dao = new ReviewDAO();
	}
	
	@Test
	public void testSelectAll() throws Exception {
		ReviewDAO dao = new ReviewDAO();
		List<ReviewDTO> reviewList = dao.selectAll(12L);
		
		for (ReviewDTO review : reviewList) {
			System.out.println(review);
		}		
	}
	
	@Test
	public void testInsert() throws Exception {
		ReviewDAO dao = new ReviewDAO();
		
		Review review = Review.builder().sno(2L).mid("mingyuadmin").score(4L).text("빵이 부드러워요.").build();		
		
		dao.insert(review);
	}
	
}
