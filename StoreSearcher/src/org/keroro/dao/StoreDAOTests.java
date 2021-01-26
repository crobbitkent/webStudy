package org.keroro.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.domain.Store;


public class StoreDAOTests {
	
	StoreDAO dao;
	
	@Before
	public void ready() {
		dao = StoreDAO.getInstance();
	}
	
	@Test
	public void testInsert() throws Exception{
		Store store = Store.builder().name("test").lat(37.0000).lng(127.0000).menu("testMenu").build();
		
		dao.insert(store);
		System.out.println(store);
		// dao.delete(store.getStoreCode());
		
		
	}
	
	@Test
	public void testList() throws Exception{
		List<Store> stores = dao.selectAll();
		
		stores.forEach(store->System.out.println(store));
	}
	
	@Test
	public void testSelectOne() throws Exception{
		Store store = dao.selectOne(41L);
		System.out.println(store);
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(41L);
		List<Store> stores = dao.selectAll();
		stores.forEach(store->System.out.println(store));
	}
	
	@Test
	public void update() throws Exception{
		Store store = Store.builder().name("testUpdate").lat(37.0000).lng(127.0000).menu("testMenuUpdate").build();
		dao.insert(store);
		
		dao.update(store.getStoreCode());
		List<Store> stores = dao.selectAll();
		stores.forEach(s->System.out.println(s));
		dao.delete(store.getStoreCode());
	}
	
	
	
	
}
