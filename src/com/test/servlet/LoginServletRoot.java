package com.test.servlet;

import com.test.service.PersonService;
import com.test.service.impl.PersonServiceimpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import static com.test.DB.db.getConnection;


@WebServlet("/loginroot")
public class LoginServletRoot extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("Id");
        String password = request.getParameter("password");
        PersonService svi = new PersonServiceimpl();
        boolean root=false;
        root = svi.selectOneRoot(studentId, password);
        if (root) {
            request.setAttribute("loggedInRootId", studentId);
            request.getRequestDispatcher("indexRoot.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "学号或密码错误！请联系开发者");
            request.getRequestDispatcher("register.jsp").forward(request, response);//跳转方法2
        }
    }
}
