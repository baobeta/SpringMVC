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
    <form action="" id="formSubmit" method="get">
        <!-- Heading Row -->
            <div class="row align-items-center my-5">
                <div class="col-lg-8">
                    <h1 class="font-weight-light">${model.title}</h1>
                    <p>${model.shortDescription}</p>
                    <p>${model.content}</p>
                    <p>${model.createdDate}</p>
                    <p>${model.createdBy}</p>
                </div>
                <!-- /.col-md-4 -->
            </div>
        <!-- /.row -->
    </form>


</div>
<!-- /.container -->


</body>

</html>