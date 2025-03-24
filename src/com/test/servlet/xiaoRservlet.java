package com.test.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/xiaoR")
public class xiaoRservlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res){
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("xiaoR.jsp");
    }
}
