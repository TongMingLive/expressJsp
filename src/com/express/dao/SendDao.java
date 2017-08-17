package com.express.dao;

import com.express.bean.Send;
import com.express.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-4-5.
 */
public class SendDao {

    //公共方法
    public List<Send> getList(String sql){
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Send> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Send send = new Send();
                    send.setSendid(rs.getInt("sendId"));
                    send.setCompanyName(rs.getString("companyName"));
                    send.setUserphone(rs.getString("userPhone"));
                    send.setUseraddress(rs.getString("userAddress"));
                    send.setSendtype(rs.getInt("sendType"));
                    send.setSendappraise(rs.getDouble("sendAppraise"));
                    send.setSendpage(rs.getString("sendPage"));
                    list.add(send);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //提交快递订单
    public int insertSend(int companyId,int userId,String userPhone,String userAddress){
        String sql = "insert into send(companyId,userId,userPhone,userAddress) values("+companyId+","+userId+",'"+userPhone+"','"+userAddress+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //更新快件状态
    public int updateSendType(int sendId,int sendType){
        String sql = "update send set sendType = "+sendType+" where sendId = "+sendId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //发表快件服务评论
    public int updateSendAppraise(int sendId,Double sendAppraise,String sendPage){
        String sql = "update send set sendAppraise = "+sendAppraise+",sendPage = '"+sendPage+"' where sendId = "+sendId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查看个人快递订单
    public List<Send> selectUserSend(int userId){
        String sql = "select s.*,c.companyName from send s,company c where s.companyId = c.companyId and userId = "+userId;
        List<Send> list = getList(sql);
        return list;
    }

    //查看所有用户快递订单
    public List<Send> selectAllSend(){
        String sql = "select s.*,u.userName,c.companyName from send s,user u,company c where s.userId = u.userId and s.companyId = c.companyId";
        List<Send> list = getList(sql);
        return list;
    }

    public List<Send> selectAllNotUserSend(int userId){
        String sql = "select s.*,u.userName,c.companyName from send s,user u,company c where s.userId = u.userId and s.companyId = c.companyId and s.userId <> "+userId+" and s.sendType = 1";
        List<Send> list = getList(sql);
        return list;
    }

    public Send selectSendById(int sendId){
        String sql = "SELECT s.*,u.userName,c.companyName FROM send s,user u,company c WHERE s.userId = u.userId AND s.companyId = c.companyId AND sendId = "+sendId;
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        Send send = new Send();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    send.setSendid(rs.getInt("sendId"));
                    send.setCompanyName(rs.getString("companyName"));
                    send.setUserName(rs.getString("userName"));
                    send.setUserphone(rs.getString("userPhone"));
                    send.setUseraddress(rs.getString("userAddress"));
                    send.setSendtype(rs.getInt("sendType"));
                    send.setSendappraise(rs.getDouble("sendAppraise"));
                    send.setSendpage(rs.getString("sendPage"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return send;
    }

}
