package com.express.dao;

import com.express.bean.User;
import com.express.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by tong on 17-4-5.
 */
public class UserDao {
    //查询用户名重复
    public boolean selectUserName(String userName){
        String sql = "select * from user where userName = '"+userName+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        boolean b = false;
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    b = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return b;
    }

    //用户登录
    public User loginUser(String userName, String userPassword){
        String sql = "select * from user where userName = '"+userName+"' and userPassword = '"+userPassword+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        User user =new User();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    user.setUserid(rs.getInt("userId"));
                    user.setUsername(rs.getString("userName"));
                    user.setUserpassword(rs.getString("userPassword"));
                    user.setUsertype(rs.getInt("userType"));
                    user.setUserphone(rs.getString("userPhone"));
                    user.setUseraddress(rs.getString("userAddress"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return user;
    }

    //用户注册
    public int registUser(String userName, String userPassword,String userPhone,String userAddress){
        String sql = "insert into user(userName,userPassword,userPhone,userAddress) values('"+userName+"','"+userPassword+"','"+userPhone+"','"+userAddress+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //修改密码
    public int updateUserPassword(int userId,String userPassword){
        String sql = "update user set userPassword = '"+userPassword+"' where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //修改地址,电话
    public int updateUserPhoneAddress(int userId,String userPhone,String userAddress){
        String sql = "update user set userPhone = "+userPhone+",userAddress = '"+userAddress+"' where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }
}
