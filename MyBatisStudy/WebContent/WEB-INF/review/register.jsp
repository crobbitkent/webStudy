<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">맛집 리뷰 등록하기</h1>
    
<form class="form-horizontal" action="/review/register?sno=${store.sno}" method="post">
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">맛집 이름:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" placeholder=${store.name} readonly="readonly">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="score">별점</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="score">
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-2" for="mid">ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mid">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="text">내용</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="text" >
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
      <button><a href='/store/list' type="submit" class="btn btn-primary">맛집 목록으로 돌아가기</button>
    </div>
  </div>
    
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>