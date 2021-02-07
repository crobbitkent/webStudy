package org.keroro.member.dao;

import org.junit.Before;
import org.junit.Test;
import org.keroro.member.domain.Member;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberMapperTests {

	private MemberDAO memberDAO;
	
	@Before
	public void ready(){
		memberDAO = new MemberDAO();
	}
	
	@Test
	public void testMember() {
		Member m = Member.builder().mid("mingyu").build();
		log.info(memberDAO.getMember(m));
		
	}
}
