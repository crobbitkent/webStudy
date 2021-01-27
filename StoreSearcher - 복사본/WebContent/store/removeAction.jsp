<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@page import="org.keroro.dao.StoreDAO"%>

   
<%
	Long sno = Long.parseLong(request.getParameter("sno"));

	System.out.println("removeAction : " + sno);

	StoreDAO dao = StoreDAO.getInstance();
	dao.delete(sno);
	response.sendRedirect("/store/list.jsp");
%>

    