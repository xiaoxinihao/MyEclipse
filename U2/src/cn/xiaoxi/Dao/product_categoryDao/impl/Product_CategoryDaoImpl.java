package cn.xiaoxi.Dao.product_categoryDao.impl;

import java.sql.ResultSet;
import java.util.List;

import cn.xiaoxi.Dao.product_categoryDao.Product_CategoryDao;
import cn.xiaoxi.bean.Product_Category;
import cn.xiaoxi.util.DaoUtil;
import cn.xiaoxi.util.ResultSetUtil;

public class Product_CategoryDaoImpl extends DaoUtil implements
		Product_CategoryDao {

	
	@Override
	public int add(Product_Category t) {
		return 0;
	}

	@Override
	public int dele(Product_Category t) {
		return 0;
	}

	@Override
	public int update(Product_Category t) {
		return 0;
	}
	
	
	//查询菜单的方法
	public List<Product_Category> menu(String parentId) {
		String sql ="select * FROM easybuy_product_category where parentId=? ";
		Object prepars[]={parentId};
		ResultSet resultSet = executeQuery(sql, prepars);
		List<Product_Category> list = ResultSetUtil.eachResultSet(resultSet, Product_Category.class);
		resources();
		return list;
	}


}
