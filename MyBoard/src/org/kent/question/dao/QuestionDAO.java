package org.kent.question.dao;

import org.apache.ibatis.session.SqlSession;
import org.kent.common.dao.BaseDAO;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAO extends BaseDAO{

	private static final String NAMESPACE = "org.kent.question.dao.QuestionMapper";
	
	public int getTotal() throws Exception{
		SqlSession session = getSession();
		log.debug("question get total");		
		
		try {
			return session.selectOne(NAMESPACE + ".getTotal");	
		} catch(Exception e) {
			
			e.printStackTrace();		
		} finally {
			close(session);
		}
		
		return 0;
	}
	
}
