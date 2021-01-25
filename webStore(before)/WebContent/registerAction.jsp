<%@page import="org.keroro.domain.Store"%>
<%@page import="org.keroro.dao.StoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%@ page import="java.util.*" %>    

<%
	
	StoreDAO dao = StoreDAO.getInstance();
	dao.registerStore(request, out);
	dao.updateStore();
	
	List<Store> list = StoreDAO.getList();
	
	for(int i = 0; i < list.size(); ++i)
	{
		out.print(list.get(i));
		out.print("\n");
	}

%>



