package member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import common.MyBatisMaker;
import member.domain.Member;

public class MemberDAO {

	private final String namespace = "member.dao.MemberMapper";
	
	public List<Member> getAll() {
		
		List<Member> result = null;
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			result = session.selectList(namespace + ".getAll");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
