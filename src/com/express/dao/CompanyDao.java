package com.express.dao;

import com.express.bean.Company;
import com.express.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-4-5.
 */
public class CompanyDao {

    //查询所有快递公司
    public List<Company> selectCompany(){
        String sql = "select * from company";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Company> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Company company = new Company();
                    company.setCompanyid(rs.getInt("companyId"));
                    company.setCompanyname(rs.getString("companyName"));
                    list.add(company);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //添加快递公司
    public int insetCompany(String companyName){
        String sql = "inset into company(companyName) values('"+companyName+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
