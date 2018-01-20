package cn.xiaoxi.select.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.xiaoxi.Dao.ProductDao.ProductDaoImpl.ProductServiceImpl;
import cn.xiaoxi.Dao.ProductDao.ProductService;
import cn.xiaoxi.util.shopping.ProductStoreUtil;
import cn.xiaoxi.util.shopping.ShoppingCart;

@SuppressWarnings("serial")
@WebServlet(value="/Shopping")
public class ShoppingAjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//获取商品的id
		String idstr = req.getParameter("id");	
		int id = Integer.parseInt(idstr);
		
		//获取购物车对象
		ShoppingCart sc = ProductStoreUtil.getShoppingCart(req);
		
		//调用 ProductServiceImpl 的addToCart方法把商品放入购物车中
		ProductService 	ProductService   = new ProductServiceImpl();
		boolean flag = ProductService.addToCart(id,sc);		
		if(flag){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("ProductNumber",sc.getProductNumber());
			Gson gson = new Gson();	
			String json = gson.toJson(result);
			PrintWriter writer = resp.getWriter();
			writer.print(json);		
			writer.close();	
		}else{
			try {
				resp.sendRedirect(req.getContextPath()+"/error-1.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	

}
