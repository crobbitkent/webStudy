<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "org.keroro.dao.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	TimeDAO dao = new TimeDAO();
	String str = dao.getTime();
	
%>

<%=
	str
%>


</body>
</html>