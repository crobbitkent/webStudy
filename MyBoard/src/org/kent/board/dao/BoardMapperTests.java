package org.kent.board.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kent.board.domain.Board;
import org.kent.board.domain.PageInfo;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {
	BoardDAO boardDAO;

	@Before
	public void ready() {
		boardDAO = new BoardDAO();
	}

	@Test
	public void testGetAll() {

		try {
			List<Board> list = boardDAO.getAll();

			for (Board b : list) {
				log.info(b.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetOne() {
		try {
			Board board = boardDAO.getOne(5L);
			log.info(board.getTitle());		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		try {
			Board board = Board.builder().bno(5L).title("업데이트 테스트 제목 5").content("업데이트 테스트 컨텐트 5").build();
			boardDAO.update(board);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		try {		
			boardDAO.delete(5L);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		try {
			Board board = Board.builder().title("테스트").content("테스트 내용").writer("mingyuadmin").build();	
			boardDAO.insert(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetList() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(9);
		pageInfo.setPerSheet(10);
		
		try {
			List<Board> boardList = boardDAO.getList(pageInfo);
			
			boardList.forEach(b->System.out.println(b));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
