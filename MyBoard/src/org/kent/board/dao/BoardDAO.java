package org.kent.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kent.board.domain.Board;
import org.kent.common.dao.BaseDAO;
import org.kent.common.dao.MyBatisMaker;
import org.kent.common.util.PageInfo;
import org.kent.time.dao.TimeDAO;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAO extends BaseDAO{
	@Getter
	private static final String NAMESPACE = "org.kent.board.dao.BoardMapper";

	public int getTotal() throws Exception{
		log.debug("board get total");		
		
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
	
	public void insert(Board board) throws Exception {
		// debug
		log.debug("board insert : " + board);		
		
		SqlSession session = getSession();
		try {
			session.insert(NAMESPACE + ".insert", board);
			session.commit();
			
		} catch(Exception e) {
			
			e.printStackTrace();		
		} finally {
			close(session);
		}

	}

	public List<Board> getAll() throws Exception {
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

	public Board getOne(Long bno) throws Exception {
		SqlSession session = getSession();

		try {
			return session.selectOne(NAMESPACE + ".getOne", bno);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(session);
		}

		return null;
	}

	public void update(Board board) throws Exception {
		SqlSession session = getSession();

		try {
			session.update(NAMESPACE + ".update", board);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(session);
		}
	}

	public void delete(Long bno) throws Exception {
		SqlSession session = getSession();

		try {
			session.delete(NAMESPACE + ".delete", bno);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(session);
		}
	}
	
	public List<Board> getList(PageInfo pageInfo) throws Exception{
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
