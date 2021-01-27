<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.keroro.dao.*"%>
<%@page import="org.keroro.domain.*"%>


<%
	request.setCharacterEncoding("UTF-8");

	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	
	Member member = Member.builder().mid(mid).pw(mpw).build();
	MemberDAO dao = new MemberDAO();
	dao.delete(member);
	
	response.sendRedirect("/member/memberList.jsp");
%>