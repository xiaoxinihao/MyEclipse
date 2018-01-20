package cn.xiaoxi.util.shopping;

import cn.xiaoxi.bean.Product;

/**
 * 封装购物车中的商品类
 * 
 * @author Administrator
 *
 */
public class ShoppingCartItem {
	 
	private Product product; //购物车中的商品对象
	private int quantity; //商品对应的数量
	
	public ShoppingCartItem(Product product) {
		this.product = product;
		this.quantity=1; //初始化赋值	
	}
	
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 返回该商品在购物车中的总价格
	 * @return
	 */
	public float getItemMoney(){
		return product.getPrice()*quantity;
	}
	
	/**
	 * ajax请求返回该商品在购物车中的总价格
	 * @return
	 */
	public float getOneMoney(int quantity){
		return product.getPrice()*quantity;
	}
	
	/**
	 * 使商品的数量加1
	 */
	public void increment(){
		quantity++;
	}
	
}
