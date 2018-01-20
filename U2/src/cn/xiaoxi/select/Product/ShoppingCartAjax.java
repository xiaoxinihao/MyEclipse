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
@WebServlet(value="/ShoppingCartAjax")
public class ShoppingCartAjax extends HttpServlet {
	
	//调用 ProductServiceImpl 的addToCart方法把商品放入购物车中
	ProductService 	ProductService   = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String flag = req.getParameter("flag");
			if(flag.equals("changeNumb")){
				changeNumb(req,resp);
			}else if (flag.equals("delete")) {
				delect(req,resp);
			}else if(flag.equals("deleteAll")){
				deleteAll(req,resp);
			}
	}
	//清空购物车
	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) {
		 //获取购物车对象
		ShoppingCart sc = ProductStoreUtil.getShoppingCart(req);	
		ProductService.clear(sc);
		if(sc.isEmpty()){
			try {
				resp.sendRedirect(req.getContextPath()+"/home/shopping.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//点击删除  删除当前商品
	private void delect(HttpServletRequest req, HttpServletResponse resp) {
		//获取数据
		String idstr = req.getParameter("id");
		int  id= Integer.parseInt(idstr);
		ShoppingCart sc = ProductStoreUtil.getShoppingCart(req);	
		ProductService.delete(sc,id);	
		if(sc.isEmpty()){
			try {
				resp.sendRedirect(req.getContextPath()+"/home/shopping.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				resp.sendRedirect(req.getContextPath()+"/home/shoppingcart.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	 //点击按钮给商品数量对应的增加减少的方法
	private void changeNumb(HttpServletRequest req, HttpServletResponse resp) {
		 String idstr = req.getParameter("id");
		 String quantutystr = req.getParameter("quantuty");		
		 //获取购物车对象
		 ShoppingCart sc = ProductStoreUtil.getShoppingCart(req);		 
		//转换类型
		 int  id= Integer.parseInt(idstr);
		 int  quantuty= Integer.parseInt(quantutystr);
		 
		ProductService.upadteItem(sc,id,quantuty);
		//拿取数据转换json格式
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("ProductNumber",sc.getProductNumber());
		result.put("TotalMoney",sc.getTotalMoney());
		result.put("ItemMoney",sc.getItemMoney(id, quantuty));
		Gson gson = new Gson();	
		String json = gson.toJson(result);
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.print(json);		
			writer.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
