<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.keroro.domain.*" %> 
<%@ page import="org.keroro.dao.*" %>  

<%
   String mid = request.getParameter("mid");

   MemberDAO dao = new MemberDAO();
   
   Member member = dao.selectOne(mid);

%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>MEMBER VIEW JSP</h1>
    
    <div>
      <label>아이디</label>
      <input name="mid" type="text" value="<%=member.getMid()%>" readonly="readonly"/>
    </div>
    <div>
      <label>비밀번호</label>
      <input name="mpw" type="text" value="<%=member.getPw()%>" readonly/>
    </div>
     <div>
      <label>이름</label>
      <input name="mname" type="text" value="<%=member.getName()%>" readonly/>
    </div>
    <div>
      <label>등록한 날짜</label>
      <input name="regdate" type="text" value="<%=member.getRegdate()%>" readonly/>
    </div>
    <div>
      <label>수정한 날짜</label>
      <input name="updatedate" type="text" value="<%=member.getUpdatedate()%>" readonly/>
    </div>
    <div>
      <button><a href='/member/memberModify.jsp?mid=<%=member.getMid()%>'>수정/삭제</a></button> 
      <button><a href='/member/memberList.jsp'>회원 목록</a></button> 
    </div>    

</body>
</html>