<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>index page </title>
<%@include file="component/css.jsp" %>
<%@include file="component/navbar.jsp" %>
</head>
<body>
<% Connection conn=DBConnect.getConn();
out.print(conn);
%>
<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="img/2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="img/3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
</div>

<%@include file="component/footer.jsp" %>

</body>
</html>
