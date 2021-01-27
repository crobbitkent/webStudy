package org.keroro.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.domain.Member;
import org.keroro.domain.Store;

public class MemberDAOTests {
	
	MemberDAO dao;
	
	@Before
	public void ready() {
		dao = new MemberDAO();
	}
	
	@Test
	public void testInsert() throws Exception{
		Member member = Member.builder().mid("user01").pw("1111").name("장민우").build();
		
		dao.insert(member);
		System.out.println(member);
		// dao.delete(store.getStoreCode());
	}
	
	@Test
	public void testModify() throws Exception {
		Member member = Member.builder().mid("user03").pw("3333").name("상민규2").build();
		
		dao.modify(member);
		System.out.println(member);
	}
	@Test
	public void testDelete() throws Exception {
		Member member = Member.builder().mid("user01").pw("1111").build();
		
		dao.delete(member);
		System.out.println(member);
	}
	
	@Test
	public void testSelectAll() throws Exception {
		MemberDAO dao = new MemberDAO();
		List<Member> memberList = dao.selectAll();
		
		for (Member member : memberList) {
			System.out.println(member);
		}
		
	}
	
	@Test
	public void testSelectOne() throws Exception {
		Member member= dao.selectOne("user02");
		
		System.out.println(member);
	}
}
