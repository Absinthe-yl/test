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


@WebServlet("/dataRoot")
public class bedServletRoot extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用 doPost 方法，复用查询逻辑
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PersonService service = new PersonServiceimpl();
            List<beddata> dorms = service.queryAll();
            if(dorms == null || dorms.isEmpty()) {
                System.out.println("dorms is empty");
                request.setAttribute("error", "未找到宿舍信息");
            } else {
                System.out.println(dorms);
                // 将数据存入会话
                request.setAttribute("dormListBed", dorms);
                request.getRequestDispatcher("dataRoot.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "系统错误：" + e.getMessage());
        }
    }
}
