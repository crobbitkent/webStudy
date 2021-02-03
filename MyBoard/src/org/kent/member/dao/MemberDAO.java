package org.kent.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kent.board.domain.Board;
import org.kent.common.dao.BaseDAO;
import org.kent.common.util.PageInfo;
import org.kent.member.domain.Member;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDAO extends BaseDAO {

	private static final String NAMESPACE = "org.kent.member.dao.MemberMapper";
	
	public int getTotal() throws Exception{
		log.debug("member get total");		
		
		SqlSession session = getSession();
		try {
			return session.selectOne(NAMESPACE + ".getTotal");	
		} catch(Exception e) {
			
			e.printStackTrace();		
		} finally {
			close(session);
		}
		
		return 0;
	}
	
	public void insert(Member member) throws Exception {
		// debug
		log.debug("member insert : " + member);		
		
		SqlSession session = getSession();
		try {
			session.insert(NAMESPACE + ".insert", member);
			session.commit();
			
		} catch(Exception e) {			
			e.printStackTrace();		
		} finally {
			close(session);
		}

	}
	
	public List<Member> getAll() throws Exception{
		log.debug("member getAll");	
		
		SqlSession session = getSession();
		
		try {
			return session.selectList(NAMESPACE + ".getAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(session);
		}
		
		return null;
	}
	
	public List<Member> getList(PageInfo pageInfo) throws Exception{
		log.debug("member getList");	
		
		SqlSession session = getSession();
		
		try {
			return session.selectList(NAMESPACE + ".getList", pageInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(session);
		}
		
		return null;
	}
	
	
	
}
