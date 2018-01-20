package cn.xiaoxi.select;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xiaoxi.Dao.product_categoryDao.impl.Product_CategoryServiceImpl;
import cn.xiaoxi.util.ProductCategory;

@SuppressWarnings("serial")
@WebServlet(value="/home")
public class HomeServlet extends HttpServlet {
	private Product_CategoryServiceImpl PCSl=null;	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			PCSl = new Product_CategoryServiceImpl();
			List<ProductCategory> list = PCSl.menu();
			
			ServletContext application = this.getServletContext();
			application.setAttribute("list", list);
			resp.sendRedirect("home/home.jsp");
	}
}
