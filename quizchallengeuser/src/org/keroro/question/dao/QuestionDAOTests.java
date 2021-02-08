package org.keroro.question.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.common.util.PageInfo;
import org.keroro.question.dto.QhistoryDTO;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAOTests {
	private QuestionDAO dao;
	
	@Before
	public void ready() {
		dao = new QuestionDAO();
	}
	
	@Test
	public void testGetMyHistory() {
		List<QhistoryDTO> list = dao.getMyHistory("mingyu");
		list.forEach(q->log.info(q));
	}
	
	@Test
	public void testGetTotalOfMyHistory() {
		int result = dao.getTotalOfMyHistory("mingyu");
		log.info(result);
	}
	
	@Test
	public void testGetPagedListOfMyHistory() {
		PageInfo info = PageInfo.builder().page(2).perSheet(10).build();
		
		List<QhistoryDTO> list  = dao.getPageListOfMyHistory("hj", info);
		list.forEach(q->log.info(q));
	}
}
