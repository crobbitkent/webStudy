package org.keroro.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;
import org.keroro.member.domain.Member;

public class MemberDAO extends BaseDAO {

	private static final String NAMESPACE = "org.keroro.member.dao.MemberMapper";

	// test
	public Member getMember(Member member) {
		try (SqlSession session = getSession()) {
			return session.selectOne(NAMESPACE + ".getMemberOne", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
