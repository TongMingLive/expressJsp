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
@WebServlet(name = "UpdateSendAppraiseServlet",urlPatterns = "/UpdateSendAppraiseServlet")
public class UpdateSendAppraiseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int sendId = Integer.parseInt(request.getParameter("sendId"));
        Double sendAppraise = Double.parseDouble(request.getParameter("sendAppraise"));
        String sendPage = request.getParameter("sendPage");

        SendDao dao = new SendDao();
        int r = dao.updateSendAppraise(sendId,sendAppraise,sendPage);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
}
