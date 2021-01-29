package org.kent.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kent.dao.mapper.MyBatisMaker;
import org.kent.domain.Member;
import org.kent.domain.Store;

public class MemberDAO {

	private final String namespace = "org.kent.dao.mapper.MemberMapper";
	
	public List<Member> getAll() {
		
		List<Member> result = null;
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			result = session.selectList(namespace + ".getAll");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
