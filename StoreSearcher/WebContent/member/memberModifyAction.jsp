<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.keroro.dao.*"%>
<%@page import="org.keroro.domain.*"%>

<%
	request.setCharacterEncoding("UTF-8");

	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	String mname = request.getParameter("mname");

	Member member = Member.builder().mid(mid).pw(mpw).name(mname).build();
	MemberDAO dao = new MemberDAO();
	dao.modify(member);

	// redirect
	response.sendRedirect("/member/memberList.jsp");

%>