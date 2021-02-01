package review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MyBatisMaker;
import review.dto.ReviewDTO;
import store.domain.Store;

public class ReviewDAO {

	private final String NAMESPACE = "review.dao.ReviewMapper";
	
	public List<ReviewDTO> getAll(Long sno) {
		List<ReviewDTO> result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			// 준비물 챙기는 곳
			// 준비물 어디있어? namespace에 있다.
			/*List<Store>*/ result = session.selectList(NAMESPACE + ".getAll", sno);
			// Store result = session.selectOne(namespace + ".getOne");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;		
	}
	
	// sno을 통해서 가게 하나를 찾아온다.
	public ReviewDTO getOne(Long rno) {
		ReviewDTO result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			// 준비물 챙기는 곳
			// 준비물 어디있어? namespace에 있다.
			/*List<Store>*/ result = session.selectOne(NAMESPACE + ".getOne", rno);
			// Store result = session.selectOne(namespace + ".getOne");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;		
	}
	
	
	public void insert(Store store) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){

			session.insert(NAMESPACE + ".insert", store);
			session.commit();
			
		} catch(Exception e) {
			e.printStackTrace();		
		}		
	}
	
	public void delete(Long sno) {
		
		SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession(false);
		
		try {
			// TRANSACTION 필요
			
			// 외래키가 있는 review를 먼저 지워야한다.
			session.delete(NAMESPACE + ".deleteReview", sno);
			// 그 다음 store을 삭제한다.
			session.delete(NAMESPACE + ".delete", sno);
			
			session.commit();
			
		} catch(Exception e) {	
			session.rollback();
			e.printStackTrace();	
		} finally {
			if(session != null) { try { session.close(); } catch(Exception e) { } }
		}
	}
	
	public void update(Store store) {
	// TRANSACTION 필요
		SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession(false);
		
		try {	
			// 외래키가 있는 review를 먼저 지워야한다.
			session.update(NAMESPACE + ".update", store);
			// 그 다음 store을 삭제한다.
			
			session.commit();
			
		} catch(Exception e) {	
			session.rollback();
			e.printStackTrace();	
		} finally {
			if(session != null) { try { session.close(); } catch(Exception e) { } }
		}
	}
	
}
