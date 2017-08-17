package com.express.servlet;

import com.express.dao.SendDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong on 17-4-6.
 */
@WebServlet(name = "PushSendServlet",urlPatterns = "/PushSendServlet")
public class PushSendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int companyId = Integer.parseInt(request.getParameter("companyId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userPhone = request.getParameter("userPhone");
        String userAddress = request.getParameter("userAddress");

        SendDao dao = new SendDao();
        int r = dao.insertSend(companyId,userId,userPhone,userAddress);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
}
