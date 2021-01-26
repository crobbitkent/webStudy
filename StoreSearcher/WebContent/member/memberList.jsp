<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.keroro.domain.*"%>
<%@page import="org.keroro.dao.*"%>

<%@ page import="java.sql.*" %>    
<%@ page import="java.util.*" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List</h1>
<%
	int result = 0;

	MemberDAO dao = new MemberDAO();

	// 전체 목록을 DB에서 가져온다!
	List<Member> memberlist = dao.selectAll();

	for(Member member : memberlist){
%>
	<li><a href='/member/memberView.jsp?mid=<%=member.getMid()%>'><%=member.getMid() + ", " + member.getPw() + ", "%><%=member.getName()%><%=member.getRegdate() + ", "%><%=member.getUpdatedate()%></a></li>
<%
	}
%>	

<button type="button" onclick="location.href= '/member/memberRegister.jsp?result=<%=result%>'" method = 'get'>회원가입</button>


</body>
</html>