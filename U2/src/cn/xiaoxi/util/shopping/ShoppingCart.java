package cn.xiaoxi.util.shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.xiaoxi.bean.Product;

public class ShoppingCart {
	
	private Map<Integer, ShoppingCartItem> products = new HashMap<>();
	private  ShoppingCartItem cartItem;
	
	/**
	 *检验购物车中是否有指定id的商品 
	 * @param id
	 * @return
	 */
	public boolean hasProducts(Integer id){
		return products.containsKey(id);
	}
	
	/**
	 * 向购物车中添加一件商品
	 * @param product
	 */
	public void addProduct(Product product){
		//检查购物车中是否有商品 若有, 则使其数量 +1,
		//若没有, 新创建其对应的 ShoppingCartItem, 并把其加入到 products集合 中
		ShoppingCartItem sci = products.get(product.getId());
		
		if(sci==null){
			sci = new ShoppingCartItem(product);
			products.put(product.getId(), sci);
		}else{
			sci.increment(); //自身+1
		}
	}
	
	public Map<Integer, ShoppingCartItem> getProducts() {
		return products;
	}
	

	/**
	 * 返回购物车是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return products.isEmpty();
	}
	
	/**
	 * 返回购物车中商品的总数量
	 * @return
	 */
	public int getProductNumber(){
		int total = 0;  
		for(ShoppingCartItem sci: products.values()){
			total += sci.getQuantity();
		}		
		return total;
	}
	
	/**
	 * 获取购物车中的所有的 ShoppingCartItem 组成的集合
	 * @return
	 */
	public Collection<ShoppingCartItem> getItems(){
		return products.values();
	}
	
	/**
	 * 获取购物车中所有的商品的总的钱数
	 * @return
	 */
	public float getTotalMoney(){
		float total = 0;
		
		for(ShoppingCartItem sci: getItems()){
			total += sci.getItemMoney();
		}		
		return total;
	}
	
	/**
	 * 获取购物车中的单个商品总钱数
	 */
	
	public float getItemMoney(Integer id,int quantity){
		ShoppingCartItem sci =products.get(id);
		float oneMoney =0;
		if(sci != null){
			oneMoney = sci.getOneMoney(quantity);
		}
		return oneMoney;
	}
	
	/**
	 * 修改指定购物项的数量
	 */
	public void updateItemQuantity(Integer id, int quantity){
		ShoppingCartItem sci =products.get(id);
		if(sci != null){
			sci.setQuantity(quantity);
		}
	}
	
	/**
	 * 移除指定的购物项
	 * @param id
	 */
	public void removeItem(Integer id){
		products.remove(id);
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		products.clear();
	}	
}
