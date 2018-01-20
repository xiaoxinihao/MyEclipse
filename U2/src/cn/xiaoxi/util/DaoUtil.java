/**
 * 连接数据的工具类
 */

package cn.xiaoxi.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoUtil {
	protected	static  Connection conn= null;
	protected	static  PreparedStatement prs= null;
	protected	static	ResultSet rs = null;
	 
	//连接数据库
	public static boolean getConnection(){
		try {
			// 使用 JNDI 技术
			Context context = new InitialContext(); // 数据源连接数据库
			DataSource dataSource= (DataSource) context.lookup("java:comp/env/jdbc/easybuy");
			// 获取连接
			conn = dataSource.getConnection();
			return true;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		 return false;
	}
	
	//关闭连接的方法
	public static void resources(){
		
		if (prs!=null) {
			try {
				prs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 查询的通用方法
	public static ResultSet executeQuery(String sql,Object ... prepars ){
		if(getConnection()){
			try {
				prs=conn.prepareStatement(sql);
				for (int i = 0; i < prepars.length; i++) {
					prs.setObject(i+1,prepars[i]);
				}
				rs = prs.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return rs;	
	}

	// 增删改的通用方法	
	public static int executeUpdate(String sql,Object...prepars){
		int num=0;
		if(getConnection()){
			try {
				prs=conn.prepareStatement(sql);
				for (int i = 0; i < prepars.length; i++) {
					prs.setObject(i+1, prepars[i]);
				}
				num = prs.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				resources();
			}
		}	
		return num;	
	}
}
