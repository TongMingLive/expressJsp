package com.express.dao;

import com.express.bean.Place;
import com.express.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-4-6.
 */
public class PlaceDao {

    //申请代领
    public int insertPlace(int userId,int sendId){
        String sql = "insert into place(userId,sendId) values("+userId+","+sendId+")";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //更改代领状态
    public int updatePlace(int placeId,int placeType){
        String sql = "update place set placeType = "+placeType+" where placeId = "+placeId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查看个人代领信息
    public List<Place> selectUserPlace(int userId){
        String sql = "select * from place where userId = "+userId;
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Place> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Place place = new Place();
                    place.setPlaceid(rs.getInt("placeId"));
                    place.setSendid(rs.getInt("sendId"));
                    place.setPlacetype(rs.getInt("placeType"));
                    list.add(place);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //查看所有代领信息
    public List<Place> selectAllPlace(){
        String sql = "select p.*,u.userName from place p,user u where p.userId = u.userId";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Place> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Place place = new Place();
                    place.setPlaceid(rs.getInt("placeId"));
                    place.setUserName(rs.getString("userName"));
                    place.setSendid(rs.getInt("sendId"));
                    place.setPlacetype(rs.getInt("placeType"));
                    list.add(place);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }



}
