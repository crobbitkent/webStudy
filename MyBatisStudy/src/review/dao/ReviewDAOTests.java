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
	
	
	@Test
	public void testGetOne() {	
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			ReviewDTO dto = reviewDAO.getOne(10L);				
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
//	@Test
//	public void testInsert() {				
//		Store store = Store.builder().name("testName").lat(37).lng(123).menu("testMenu").build();		
//		storeDAO.insert(store);		
//	}
//	
//	@Test
//	public void testDelete() {			
//		Long sno = 43L;			
//		storeDAO.delete(sno);	
//	}
//	
//	@Test
//	public void testUpdate() {			
//		Store store = Store.builder().name("testName2").lat(37).lng(123).menu("testMenu2").sno(43L).build();			
//		storeDAO.update(store);	
//	}
}
