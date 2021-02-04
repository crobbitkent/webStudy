package org.kent.question.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kent.board.domain.Board;
import org.kent.common.util.PageInfo;
import org.kent.common.util.PageMaker;
import org.kent.question.domain.Question;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionMapperTests {
	QuestionDAO questionDAO;

	@Before
	public void ready() {
		questionDAO = new QuestionDAO();
	}
	
	@Test
	public void testGetTotal() {
		try {
			int total = questionDAO.getTotal();
		log.info(total);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetAll() {

		try {
			int total = questionDAO.getTotal();
			Question q = questionDAO.getAll(total);


			log.info(q.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
