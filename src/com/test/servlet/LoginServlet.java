package com.test.servlet;

import com.test.bean.Person;
import com.test.dao.PersonDao;
import com.test.dao.impl.PersonDAaoimpl;
import com.test.service.PersonService;
import com.test.service.impl.PersonServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import static com.test.DB.db.getConnection;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✅ 数据库连接成功");
        } catch (SQLException e) {
            System.out.println("❌ 数据库连接失败");
            e.printStackTrace();
        }
    }
    static {
        testConnection();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String password = request.getParameter("password");

        PersonService svi = new PersonServiceimpl();
        boolean student=false;
        student = svi.selectOne(studentId, password);
        if (student) {
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("index.jsp");//跳转方法1
        } else {
            request.setAttribute("error", "学号或密码错误！请重新输入或者联系辅导员");
            request.getRequestDispatcher("register.jsp").forward(request, response);//跳转方法2
        }
    }
}
