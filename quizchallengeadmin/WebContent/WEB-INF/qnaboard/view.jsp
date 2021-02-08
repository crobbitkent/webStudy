<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">조회 페이지</h1>

<form action="/mgr/qnaboard/list">
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">목록</button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="/mgr/qnaboard/modify" method="get">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bno">게시글번호</label>
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="bno"
				value='${board.bno}' readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2">QuizNumber</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="qno"
				value='${board.qno}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="title">제목</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="title"
				value='${board.title}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="content">게시글내용</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="content"
				value='${board.content}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="category">카테고리</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="category"
				value='${board.category}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="regdate">올린날짜</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="regdate"
				value='${board.regdate}' readonly="readonly">
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">수정하기</button>
		</div>
	</div>
</form>
<form action="/mgr/qnaboard/acceptAnswer" method='post'>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="hidden" name="state" value="${board.state }">
			<input type="hidden" name="bno" value="${board.bno }">
			<button type="submit" class="btn btn-danger">답변 완료 처리</button>
		</div>
	</div>
</form>
<br>
<br>
<br>
<form action="/mgr/qnaboard/remove" method='post'>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="hidden" name="bno" value="${board.bno }">
			<button type="submit" class="btn btn-danger">게시글 삭제</button>
		</div>
	</div>
</form>
<table class="table">
	<thead>
		<tr>
			<th scope="col">아이디</th>
			<th scope="col">댓글</th>
			<th scope="col">작성일</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${replyList}" var="replyList">
			<tr>
				<td>${replyList.mid}</td>
				<td>${replyList.reply}</td>
				<td>${replyList.regdate}</td>
				<td><form action="/mgr/qnaboard/removeReply" method='post'>
								<input type="hidden" name="rno" value="${replyList.rno }">
								<input type="hidden" name="bno" value="${board.bno }">
								<button >삭제</button>
					</form></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form class="form-horizontal" action="/mgr/qnaboard/view?bno=${board.bno}"
	method="post">

	<div class="form-group">
		<label class="control-label col-sm-2" for="bno"></label>
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="bno"
				value='${board.bno}' readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="mid">작성자</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="mid">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="reply">내용</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="reply">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">등록하기</button>
		</div>
	</div>
</form>
<%@include file="../includes/footer.jsp"%>
