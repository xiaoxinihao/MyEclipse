package cn.xiaoxi.Dao.product_categoryDao;

import java.util.List;

import cn.xiaoxi.bean.Product_Category;
import cn.xiaoxi.Dao.BaseDao;

public interface Product_CategoryDao extends BaseDao<Product_Category> {
	
	//查询菜单
	public List<Product_Category> menu(String parentId);
	
}
