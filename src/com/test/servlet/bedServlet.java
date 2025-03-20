package com.test.servlet;

import com.test.bean.beddata;
import com.test.service.PersonService;
import com.test.service.impl.PersonServiceimpl;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/person")
public class bedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PersonService svi=new PersonServiceimpl();
//        try {
//            if(svi.data()==null){
//                request.setAttribute("error", "没有宿舍信息，请联系辅导员！");
//            }else {
//                // 将数据存入会话
//                request.getSession().setAttribute("dormList", svi.data());
//                response.sendRedirect("data.jsp");//跳转方法1
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        //关键点:从Session中获取登录时存储的学号 loggedInStudentId
        String studentId = (String) request.getSession().getAttribute("loggedInStudentId");
        if (studentId == null) {
            response.sendRedirect("register.jsp");  //如果未获取到学号（用户未登录），重定向到注册页register.jsp
            return;
        }

        try {
            PersonService service = new PersonServiceimpl();
            List<beddata> dorms = service.data(studentId);
            if(dorms == null || dorms.isEmpty()) {
                System.out.println("dorms is empty");
                request.setAttribute("error", "未找到宿舍信息");
            } else {
                System.out.println(dorms);
                // 将数据存入会话
                request.getSession().setAttribute("dormList", dorms);
                request.getRequestDispatcher("data.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "系统错误：" + e.getMessage());
        }
    }
}
