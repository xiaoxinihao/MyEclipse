package cn.xiaoxi.util;

import java.util.List;

import cn.xiaoxi.bean.Product_Category;
  /**
   * 用来获取数据库中的三级菜单所有数据的辅助类
   * @author Administrator
   *
   */
public class ProductCategory {
	
	private	Product_Category  product_Category;  //将Product_Category 的对象当成这个类的属性
	private List<ProductCategory> listPC;
	
	public Product_Category getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(Product_Category product_Category) {
		this.product_Category = product_Category;
	}
	public List<ProductCategory> getListPC() {
		return listPC;
	}
	public void setListPC(List<ProductCategory> listPC) {
		this.listPC = listPC;
	}
	
	
	
}


