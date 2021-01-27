<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.keroro.dao.*"%>
<%@page import="org.keroro.domain.*"%>
    
 <%

 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER MODIFY PAGE</title>
</head>

<body>

<form action = "/member/memberRegisterAction.jsp" method='post' target="zero">
 <div>
      <label>아이디</label>
      <input name="mid" type="text" />
    </div>
    <div>
      <label>비밀번호</label>
      <input name="mpw" type="text"  />
    </div>
     <div>
      <label>이름</label>
      <input name="mname" type="text"  />
    </div>
	<button>회원가입</button>
</form>

<iframe name='zero' style="width:0px; height:0px; border:0px;"></iframe>

<div>
<%
	String resultString = "";
	String result = request.getParameter("result");
	
	if(result != null && result.equals("-1")){
		resultString = "중복된 ID입니다.";
	}
%>
</div>

<%=resultString %>

</body>

</html>