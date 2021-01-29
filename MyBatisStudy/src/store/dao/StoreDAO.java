package store.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import common.MyBatisMaker;
import lombok.Getter;
import store.domain.Store;

@Getter
public class StoreDAO {

	private final String namespace = "store.dao.StoreMapper";
	
	public List<Store> getAll() {		
		List<Store> result = null;
		
		// 우주선 준비(달 = DB)
		// 준비물 = 쿼리
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			// 준비물 챙기는 곳
			// 준비물 어디있어? namespace에 있다.
			/*List<Store>*/ result = session.selectList(namespace + ".getAll");
			// Store result = session.selectOne(namespace + ".getOne");
			for(Store store : result) {
				System.out.println(store);
			}
			
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
			/*List<Store>*/ result = session.selectOne(namespace + ".getOne", sno);
			// Store result = session.selectOne(namespace + ".getOne");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;		
	}
	
}
