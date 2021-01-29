package review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import common.MyBatisMaker;
import review.dto.ReviewDTO;
import store.domain.Store;

public class ReviewDAOTests {

	private ReviewDAO reviewDAO;
	
	@Before
	public void ready() {
		reviewDAO = new ReviewDAO();
	}
	
	@Test
	public void testGetAll() {	
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			List<ReviewDTO> list = reviewDAO.getAll(12L);			
			
			
			list.forEach(r-> System.out.println(r));		
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
