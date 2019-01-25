<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/head.jsp" %>
<%@ include file="../common/tag.jsp" %>
<html>
<head>
    <title>登录</title>
    <%--<style>--%>
    <%--.login {--%>
    <%--position: absolute;--%>
    <%--width: 300px;--%>
    <%--margin-top: -100px;--%>
    <%--margin-left: -150px;--%>
    <%--left: 50%;--%>
    <%--top: 40%;--%>
    <%--background-color: rgba(255, 255, 255, 0.8);--%>
    <%--/*animation: in_am .8s both;*/--%>
    <%--}--%>
    <%--</style>--%>
</head>
<body>
<div class="login">
    <form method="post" accept-charset="utf-8">
        <div class="input-group">
            <span class="input-group-prepend">
                <span class="input-group-text">账号</span>
            </span>
            <input type="text" name="username" autocomplete="false" class="form-control">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-prepend">
                <span class="input-group-text">密码</span>
            </span>
            <input type="password" name="password" autocomplete="false" class="form-control">
        </div>
        <br>
        <div class="btn-group">
            <button type="submit" class="btn btn-sm btn-secondary">登 录</button>
        </div>
    </form>
</div>
<script>
    $(function () {
        $(".login form").submit(function (e) {
            var username = $('input[name="username"]').val();
            var password = $('input[name="password"]').val();
            if (!username || !password) {
                alert('账号或密码不能为空!');
                return false;
            }
            $.ajax({
                url: '/login',
                type: 'POST',
                data: {
                    name: username,
                    password: password
                },
                success: function (data) {
                    console.log(data);
                    alert(data.msg);
                }
            });
            return false;
        });

    });
</script>
</body>
</html>
