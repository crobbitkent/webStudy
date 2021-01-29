package store.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import common.MyBatisMaker;
import member.domain.Member;
import store.dao.StoreDAO;
import store.domain.Store;

public class StoreDAOTests {

	private StoreDAO storeDAO;

	@Before
	public void ready() {
		storeDAO = new StoreDAO();
	}
	
	@Test
	public void testGetAll() {	
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {	  
			List<Store> list = storeDAO.getAll();			
			list.forEach(o -> System.out.println(o));			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetOne() {	
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			Store store = storeDAO.getOne(10L);			
			System.out.println(store);		
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
