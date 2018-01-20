package cn.xiaoxi.Dao.userDao;

import cn.xiaoxi.bean.User;
import cn.xiaoxi.Dao.BaseDao;

public interface UserDao extends BaseDao<User> {
	
	  	//注册
	public int add(User user);
	
	  // 邮箱注册
	public int phoneAdd(User user);
		
	  // 手机注册
	public int emailAdd(User user);
	
	   //登录
	public User login(String name,String password);
	
		//验证用户是否存在
	public User userNameVerify(String name);
		
		//修改
	public int dele(User user);
		
		//删除
	public int update(User user);
	
}
