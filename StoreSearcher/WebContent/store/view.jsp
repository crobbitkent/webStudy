<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.keroro.domain.*" %> 
<%@ page import="org.keroro.dao.*" %>  

<%
   Long sno = Long.parseLong(request.getParameter("sno"));

   StoreDAO dao = StoreDAO.getInstance();
   
   Store store = dao.selectOne(sno);

%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>VIEW JSP</h1>
    <div>
      <label>번호</label>
      <input name="sno" type="text" value="<%=store.getStoreCode()%>" readonly="readonly"/>
    </div>

    <div>
      <label>이름</label>
      <input name="name" type="text" value="<%=store.getName()%>" readonly="readonly"/>
    </div>
    <div>
      <label>위도</label>
      <input name="lat" type="text" value="<%=store.getLat()%>" readonly/>
    </div>
    <div>
      <label>경도</label>
      <input name="lng" type="text" value="<%=store.getLng()%>" readonly/>
    </div>
    <div>
      <label>메뉴</label>
      <input name="menu" type="text" value="<%=store.getMenu()%>"/>
    </div>
    <div>
      <button><a href='/store/modify.jsp?sno=<%=store.getStoreCode()%>'>수정/삭제</a></button> 
      <button><a href='/store/list.jsp'>목록</a></button> 
    </div>    

</body>
</html>