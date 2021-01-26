<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.keroro.domain.Store"%>
<%@page import="org.keroro.dao.StoreDAO"%>

<%@ page import="java.sql.*" %>    
<%@ page import="java.util.*" %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store List</title>
</head>
<body>
<h1>list page</h1>

<ul>
<%
	StoreDAO dao = StoreDAO.getInstance();

	// 전체 목록을 DB에서 가져온다!
	List<Store> list = dao.selectAll();

	for(Store store : list){
%>
	<li><a href='/store/view.jsp?sno=<%=store.getStoreCode()%>'><%=store.getName() + ", "%><%=store.getMenu() + ", "%><%=store.getLng() + ", "%><%=store.getLat()%></a></li>
<%
	}
%>	
</ul>

<%


	

%>


</body>
</html>