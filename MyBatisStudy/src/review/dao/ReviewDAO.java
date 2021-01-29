package review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MyBatisMaker;
import review.dto.ReviewDTO;
import store.domain.Store;

public class ReviewDAO {

	private final String namespace = "review.dao.ReviewMapper";
	
	public List<ReviewDTO> getAll(Long sno) {
		List<ReviewDTO> result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			// 준비물 챙기는 곳
			// 준비물 어디있어? namespace에 있다.
			/*List<Store>*/ result = session.selectList(namespace + ".getAll", sno);
			// Store result = session.selectOne(namespace + ".getOne");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;		
	}
	
}
