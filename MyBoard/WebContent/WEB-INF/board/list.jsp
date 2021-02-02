<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">게시판 목록</h1>
      
      
    
<form class="form-horizontal" action="/board/post" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">게시글 등록하기</button>
    </div>
  </div>
</form>
    
<table class="table">
  <thead>
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">WRITER</th>
      <th scope="col">REG DATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${boards}" var="board">
	
    <tr>
      <td>${board.bno}</td>
      <td><a href = '/board/view?bno=${board.bno}'>${board.title}</a></td>
      <td>${board.writer}</td>
      <td>${board.regdate}</td>
      <td>${board.updatedate}</td>
    </tr>   

	</c:forEach>
<!-- loop end -->

	</tbody>
</table>

<nav aria-label="...">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <span class="page-link">Previous</span>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item active" aria-current="page">
      <span class="page-link">2</span>
    </li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>