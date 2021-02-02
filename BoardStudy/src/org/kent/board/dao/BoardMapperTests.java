package org.kent.board.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kent.board.domain.Board;
import org.kent.board.domain.PageInfo;

public class BoardMapperTests {

	BoardDAO boardDAO;
	
	@Before
	public void ready() {
		boardDAO = new BoardDAO();
	}
	
	@Test
	public void testGetList() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(-1);
		pageInfo.setPerSheet(-1);
		
		try {
			List<Board> boardList = boardDAO.getList(pageInfo);
			
			boardList.forEach(b->System.out.println(b));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
