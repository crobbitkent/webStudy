<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

	<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Member List Page</h1>
    
<form class="form-horizontal" action="/store/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">가게 목록</button>
    </div>
  </div>
</form> 
  
<table class="table">
  <thead>
    <tr>
      <th scope="col">MID</th>
      <th scope="col">MPW</th>
      <th scope="col">MNAME</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATEDATE</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${members}" var="member">
	


    <tr>
      <td>${member.mid}</td>
      <td>${member.mpw}</td>
      <td>${member.mname}</td>
      <td>${member.regdate}</td>
      <td>${member.updatedate}</td>
    </tr>   

	
	</c:forEach>
<!-- loop end -->

	</tbody>
</table>              
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>