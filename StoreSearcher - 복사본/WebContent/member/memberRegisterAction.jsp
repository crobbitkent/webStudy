<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.keroro.dao.*"%>
<%@page import="org.keroro.domain.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	String mid = request.getParameter("mid");
	
	if(mid == null || mid.trim().length() == 0){
		return;
	}
	
	String mpw = request.getParameter("mpw");
	String mname = request.getParameter("mname");
	
	Member member = Member.builder().mid(mid).pw(mpw).name(mname).build();
	MemberDAO dao = new MemberDAO();

	int result = dao.insert(member);
	if(result== -1){
/* 
		response.sendRedirect("/member/memberRegister.jsp"+"?result="+result);	
	}else{
	// redirect
	response.sendRedirect("/member/memberList.jsp");} */
%>
<script>

	alert("아이디 중복");

</script>

<% } %>