<%-- add.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增宿舍信息</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .add-form {
            width: 60%;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #007bff;
            background: white;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .submit-btn {
            background: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .submit-btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="out">
    <div class="out-button">
        <a href="register.jsp" class="out-button-text">退出登录</a>
    </div>
</div>
<header>
    <img src="img/logo.jpg" alt="校徽" class="logo">
    <h1>福建理工大学一站式迎新系统</h1>
</header>

<div class="btn-group">
    <a href="indexRoot.jsp" class="button">主页</a>
    <a href="moneyRoot.jsp" class="button">缴费信息</a>
    <a href="personRoot.jsp" class="button">新生资料</a>
    <a href="https://www.fjut.edu.cn" target="_blank" class="button">学校官网</a>
</div>
<div class="out">
    <div class="out-button">
        <a href="dataRoot.jsp" class="out-button-text">返回列表</a>
    </div>
</div>

<div class="content">
    <h2 style="text-align: center;">新增宿舍分配</h2>
    <% if (request.getAttribute("error") != null) { %>
    <div class="error-msg" style="color: red; text-align: center; margin: 10px 0;">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>
    <form class="add-form" action="add" method="post">
        <div class="form-group">
            <label for="studentId">学号：</label>
            <input type="text" id="studentId" name="studentId" required>
        </div>
        <div class="form-group">
            <label for="building">楼栋：</label>
            <input type="text" id="building" name="building" required>
        </div>
        <div class="form-group">
            <label for="room">房间号：</label>
            <input type="text" id="room" name="room" required>
        </div>
        <div class="form-group">
            <label for="bed">床位号：</label>
            <input type="text" id="bed" name="bed" required>
        </div>
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div style="text-align: center;">
            <button type="submit" class="submit-btn">提交</button>
        </div>
    </form>
</div>
</body>
</html>