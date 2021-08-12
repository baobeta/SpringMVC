<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">
    <title>Trang chủ</title>

</head>
<body>
<!-- Page Content -->
<div class="container">
<form action="<c:url value='/trang-chu'/>" id="formSubmit" method="get">
    <!-- Heading Row -->
    <c:forEach var="item" items="${model.listResult}">
        <div class="row align-items-center my-5">
            <div class="col-lg-8">
                <h1 class="font-weight-light">${item.title}</h1>
                <p>${item.shortDescription}</p>
                <a class="btn btn-primary" href="<c:url value="/trang-chu/bai-viet/${item.id}"/>">Call to Action!</a>
            </div>
            <!-- /.col-md-4 -->
        </div>
    </c:forEach>

    <!-- /.row -->


</form>


</div>
<!-- /.container -->


</body>

</html>