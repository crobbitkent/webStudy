package org.kent.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.kent.dao.mapper.MyBatisMaker;

public class TimeMapperTests {

	@Test
	public void testTime() {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			System.out.println(""+ session.selectOne("org.kent.dao.mapper.TimeMapper.getTime"));
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
