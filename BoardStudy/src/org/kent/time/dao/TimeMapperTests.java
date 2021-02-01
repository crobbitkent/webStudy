package org.kent.time.dao;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests {
	TimeDAO dao;
	
	@Before
	public void ready() {
		dao = new TimeDAO();
	}
	
	@Test
	public void testGetTime() {
		try {
			log.info(dao.getTime());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
