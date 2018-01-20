package cn.xiaoxi.Dao.userDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.xiaoxi.Dao.userDao.UserDao;
import cn.xiaoxi.bean.User;
import cn.xiaoxi.util.DaoUtil;
import cn.xiaoxi.util.ResultSetUtil;

public class UserDaoImpl extends DaoUtil implements UserDao {

	//管理员删除用户
	public int dele(User user) {
		String sql =" DELETE FROM easybuy_user WHERE loginName=?";	
		Object[] prepars ={user.getLoginName()};
		int num = executeUpdate(sql, prepars);
		return num;	
	}
	
	//管理员修改用户
	public int update(User user) {
		String sql =" UPDATE easybuy_user SET loginName =?,mobile=?,userName=?,PASSWORD=?,sex=?,email=? WHERE loginName =?";	
		Object[] prepars ={user.getLoginName(),user.getMobile(), user.getUserName(),user.getPassword(),user.getSex(),user.getEmail(),user.getLoginName()};
		int num = executeUpdate(sql, prepars);
		return num;	
	}
	
	//管理员增加用户
	public int add(User user) {
		String sql = "insert into easybuy_user(loginName,mobile,userName,password,sex,email) values(?,?,?)";
		Object prepars[]={user.getLoginName(),user.getMobile(), user.getUserName(),user.getPassword(),user.getSex(),user.getEmail()};
		int num = executeUpdate(sql, prepars);
		return num;
	}
	
	//登录
	public User login(String name, String password) {
		String sql = "select * FROM easybuy_user where loginName=? and password=? ";
		Object prepars[]={name,password};
		ResultSet resultSet = executeQuery(sql, prepars);
		User user = ResultSetUtil.OneResultSet(resultSet, User.class);
		resources();
		return user;
	}
	
	//  手机号注册
	public int phoneAdd(User user) {
		String sql = "insert into easybuy_user(loginName,password,mobile) values(?,?,?)";
		Object prepars[]={user.getLoginName(),user.getPassword(),user.getMobile()};
		int num = executeUpdate(sql, prepars);
		return num;
	}

	// 邮箱注册
	public int emailAdd(User user) {
		String sql = "insert into easybuy_user(loginName,password,email) values(?,?,?)";
		Object prepars[]={user.getLoginName(),user.getPassword(),user.getEmail()};
		int num = executeUpdate(sql, prepars);
		return num;
	}

	// 验证用户是否存在
	public User userNameVerify(String name) {
		User user=null;
		String sql = "select * FROM easybuy_user where loginName=?";
		Object prepars[]={name};

		ResultSet resultSet = executeQuery(sql, prepars);
		if(resultSet!=null){
		try {
			while (resultSet.next()) {
				user = new User();
				user.setLoginName(resultSet.getString("loginName"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			resources();
		}	
			return user;
		}
		return null;
	}
}
