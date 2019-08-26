package com.xy.control;

import com.xy.vo.User;
import com.xy.service.UserService;
import com.xy.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class dispacherServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<User> users=userService.queryAllery();
        req.setAttribute("usersKey",users);
        req.getRequestDispatcher("/jsp/showUser.jsp").forward(req,resp);
    }
}
