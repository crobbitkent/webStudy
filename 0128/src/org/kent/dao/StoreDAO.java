package org.kent.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kent.dao.mapper.MyBatisMaker;
import org.kent.domain.Store;

public class StoreDAO {

	private final String namespace = "org.kent.dao.mapper.StoreMapper";
	
	public List<Store> getAll() {
		
		List<Store> result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			// 준비물 챙기는 곳
			// 준비물 어디있어? namespace에 있다.
			/*List<Store>*/ result = session.selectList(namespace + ".getAll");
			// Store result = session.selectOne(namespace + ".getOne");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
