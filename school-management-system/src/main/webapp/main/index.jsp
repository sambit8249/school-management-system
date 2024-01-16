<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file= "../components/allcss.jsp" %>

<%@ include file="../components/navbar.jsp" %>

<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="2000">
      <img src="../img/school1.jpg" class="d-block w-100" alt="..." height="700px">
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../img/school2.jpg" class="d-block w-100" alt="..." height="700px">
    </div>
    <div class="carousel-item" data-bs-interval="2000" >
      <img src="../img/school3.jpg" class="d-block w-100" alt="..." height="700px">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
</body>
</html>
