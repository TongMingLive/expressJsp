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
@WebServlet(name = "UserRegisterServlet",urlPatterns = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
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
        String userPhone = request.getParameter("userPhone");
        String userAddress = request.getParameter("userAddress");

        UserDao dao = new UserDao();
        boolean b = dao.selectUserName(userName);
        if (b){
            out.print("false");
        }else {
            int r = dao.registUser(userName,userPassword,userPhone,userAddress);
            if (r>0){
                out.print("true");
            }else {
                out.print("no");
            }
        }

        out.flush();
        out.close();
    }
}
