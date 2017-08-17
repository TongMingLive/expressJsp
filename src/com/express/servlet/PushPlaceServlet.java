package com.express.servlet;

import com.express.bean.Place;
import com.express.dao.PlaceDao;
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
@WebServlet(name = "PushPlaceServlet",urlPatterns = "/PushPlaceServlet")
public class PushPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));
        int sendId = Integer.parseInt(request.getParameter("sendId"));

        PlaceDao dao = new PlaceDao();
        int r = dao.insertPlace(userId,sendId);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
}
