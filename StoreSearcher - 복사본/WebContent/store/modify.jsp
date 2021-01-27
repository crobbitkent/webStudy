<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	Long sno = Long.parseLong(request.getParameter("sno"));
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify page</title>
</head>

<body>

<form action = "/store/modifyAction.jsp" method='post'>
	<input type='hidden' name='sno' value='<%=sno%>'>
	<button>수정</button>
</form>

<form action = "/store/removeAction.jsp" method='post'>
	<input type='hidden' name='sno' value='<%=sno%>'>
	<button>삭제</button>
</form>



</body>

</html>