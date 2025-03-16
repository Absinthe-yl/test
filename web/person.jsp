<%--
  Created by IntelliJ IDEA.
  User: 22353
  Date: 2025/2/28
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人资料查询</title>
    <link rel="stylesheet" href="css/style.css">
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
    <a href="index.jsp" class="button">回到主页</a>
    <a href="money.jsp" class="button">缴费系统</a>
    <a href="school.jsp" class="button">我的大学</a>
    <a href="person.jsp" class="button">个人资料查询</a>
    <a href="https://www.fjut.edu.cn" target="_blank" class="button">学校官网</a>
</div>

<div class="person-main">
    <!-- 四个功能按钮 -->
    <div class="btn-container">
        <button class="person-main-text" id="openDialogBtn">查看班级信息</button>
        <button class="person-main-text" id="viewCalendarBtn">查看校历图片</button>
        <button class="person-main-text" id="viewDormBtn">查看宿舍信息</button>
        <button class="person-main-text" id="viewCounselorBtn">查看辅导员信息</button>
    </div>

    <!-- 通用对话框 -->
    <div class="dialog-mask" id="dialogMask">
        <div class="dialog-container">
            <div class="dialog-header" id="dialogTitle">标题</div>
            <div class="dialog-body" id="dialogContent">
                <!-- 内容 -->
            </div>
            <div class="dialog-footer">
                <button class="btn" id="cancelBtn">关 闭</button>
            </div>
        </div>
    </div>
</div>


<script src="js/validation.js"></script>
</body>
</html>