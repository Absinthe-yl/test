package com.test.servlet;

import com.test.service.PersonService;
import com.test.service.impl.PersonServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取参数并校验空值
        String originalId = request.getParameter("originalStudentId");
        String studentId = request.getParameter("studentId");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        String bed = request.getParameter("bed");
        String name = request.getParameter("name");

        if (originalId == null || originalId.isEmpty()) {
            response.sendRedirect("error.jsp?msg=原始学号不能为空");
            System.out.println("报错地点:updateGetId原始学号不能为空");
            return;
        }
        try {
            PersonService service = new PersonServiceimpl();
            boolean success = service.update(
                    originalId,
                    studentId,
                    building, room, bed, name
            );
            if (success) {
                response.sendRedirect("dataRoot");
            } else {
                request.setAttribute("error", "更新失败（可能学号重复或数据错误）");
                System.out.println("报错地点:updateGetId原更新失败（可能学号重复或数据错误）");
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "数据库错误：" + e.getMessage());
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
    }
}