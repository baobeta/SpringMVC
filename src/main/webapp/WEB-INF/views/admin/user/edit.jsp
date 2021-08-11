<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/tablib.jsp" %>
<c:url var="newURL" value="/quan-tri/thanh-vien/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/thanh-vien/chinh-sua"/>
<c:url var="userAPI" value="/admin/api/user"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
                </li>

                <li><a href="#">Forms</a></li>
                <li class="active">Form Elements</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                        <div class="form-group">
                            <label for="roles" class="col-sm-3 control-label no-padding-right">Thể loại:</label>
                            <div class="col-sm-9">
                                <form:checkboxes path="roles" items="${role}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" >Tên đăng nhập</label>
                            <div class="col-sm-9">
                                <form:input path="userName" cssClass="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="fullName" class="col-sm-3 control-label no-padding-right">Họ và tên:</label>
                            <div class="col-sm-9">
                                <form:input path="fullName" rows="5" cols="10" cssClass="form-control" id="fullName"/>
                            </div>
                        </div>
                        <c:if test="${empty model.id}">
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label no-padding-right">Mật khẩu:</label>
                            <div class="col-sm-9">
                                <form:input path="password" rows="5" cols="10" cssClass="form-control" id="password" type="password"/>
                            </div>
                        </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 control-label no-padding-right">Nhập lại mật khẩu:</label>
                                <div class="col-sm-9">
                                    <form:input path="repassword" rows="5" cols="10" cssClass="form-control" id="repassword" type="password"/>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty model.id}">
                            <form:hidden path="password" id="password" value="${model.password}"/>
                            <form:hidden path="repassword" id="repassword" value="${model.password}"/>
                        </c:if>
                        <form:hidden path="id" id="userId"/>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Cập nhật thành viên
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Thêm thành viên
                                    </button>
                                </c:if>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <a href="${newURL}?page=1&limit=2">
                                        <i class="ace-icon fa fa-undo bigger-110"></i>
                                             Hủy
                                    </a>
                                </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data ={};
        var array = []
        var checkboxes = document.querySelectorAll('input[type=checkbox]:checked')
        for (var i = 0; i < checkboxes.length; i++) {
            array.push(checkboxes[i].value)
        }
        console.log(array);
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;

        });
        delete data["_roles"];
        delete data["roles"];
        Object.assign(data, {roles: array});
        console.log(formData);
        console.log(data);
        var id = $('#userId').val();
        if(id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
        console.log(formData);
    });
    function addNew(data) {
        $.ajax({
            url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if(result.id !=null ){
                    window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
                }
                else {
                    window.location.href = "${newURL}?page=1&limit=2&message=error_system";
                }

            },
            error: function (error) {
                window.location.href = "${newURL}?page=1&limit=2&message=error_system";
            }
        });

    }
    function updateNew(data) {
        $.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
            }
        });

    }

</script>
</body>
</html>