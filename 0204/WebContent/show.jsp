<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// cookie에 유통기한을 정해서 살아있는지 확인해보자.
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<ul>
<%
	Cookie[] arr = request.getCookies();

	for(int i = 0; i < arr.length; ++i){
	Cookie ck = arr[i];
%>
	<li>
	<%=ck.getName() %>
	<%=ck.getValue()%>
	</li>
<%
	}
%>

</ul>

</body>
</html>