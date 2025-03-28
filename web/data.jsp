<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.test.bean.beddata" %>
<%@ page import="java.util.List" %>
<%
    // 从会话作用域获取数据
    List<beddata> dormList = (List<beddata>) session.getAttribute("dormList");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宿舍信息详情</title>
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
    <a href="person.jsp" class="button">返回个人资料查询</a>
    <a href="https://www.fjut.edu.cn" target="_blank" class="button">学校官网</a>
</div>

<div class="data_container">
    <h1 class="data_title">我的宿舍信息</h1>

    <%-- 错误提示 --%>
    <% if(error != null) { %>
    <div class="error-message">
        <%= error %>
    </div>
    <% } %>

    <%-- 宿舍信息展示 --%>
    <% if(dormList != null && !dormList.isEmpty()) {
        for(beddata dorm : dormList) { %>
    <div class="data_dorm-card">
        <div class="data_info-item">
            <strong>宿舍楼：</strong><%= dorm.getBuilding() %>
        </div>
        <div class="data_info-item">
            <strong>房间号：</strong><%= dorm.getRoom() %>
        </div>
        <div class="data_info-item">
            <strong>床号：</strong><%= dorm.getBed() %>
        </div>
    </div>
    <% }
    } else { %>
    <div class="data_dorm-card">
        当前暂无宿舍分配信息
    </div>
    <% } %>
</div>

</body>
</html>