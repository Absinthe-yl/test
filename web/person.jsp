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
        <%-- 修改后的宿舍信息按钮 --%>
        <form action="person" method="post">
            <input type="hidden" name="action" value="queryDorm">
            <button type="submit" class="person-main-text">宿舍信息</button>
        </form>

        <%-- 其他保持原样 --%>
        <a href="data.jsp"><button class="person-main-text">班级信息</button></a>
        <a href="data.jsp"><button class="person-main-text">查看校历</button></a>
        <a href="data.jsp"><button class="person-main-text">查看辅导员信息</button></a>
    </div>
</div>
</body>
</html>