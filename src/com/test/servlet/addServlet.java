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

@WebServlet("/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单参数
        String studentId = request.getParameter("studentId");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        String bed = request.getParameter("bed");
        String name = request.getParameter("name");

        // 基础校验
        if (studentId == null || studentId.isEmpty() ||
                building == null || building.isEmpty()) {
            request.setAttribute("error", "学号和楼栋不能为空");
            request.getRequestDispatcher("add.jsp").forward(request, response);
            return;
        }

        try {
            // 调用 Service 插入数据
            PersonService service = new PersonServiceimpl();
            boolean success = service.addBedData(studentId, building, room, bed, name);

            if (success) {
                // 插入成功，重定向到数据列表（触发重新查询）
                response.sendRedirect(request.getContextPath() + "/dataRoot");
            } else {
                request.setAttribute("error", "添加失败，请检查数据是否重复");
                request.getRequestDispatcher("add.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "数据库错误：" + e.getMessage());
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }
}