package com.express.servlet;

import com.express.bean.Send;
import com.express.dao.SendDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tong on 17-4-6.
 */
@WebServlet(name = "SelectSendByIdServlet",urlPatterns = "/SelectSendByIdServlet")
public class SelectSendByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int sendId = Integer.parseInt(request.getParameter("sendId"));

        SendDao dao = new SendDao();
        Send send = dao.selectSendById(sendId);
        JSONObject jsonObject = JSONObject.fromObject(send);
        out.print(jsonObject.toString());

        out.flush();
        out.close();
    }
}
