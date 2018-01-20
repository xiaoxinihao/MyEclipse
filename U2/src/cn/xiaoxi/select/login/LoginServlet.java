package cn.xiaoxi.select.login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xiaoxi.Dao.userDao.UserService;
import cn.xiaoxi.Dao.userDao.impl.UserServiceImpl;
import cn.xiaoxi.bean.User;
import cn.xiaoxi.util.Md5;

@SuppressWarnings("serial")
@WebServlet(value="/LoginSelect")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		
		UserService impl = new UserServiceImpl();
		User user = impl.login(userName, Md5.MD5(password));		
		if(user!=null){			
			String userInfo  = user.toString();
			Cookie cookie = new Cookie("user",userInfo); 
			cookie.setMaxAge(3*60);//设置有效期两分钟
			cookie.setPath("/");
			response.addCookie(cookie);//放到客户端
			 
			HttpSession session = request.getSession();
			session.setAttribute("user",userInfo);
			session.setMaxInactiveInterval(60*60);//1小时
			response.sendRedirect(request.getContextPath()+"/home/home.jsp");
		}else{			
			response.sendRedirect(request.getContextPath()+"/home/login.jsp");
		}	
	}	
}