package com.express.servlet;

import com.express.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong on 17-3-27.
 */
@WebServlet(name = "UpdateUserPasswordServlet",urlPatterns = "/UpdateUserPasswordServlet")
public class UpdateUserPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId=Integer.parseInt(request.getParameter("userId"));
        String userPassword=request.getParameter("userPassword");

        UserDao dao = new UserDao();
        int r = dao.updateUserPassword(userId,userPassword);

        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
