package org.kent.question.dao;

import org.apache.ibatis.session.SqlSession;
import org.kent.board.domain.Board;
import org.kent.common.dao.BaseDAO;
import org.kent.question.QuestionDTO;
import org.kent.question.domain.Question;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAO extends BaseDAO{

	private static final String NAMESPACE = "org.kent.question.dao.QuestionMapper";
	
	public Long getTotal(QuestionDTO dto) throws Exception{
		SqlSession session = getSession();
		log.debug("question get total");		
		
		try {
			return session.selectOne(NAMESPACE + ".getTotal", dto);	
		} catch(Exception e) {
			
			e.printStackTrace();		
		} finally {
			close(session);
		}
		
		return 0L;
	}
	
	public Question getOne(QuestionDTO dto) throws Exception {
		SqlSession session = getSession();

		try {
			return session.selectOne(NAMESPACE + ".getOne", dto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(session);
		}

		return null;
	}
}
