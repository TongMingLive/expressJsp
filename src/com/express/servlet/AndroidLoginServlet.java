package com.express.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.express.bean.User;
import com.express.dao.UserDao;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;


/**
 * Created by tong on 17-3-24.
 */
@WebServlet(name = "AndroidLoginServlet",urlPatterns = "/AndroidLoginServlet")
public class AndroidLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        String userName=request.getParameter("userName");
        String userPassword=request.getParameter("userPassword");

        UserDao dao = new UserDao();
        User user = dao.loginUser(userName,userPassword);

        JSONObject jsonObject = JSONObject.fromObject(user);
        out.print(jsonObject.toString());

        out.flush();
        out.close();
    }
}
