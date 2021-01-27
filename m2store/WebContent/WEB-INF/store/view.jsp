<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">Store View Page</h1>
    
    <form class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-sm-2" for="sno">Store Code:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sno" value="${store.storeCode}" readonly="readonly">
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
      <button type="submit" class="btn btn-danger">Submit</button>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Back To List</button>
    </div>
  </div>
    
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>