package com.test.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/xiao")
public class xiaoLServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res){
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("xiaoLi.jsp");
    }
}
