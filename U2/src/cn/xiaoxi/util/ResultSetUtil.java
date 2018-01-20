package cn.xiaoxi.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ResultSetUtil {
	
	//获取所有的对象保存在集合中
		public static <T> List<T> eachResultSet(ResultSet rs,Class<T> clazz) {
			List<T> list = new ArrayList<>();
			 T t = null ;
			 try {
				while (rs.next()) {
					t=clazz.newInstance(); //获取对象的实例
					Field[] fields = clazz.getDeclaredFields();  //获取类中的所有字段
					for (Field f: fields) {
						if(f.getName().equals("util")){
							continue;
						}
						f.setAccessible(true); //同意获取所有包括私有
						f.set(t, rs.getObject(f.getName()));
					}
					list.add(t);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return list;	
		}

		  //获取一个对象
		public static <T> T OneResultSet(ResultSet rs,Class<T> clazz) {
			 T t = null ;
			try {
				while (rs.next()) {
					t=clazz.newInstance(); //获取对象的实例
					Field[] fields = clazz.getDeclaredFields();  //获取类中的所有字段
					for (Field f: fields) {
						if(f.getName().equals("util")){
							continue;
						}
						f.setAccessible(true); //同意获取所有包括私有
						f.set(t, rs.getObject(f.getName()));
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					return t;	
				}

}
