<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">Store View Page</h1>
    
<form class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-sm-2" for="sno">SNO:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sno" value="${store.sno}" readonly="readonly">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Store Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" value="${store.name}" readonly="readonly">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="lat">LAT:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lat" value="${store.lat}" readonly="readonly">
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-2" for="lng">LNG:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lng" value="${store.lng}" readonly="readonly">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="email">Menu:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sno" value="${store.menu}" readonly="readonly">
    </div>
  </div>

</form>
    
    
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">수정/삭제</button>
    </div>
  </div>

<form class="form-horizontal" action="/store/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button class="btn btn-primary">가게 목록으로 돌아가기</button>
    </div>
  </div>
</form>
  
    <!-- <button><a href='/store/list.jsp'>목록</a></button>  -->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button class="btn btn-warning" onclick='/review/register?sno=${store.sno}'>리뷰 등록</a></button>
    </div>
  </div>
    
    <!-- review table -->
  <table class="table">
  <thead>
    <tr>
      <th scope="col">RNO</th>
      <th scope="col">STORE NAME</th>
      <th scope="col">ID</th>
      <th scope="col">TEXT</th>
      <th scope="col">SCORE</th>
      <th scope="col">REG DATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${reviewList}" var="review">


    <tr>
      <td>${review.rno}</td>
      <td>${review.storeName}</td>
      <td>${review.mid}</td>
      <td>${review.text}</td>
      <td>${review.score}</td>
      <td>${review.reviewdate}</td>
      <td>${review.updatedate}</td>
    </tr>   

	
	</c:forEach>
<!-- loop end -->

	</tbody>
</table>  
    
    
    
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>