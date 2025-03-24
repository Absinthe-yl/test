package com.test.servlet;
import com.test.bean.beddata;
import com.test.service.PersonService;
import com.test.service.impl.PersonServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;
@WebServlet("/updateDo")
public class updateGetId extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            PersonService service = new PersonServiceimpl();
            List<beddata> list = service.updateGetId(id);
            if (!list.isEmpty()) {
                request.setAttribute("dorm", list.get(0));
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp?msg=未找到该学生信息");
                System.out.println("报错地点:updateGetId");
            }
        } catch (SQLException e) {
            throw new ServletException("数据库查询失败", e);
        }
    }
}