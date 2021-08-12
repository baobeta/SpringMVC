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
    <div class="row align-items-center my-5">
        <div class="col-lg-8">
            <h1 class="font-weight-light">Business Name or Tagline</h1>
            <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it makes a great use of the standard Bootstrap core components. Feel free to use this template for any project you want!</p>
            <a class="btn btn-primary" href="#">Call to Action!</a>
        </div>
        <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination"></ul>
    </nav>

</form>


</div>
<!-- /.container -->
<script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 10,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>

</body>

</html>