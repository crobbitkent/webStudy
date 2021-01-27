<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.keroro.dao.*"%>
<%@page import="org.keroro.domain.*"%>
    
 <%
	String mid = request.getParameter("mid");
 
 	MemberDAO dao = new MemberDAO();
 	Member member = dao.selectOne(mid);
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER MODIFY PAGE</title>
</head>

<body>

<form action = "/member/memberModifyAction.jsp" method='post'>
 <div>
      <label>아이디</label>
      <input name="mid" type="text" value="<%=member.getMid()%>" readonly="readonly"/>
    </div>
    <div>
      <label>비밀번호</label>
      <input name="mpw" type="text" value="<%=member.getPw()%>" />
    </div>
     <div>
      <label>이름</label>
      <input name="mname" type="text" value="<%=member.getName()%>" />
    </div>
    <div>
      <label>등록한 날짜</label>
      <input name="regdate" type="text" value="<%=member.getRegdate()%>" readonly/>
    </div>
    <div>
      <label>수정한 날짜</label>
      <input name="updatedate" type="text" value="<%=member.getUpdatedate()%>" readonly/>
    </div>
    	<button>수정</button>
</form>

<form action = "/member/memberRemoveAction.jsp" method='post'>
	<input type='hidden' name='mid' value='<%=mid%>'>
	<button>삭제</button>
</form>



</body>

</html>