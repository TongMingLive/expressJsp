package com.express.dao;

import com.express.bean.Find;
import com.express.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-4-5.
 */
public class FindDao {

    //查看所有失物召领信息
    public List<Find> selectFind(){
        String sql = "select * from find";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Find> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Find find = new Find();
                    find.setFindid(rs.getInt("findId"));
                    find.setFindtitle(rs.getString("findTitle"));
                    find.setFindpage(rs.getString("findPage"));
                    list.add(find);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //发布失物招领信息
    public int insertFind(String findTitle,String findPage){
        String sql = "insert into find(findTitle,findPage) values('"+findTitle+"','"+findPage+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
