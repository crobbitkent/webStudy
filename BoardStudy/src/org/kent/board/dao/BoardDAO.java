package org.kent.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kent.board.domain.Board;
import org.kent.board.domain.PageInfo;
import org.kent.common.dao.MyBatisMaker;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAO {
	
	private static final String NAMESPACE = "org.kent.board.dao.BoardMapper";
	
	public List<Board> getList(PageInfo pageInfo) throws Exception{
		SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession();
		
		try {
			return session.selectList(NAMESPACE + ".getList", pageInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) { try { session.close(); } catch(Exception e) { } }
		}
		
		return null;
	}
	
	
}
