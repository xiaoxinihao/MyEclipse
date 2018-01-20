package cn.xiaoxi.Dao.userDao.impl;

import cn.xiaoxi.Dao.userDao.UserDao;
import cn.xiaoxi.Dao.userDao.UserService;
import cn.xiaoxi.bean.User;

public class UserServiceImpl implements UserService  {

	UserDao userDao  = new UserDaoImpl(); // 实例化DAO层的对象
	
	//管理员删除用户
	public int dele(User user) {
		int num = userDao.dele(user);
		return num;	
	}

	//管理员修改用户
	public int update(User user) {
		int num = userDao.update(user);
		return num;	
	}

	//管理员增加用户
	public int add(User user) {
		int num = userDao.add(user);
		return num;			
	}

	// 登录
	public User login(String name, String password) {
		User user = userDao.login(name, password);
		if(user!=null){	
			 return user ;	
	  	}else{			
			return null;
			}
		}

	// 手机号注册
	public int phoneAdd(User user) {
		int num = userDao.phoneAdd(user);
		return num;
	}

	// 邮箱注册
	public int emailAdd(User user) {
		int num = userDao.emailAdd(user);
		return num;
	}
	//验证用户是否存在
	public User userNameVerify(String name) {
		User user = userDao.userNameVerify(name);
		if(user!=null){	
			 return user ;	
	  	}else{			
			return null;
			}
	}
}
