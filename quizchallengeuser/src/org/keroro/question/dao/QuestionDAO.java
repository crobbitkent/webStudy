package org.keroro.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;
import org.keroro.common.util.PageInfo;
import org.keroro.question.dto.PageInfoDTO;
import org.keroro.question.dto.QhistoryDTO;

public class QuestionDAO extends BaseDAO{

	private static final String NAMESPACE = "org.keroro.question.dao.QuestionMapper";

	public List<QhistoryDTO> getMyHistory(String mid) {
		try (SqlSession session = getSession()) {
			return session.selectList(NAMESPACE + ".getMyHistory", mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getTotalOfMyHistory(String mid) {
		try (SqlSession session = getSession()) {
			return session.selectOne(NAMESPACE + ".getTotalOfMyHistory", mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public List<QhistoryDTO> getPageListOfMyHistory(String mid, PageInfo info) {
		try (SqlSession session = getSession()) {
			PageInfoDTO dto = PageInfoDTO.builder().page(info.getPage()).perSheet(info.getPerSheet()).mid(mid).build();
			
			return session.selectList(NAMESPACE + ".getPageListOfMyHistory", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
