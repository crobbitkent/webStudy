<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 한글은 못들어간다.
	Cookie ck1 = new Cookie("userCookie1", "HongGilDong1");
	Cookie ck2 = new Cookie("userCookie2", "HongGilDong2");

	// 1시간 유통기한
	ck1.setMaxAge(60*60);
	
	response.addCookie(ck1);
	response.addCookie(ck2);
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Cookie is published...</h1>

</body>
</html>