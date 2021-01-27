<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">맛집 등록</h1>
    
<form class="form-horizontal" action="/store/register" method="post">
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Store Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="맛집 이름">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="lat">LAT:</label>
    <div class="col-sm-10">
      <input type="number" step=".0123456789" class="form-control" id="lat" name="lat" placeholder="위도">
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-2" for="lng">LNG:</label>
    <div class="col-sm-10">
      <input type="number" step=".0123456789" class="form-control" id="lng" name="lng" placeholder="경도">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="menu">Menu:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="menu" name="menu" placeholder="메뉴">
    </div>
  </div>


  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">맛집 등록</button>
    </div>
  </div>

</form>
    
    

  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">맛집 목록으로 돌아가기</button>
    </div>
  </div>
    
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>