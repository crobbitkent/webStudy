<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%

	Long sno = Long.parseLong(request.getParameter("sno"));

	System.out.println("removeAction : " + sno);

	response.sendRedirect("/store/view.jsp?sno=" + sno);

%>