package org.kent.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.kent.dao.mapper.MyBatisMaker;

public class MemberMapperTests {

	@Test
	public void testTime() {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			// System.out.println(""+ session.selectList("org.kent.dao.mapper.MemberMapper.getAll"));
			  
			List<Object> list = session.selectList("org.kent.dao.mapper.MemberMapper.getAll");
			
			list.forEach(o -> System.out.println(o));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
