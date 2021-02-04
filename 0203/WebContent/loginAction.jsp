<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String mid = request.getParameter("mid");
	
	if(null != mid){
		
		Integer temp = (Integer)session.getAttribute("captcha");
		String cap = temp.toString();	
		
		if(mid.equals(cap)){
			// session.setAttribute("mid", mid);

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login 성공</h1>
</body>
</html>

<%
		} else{
			response.sendRedirect("/login.jsp");
		}
	}
%>