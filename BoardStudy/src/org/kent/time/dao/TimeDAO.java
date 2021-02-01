package org.kent.time.dao;

import org.apache.ibatis.session.SqlSession;
import org.kent.common.dao.MyBatisMaker;


public class TimeDAO {
	private final String NAMESPACE = "org.kent.time.dao.TimeMapper";

	public String getTime() throws Exception {
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
