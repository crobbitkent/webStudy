package org.kent.time.dao;

import org.apache.ibatis.session.SqlSession;
import org.kent.common.dao.MyBatisMaker;

import lombok.Getter;

public class TimeDAO {
	@Getter
	private static final String NAMESPACE = "org.kent.time.dao.TimeMapper";
	
	
	public String getTime() {
		SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession();
		
		try {
			return session.selectOne(NAMESPACE + ".getTime");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) { try { session.close(); } catch(Exception e) { } }
		}
		
		return null;
	}
	
}
