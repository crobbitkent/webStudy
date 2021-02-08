<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">게시글 등록</h1>

 <form class="form-horizontal" action="/mgr/qnaboard/register" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="mid">작성자</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mid">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="title">제목</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="qno">QuizNumber</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="qno">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="category">카테고리</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="category">
    </div>
  </div>      
  <div class="form-group">
    <label class="control-label col-sm-2" for="content">내용</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="content">
    </div>
  </div>
 <div class="form-group">
    <label class="control-label col-sm-2" for="aid">관리자ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="aid">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">등록하기</button>
    </div>
  </div>

</form>
<%@include file="../includes/footer.jsp" %>
