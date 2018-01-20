package cn.xiaoxi.Dao.product_categoryDao;

import java.util.List;

import cn.xiaoxi.bean.Product_Category;
import cn.xiaoxi.Dao.ServiceDao;
import cn.xiaoxi.util.ProductCategory;

public interface Product_CategoryService extends ServiceDao<Product_Category> {

	//查询三级菜单所有信息的方法
	public List<ProductCategory> menu();

}
