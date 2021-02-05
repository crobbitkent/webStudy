package org.keroro.question.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.common.util.ExcelReader;
import org.keroro.common.util.PageInfo;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QuestionDTO;
import org.keroro.question.util.QuestionExcelLoader;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAOTests {
	private QuestionDAO dao;
	
	@Before
	public void ready() {
		dao = new QuestionDAO();
	}
	
	@Test
	public void testGetPagedListOfQuestion() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(24);	

		try {
			List<Question> list = dao.getPagedListOfQuestion(pageInfo);
			list.forEach(q->log.info(q.getQno()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTotal() {	
		try {
			QuestionDTO dto = QuestionDTO.builder().difficulty(1).mid("mingyu").build();
			Long total = dao.getTotalOfQuestion(dto);
			Long random = (long) (Math.random() * total);
			
			log.info(total);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertQuestion() {
		try {
			Question q = Question.builder()
					.aid("mingyuAdmin").quiz("insertTest").answer("insertAnswer").difficulty(1)
					.build();
			
			dao.insertQuestion(q);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertQuestionByExcel() {
		try {
			QuestionExcelLoader loader = new QuestionExcelLoader("C:\\upload\\test.xlsx");

			List<Question> list = loader.load();
			
			for(Question q : list) {
				dao.insertQuestion(q);				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//===========================QHISTORY TEST========================//
	//===========================QHISTORY TEST========================//
	//===========================QHISTORY TEST========================//
	@Test
	public void testGetPagedListOfQhistory() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(2);	

		try {
			List<Qhistory> list = dao.getPagedListOfQhistory(pageInfo);
			list.forEach(q->log.info(q.getHno()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertQhistory() {
		try {
			
			
			// dao.insertQuestion(q);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
