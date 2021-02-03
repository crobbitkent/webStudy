package org.kent.member.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kent.board.domain.Board;
import org.kent.common.util.PageInfo;
import org.kent.member.domain.Member;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberMapperTests {

	private MemberDAO memberDAO;
	
	@Before
	public void ready() {
		memberDAO = new MemberDAO();
	}

	@Test
	public void testGetTotal() {
		try {
			int total = memberDAO.getTotal();
			log.info(total);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		

		try {
			Member member= Member.builder().mid("admin").mpw("1234").mname("mingyu").build();	
			memberDAO.insert(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetAll() {
		try {
			List<Member> list = memberDAO.getAll();
			list.forEach(m-> log.info(m));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetList() {
		try {
			PageInfo pageInfo = new PageInfo();
			pageInfo.setPage(9);
			pageInfo.setPerSheet(10);
			
			List<Member> list = memberDAO.getList(pageInfo);
			list.forEach(m-> log.info(m));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
