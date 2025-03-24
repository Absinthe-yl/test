package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("DeleteId");
        if (id == null || id.isEmpty()) {
            response.sendError(400, "缺少参数 DeleteId");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users?serverTimezone=GMT%2B8",
                    "root",
                    "cjl"
            );
            PreparedStatement statement = connection.prepareStatement("DELETE FROM beddata WHERE student_id=?");
            statement.setString(1, id); // 使用 setString
            int i = statement.executeUpdate();
            if (i > 0) {
                response.sendRedirect(request.getContextPath() + "/dataRoot");
            } else {
                response.getWriter().println("未找到对应记录");
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            response.getWriter().println("数据库驱动未找到：" + e.getMessage());
        } catch (SQLException e) {
            response.getWriter().println("数据库错误：" + e.getMessage());
        }
    }
}