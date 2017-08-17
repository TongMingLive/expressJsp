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
@WebServlet(name = "UpdateSendTypeServlet",urlPatterns = "/UpdateSendTypeServlet")
public class UpdateSendTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int sendId = Integer.parseInt(request.getParameter("sendId"));
        int sendType = Integer.parseInt(request.getParameter("sendType"));

        SendDao dao = new SendDao();
        int r = dao.updateSendType(sendId,sendType);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
}
