package member.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import common.MyBatisMaker;
import member.dao.MemberDAO;
import member.domain.Member;

public class MemberDAOTests {
	private MemberDAO memberDAO;
	
	@Before
	public void ready() {
		memberDAO = new MemberDAO();
	}
	
	@Test
	public void testGetAll() {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			// System.out.println(""+ session.selectList("org.kent.dao.mapper.MemberMapper.getAll"));
			  
			List<Member> list = memberDAO.getAll();
			
			list.forEach(o -> System.out.println(o));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
