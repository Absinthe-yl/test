<%-- dormInfo.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.test.bean.beddata" %>
<%@ page import="java.util.List" %>
<%
    List<beddata> dormListBed = (List<beddata>) request.getAttribute("dormListBed");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <style>
        /* 保持原始表格样式 */
        .dorm-table {
            width: 90%;
            margin: 20px auto;
            border: 1px solid #007bff;
            border-collapse: collapse;
            background: white;
        }
        .dorm-table th {
            background-color: #007bff;
            color: black;
            padding: 12px;
            border-right: 1px solid white;
        }
        .dorm-table td {
            padding: 10px;
            border: 1px solid #dee2e6;
        }
        .dorm-table tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        /* 新的操作按钮样式 */
        .action-cell form {
            display: inline-block;
            margin: 0 2px;
        }

        .action-link {
            padding: 4px 8px;
            border-radius: 3px;
            border: 1px solid #007bff;
            background: white;
            color: #007bff;
            text-decoration: none;
            font-size: 14px;
        }

        .action-link:hover {
            background-color: #007bff;
            color: white;
        }

        .action-button {
            padding: 4px 8px;
            border-radius: 3px;
            border: 1px solid #dc3545;
            background: white;
            color: #dc3545;
            cursor: pointer;
            font-size: 14px;
        }

        .action-button:hover {
            background-color: #dc3545;
            color: white;
        }

        .add-button {
            display: inline-block;
            padding: 8px 16px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 3px;
            margin: 10px 0;
        }

        .add-button:hover {
            background: #0056b3;
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宿舍信息管理</title>
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
    <h1>福建理工大学一站式迎新系统-管理员</h1>
</header>

<div class="btn-group">
    <a href="indexRoot.jsp" class="button">主页</a>
    <a href="moneyRoot.jsp" class="button">缴费信息</a>
    <a href="personRoot.jsp" class="button">返回新生资料</a>
    <a href="https://www.fjut.edu.cn" target="_blank" class="button">学校官网</a>
</div>

<div class="content">
    <% if (error != null) { %>
    <div class="error-msg"><%= error %></div>
    <% } else if (dormListBed == null || dormListBed.isEmpty()) { %>
    <div class="error-msg">暂无宿舍分配信息</div>
    <% } else { %>
    <table class="dorm-table">
        <tr>
            <th>学号</th>
            <th>楼栋</th>
            <th>房间</th>
            <th>床位</th>
            <th>姓名</th>
            <th>操作</th>
        </tr>

        <% for (beddata dorm : dormListBed) { %>
        <tr>
            <td><%= dorm.getStudentId() %></td>
            <td><%= dorm.getBuilding() %></td>
            <td><%= dorm.getRoom() %></td>
            <td><%= dorm.getBed() %></td>
            <td><%= dorm.getName() %></td>
            <td class="action-cell">
                <!-- 修改链接 -->
                <a href="updateDo?id=<%= dorm.getStudentId() %>"
                   class="action-link">修改</a>

                <form method="GET" action="delete" style="display: inline;">
                    <input type="hidden" name="DeleteId" value="<%= dorm.getStudentId() %>">
                    <input type="submit" value="删除" class="action-button">
                </form>
            </td>
        </tr>
        <% } %>
    </table>

    <div style="text-align: center; margin-top: 20px;">
        <a href="add.jsp" class="add-button">+ 新增记录</a>
    </div>
    <% } %>
</div>
</body>
</html>