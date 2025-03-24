package com.test.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;




// =================配置 Servlet 过滤器统一编码==============




@WebFilter("/*") // 过滤所有请求
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化逻辑（可选）
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 设置请求编码
        request.setCharacterEncoding("UTF-8");
        // 设置响应编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 继续执行后续过滤器或目标资源
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 清理逻辑（可选）
    }
}
