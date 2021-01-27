<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.keroro.domain.Store"%>
<%@page import="org.keroro.dao.StoreDAO"%>

<%@ page import="java.sql.*" %>    
<%@ page import="java.util.*" %>    

<%
	// 한국 전용 모델... 이었다.
	//====================== MODEL 1.5 ============================//
	// request를 인코딩!! 그래서 항상 제일 위에...
	request.setCharacterEncoding("UTF-8");

	// parameter 수집
	String name = request.getParameter("name");
	double lat = Double.parseDouble(request.getParameter("lat"));
	double lng = Double.parseDouble(request.getParameter("lng"));
	String menu = request.getParameter("menu");
	
	// 수집한 데이터를 저장해줄 StoreDTO 생성
	Store store = Store.builder().name(name).lat(lat).lng(lng).menu(menu).build();

	System.out.println(store);
	
	response.sendRedirect("/store/list.jsp");
	
	
	
%>


