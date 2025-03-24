package com.test.servlet;

import com.test.bean.Class;
import com.test.service.PersonService;
import com.test.service.impl.PersonServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/wClass")
public class classServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = (String) request.getSession().getAttribute("loggedInStudentId");
        if (studentId == null) {
            response.sendRedirect("register.jsp");  //如果未获取到学号（用户未登录），重定向到注册页register.jsp
            return;
        }
        try {
            PersonService personService = new PersonServiceimpl();
            List<Class> dorm= personService.classData(studentId);
            if(dorm== null || dorm.isEmpty()) {
                System.out.println("dorm is empty");
                request.setAttribute("error","未查询到班级信息");
            }else {
                request.getSession().setAttribute("dormList1",dorm);
                request.getRequestDispatcher("classData.jsp").forward(request, response);
                System.out.println("dorm is "+dorm);
            }
        } catch (SQLException | ServletException e) {
            request.setAttribute("error", "系统错误：" + e.getMessage());
        }
    }
}
