package com.ming.serviet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String form_name = request.getParameter("username");
        String form_pass = request.getParameter("password");
        if ("wozuishuai".equals(form_name)&&"123".equals(form_pass)){
            request.getRequestDispatcher("success.jsp").forward(request,response);

        }else {
            request.getRequestDispatcher("failure.jsp").forward(request,response);
        }
    }
}

