<%--
  Created by IntelliJ IDEA.
  User: 22353
  Date: 2025/2/26
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新生登录 - 福建理工大学</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <div class="title-group">
        <img src="img/logo.jpg" alt="校徽" class="logo">
        <h1>福建理工大学一站式迎新系统</h1>
    </div>
</header>

<div class="container" >
    <div class="login-box">
        <% if(request.getAttribute("error") != null) { %>
        <div class="error-message">
            <%= request.getAttribute("error") %>
        </div>
        <% } %>

        <h2>管理员登录</h2>
        <form action="login" method="post">
            <div class="form-group">
                <label for="studentId">管理员id：</label>
                <input type="text" id="studentId" name="studentId"
                       pattern="\d{8}" title="请输入8位id" required>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" id="password" name="password"
                       placeholder="初始密码为身份证后六位" required>
            </div>

            <button type="submit" class="submit-btn">立即登录</button>

            <div class="admin-login-link">
                <a href="register.jsp">学生身份登录</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>