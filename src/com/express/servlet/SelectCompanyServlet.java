package com.express.servlet;

import com.express.bean.Company;
import com.express.bean.Find;
import com.express.dao.CompanyDao;
import com.express.dao.FindDao;
import net.sf.json.JSONArray;

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
@WebServlet(name = "SelectCompanyServlet",urlPatterns = "/SelectCompanyServlet")
public class SelectCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        CompanyDao dao = new CompanyDao();
        List<Company> list = dao.selectCompany();
        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray.toString());

        out.flush();
        out.close();
    }
}
