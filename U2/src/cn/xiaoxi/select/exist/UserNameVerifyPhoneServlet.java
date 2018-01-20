package cn.xiaoxi.select.exist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaoxi.Dao.userDao.UserService;
import cn.xiaoxi.Dao.userDao.impl.UserServiceImpl;
import cn.xiaoxi.bean.User;

@SuppressWarnings("serial")
@WebServlet(value="/UserNameVerifyPhoneSelect")
public class UserNameVerifyPhoneServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String phone = req.getParameter("phone");
		
		UserService userService = new UserServiceImpl();
		User userNameVerify = userService.userNameVerify(phone);
		
		boolean falg=true;		
		if(userNameVerify != null){
			falg= false;
		}
		resp.getWriter().print(falg);		
	}
}
