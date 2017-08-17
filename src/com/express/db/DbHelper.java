package com.express.db;
import java.sql.*;

public class DbHelper {
	/**
	 * 数据库修改方�?
	 */
	 public static int executeSql(String sql){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			con = getconnection();
			st = con.createStatement();
			return st.executeUpdate(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			closeConnectionAndStatement(rs,con,st);
		}
		return 0;
	}
	 /**
	  * 建立链接
	  * */
	public static Connection getconnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/express?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//关闭连接
	public static void closeConnectionAndStatement(ResultSet rs,Connection con, Statement st){
		try {
			if (rs!=null)rs.close();
			if(st!=null)st.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
