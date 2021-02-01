package store.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import common.MyBatisMaker;
import lombok.Getter;
import store.domain.Store;

@Getter
public class StoreDAO {

	private final String NAMESPACE = "store.dao.StoreMapper";
	
	public List<Store> getAll() {		
		List<Store> result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			result = session.selectList(NAMESPACE + ".getAll");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;	
	}
		
	// sno을 통해서 가게 하나를 찾아온다.
	public Store getOne(Long sno) {
		Store result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			// 준비물 챙기는 곳
			// 준비물 어디있어? namespace에 있다.
			/*List<Store>*/ result = session.selectOne(NAMESPACE + ".getOne", sno);
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
