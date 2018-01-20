package cn.xiaoxi.select.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaoxi.Dao.ProductDao.ProductDaoImpl.ProductServiceImpl;
import cn.xiaoxi.Dao.ProductDao.ProductService;
import cn.xiaoxi.bean.Product;

@SuppressWarnings("serial")
@WebServlet(value="/quesyProduct")
public class QueryProductServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req,resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				String id = req.getParameter("id");	
				//实例化 ProductServiceImpl 调用方法
				ProductService 	ProductService   = new ProductServiceImpl();
				Product product = ProductService.getProductId(id);
				req.setAttribute("product", product);
				req.getRequestDispatcher("home/introduction.jsp").forward(req, resp);
			}
	}	

