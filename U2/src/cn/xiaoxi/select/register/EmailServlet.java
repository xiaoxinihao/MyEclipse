package cn.xiaoxi.select.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaoxi.Dao.userDao.UserService;
import cn.xiaoxi.Dao.userDao.impl.UserServiceImpl;
import cn.xiaoxi.bean.User;
import cn.xiaoxi.util.Md5;


@SuppressWarnings("serial")
@WebServlet(value="/EmailSelect")
public class EmailServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		 
		user.setLoginName(email);
		user.setPassword(Md5.MD5(password));
		user.setEmail(email);
		
		UserService userService = new UserServiceImpl();
		int num = userService.emailAdd(user);
		
		if(num>0){
			resp.sendRedirect("home/login.jsp");
		}else {
			resp.sendRedirect("home/register.jsp");
		}	
		
	}
}
