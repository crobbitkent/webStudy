package org.kent.domain;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BoardTest {
	
	// bad code : throws Exception
	public static void main(String[] args) throws Exception {
		
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("title", "titleTest...");
		paramMap.put("contents", "contentsTest...");
		
		// Class를 얻는 방법1
		Class clz1 = Class.forName("org.kent.domain.Board");
		System.out.println(clz1); // : class org.kent.domain.Board
		
		// Class를 얻는 방법2
		Board obj = new Board();
		Class clz2 = obj.getClass();
		System.out.println(clz2);
		
		BeanInfo info1 = Introspector.getBeanInfo(clz1);
		BeanInfo info2 = Introspector.getBeanInfo(clz2);
		
		System.out.println(info1); // : java.beans.GenericBeanInfo@3d71d552
		System.out.println(info2); // : java.beans.GenericBeanInfo@3d71d552
		
		// ${store.name} 이 어떻게 가능할까? 이렇게 가능하다.
		PropertyDescriptor[] props = info1.getPropertyDescriptors();
		
		// 여기서 getter, setter를 찾을 수 있다.
		for( PropertyDescriptor prop : props) {
			System.out.println(prop);
			
			// 따라서 class 안에 존재하는 method를 추출해보자.
			Method setMethod = prop.getWriteMethod();
			
			if(null != setMethod) {
				
				String pName = prop.getName();
				if(null != paramMap.get(pName)) {
					setMethod.invoke(obj, paramMap.get(pName));
				}
				
				// 객체, obj인자
				
			}
		}
		
		System.out.println(obj);
		
		//============================================================================ LEVEL UP
		// 여기에 HttpServeletRequest를 넣어서 호출하면 된다.
		Class clz3 = Class.forName("org.kent.domain.Board");
		System.out.println(clz3);
		
		Object obj3 = clz3.newInstance();
		
		for( PropertyDescriptor prop : props) {
			System.out.println(prop);
			
			// 따라서 class 안에 존재하는 method를 추출해보자.
			Method setMethod = prop.getWriteMethod();
			
			if(null != setMethod) {
				
				String pName = prop.getName();
				if(null != paramMap.get(pName)) {
					setMethod.invoke(obj3, paramMap.get(pName));
				}
				
				// 객체, obj인자
				
			}
		}
		
		System.out.println(obj3);
	}
	

}
