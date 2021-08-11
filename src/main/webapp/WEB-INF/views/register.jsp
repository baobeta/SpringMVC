<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<c:url var="userAPI" value="/api/user"/>
<c:url var="login" value="/dang-nhap"/>
<c:url var="register" value="/dang-ki"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <!-- <h1 class="form-heading">login Form</h1> -->
    <div class="login-form">
        <div class="main-div">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                        ${message}
                </div>
            </c:if>
            <form  id="formRegister" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="Tên đăng nhập">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ và tên">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">
                </div>
                <div class="form-group">
                <input type="password" class="form-control" id="repassword" name="repassword" placeholder="Nhâp lại mật khẩu">
                </div>
                <button id="register" type="button" class="btn btn-primary" >Đăng kí</button>
            </form>
        </div>
    </div>
</div>
<script>
    $('#register').click(function (e) {
        e.preventDefault();
        var data ={};
        var formData = $('#formRegister').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        console.log(formData);
        register(data);

    });
    function register(data) {
        $.ajax({
            url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${login}?message=insert_success";
            },
            error: function (error) {
                window.location.href = "${register}?message=error_system";
            }
        });

    }
</script>
</body>
</html>