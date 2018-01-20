package cn.xiaoxi.util.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ProductStoreUtil {
	
	/**
	 *  获取购物车对象：从session 中获取，若session中没有对象
	 *  则重新创建一个新的对象，放入session中 
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public static ShoppingCart getShoppingCart(HttpServletRequest req){
		HttpSession session = req.getSession();	
		
		//获取对象放入session中
		ShoppingCart sc= (ShoppingCart) session.getAttribute("ShoppingCart");
		if( sc == null){
			//没有就创建
			sc = new ShoppingCart();
			session.setAttribute("ShoppingCart", sc);
		}
		return sc;
	}
}
