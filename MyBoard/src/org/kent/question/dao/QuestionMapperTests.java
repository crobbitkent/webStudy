package org.kent.question.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kent.board.domain.Board;
import org.kent.common.util.PageInfo;
import org.kent.common.util.PageMaker;
import org.kent.question.QuestionDTO;
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
			QuestionDTO dto = QuestionDTO.builder().difficulty(1).mid("admin").build();
			Long total = questionDAO.getTotal(dto);
			Long random = (long) (Math.random() * total);
			
			log.info("TOTAL = " + total);
			log.info("RANDOM = " + random);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetOne() {

		try {
			long beforeTime = System.currentTimeMillis();
			
			QuestionDTO dto = QuestionDTO.builder().difficulty(1).mid("admin").build();		
			Long total = questionDAO.getTotal(dto);		
			Long random = (long) (Math.random() * total);
			dto.setRandom(random);			
			Question q = questionDAO.getOne(dto);
			
		    long afterTime = System.currentTimeMillis();
			long secDiffTime = (afterTime - beforeTime); //
			System.out.println("StoreDAO db 시간 : " + secDiffTime);
			
			log.info("TOTAL = " + total);
			log.info("RANDOM = " + random);
			log.info(q.getQno());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
