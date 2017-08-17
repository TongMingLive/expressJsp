package com.express.servlet;

import com.express.bean.Find;
import com.express.dao.FindDao;

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
@WebServlet(name = "PushFindServlet",urlPatterns = "/PushFindServlet")
public class PushFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        String findTitle = request.getParameter("findTitle");
        String findPage = request.getParameter("findPage");

        FindDao dao = new FindDao();
        int r = dao.insertFind(findTitle,findPage);
        if (r>0){
            out.print("<script>alert('发布成功！');location.href='pushFind.jsp?';</script>");
        }else {
            out.print("<script>alert('发布失败！');location.href='pushFind.jsp?';</script>");
        }

        out.flush();
        out.close();
    }
}
