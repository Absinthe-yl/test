<%--
  Created by IntelliJ IDEA.
  User: 22353
  Date: 2025/3/21
  Time: 下午3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>校历</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        /* 新增图片样式 */
        .content-image {
            width: 100%;
            height: 80vh; /* 可视区域的80%高度 */
            margin: 20px 0;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            object-fit: contain; /* 完整显示图片 */
            background: #f5f5f5;
        }

        /* 响应式调整 */
        @media (max-width: 768px) {
            .content-image {
                height: 60vh;
                margin: 10px 0;
            }
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
    <a href="index.jsp" class="button">回到主页</a>
    <a href="money.jsp" class="button">缴费系统</a>
    <a href="school.jsp" class="button">我的大学</a>
    <a href="person.jsp" class="button">返回个人资料查询</a>
    <a href="https://www.fjut.edu.cn" target="_blank" class="button">学校官网</a>
</div>

<div class="content-container">

    <img src="img/date.png"
         alt="福建理工大学2025-2026学年校历"
         class="content-image"
         title="点击查看大图"
         onclick="window.open(this.src)">
</div>

</body>
</html>