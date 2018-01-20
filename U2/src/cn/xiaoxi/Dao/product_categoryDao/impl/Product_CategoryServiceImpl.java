package cn.xiaoxi.Dao.product_categoryDao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xiaoxi.Dao.product_categoryDao.Product_CategoryDao;
import cn.xiaoxi.Dao.product_categoryDao.Product_CategoryService;
import cn.xiaoxi.bean.Product_Category;
import cn.xiaoxi.util.ProductCategory;

public class Product_CategoryServiceImpl implements Product_CategoryService {

	Product_CategoryDao product_Category = new Product_CategoryDaoImpl();
	
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

	//查询菜单的方法返回一个list集合
	public List<ProductCategory> menu() {
		// 查询一级菜单的列表 保存list集合
		List<ProductCategory> pc1 = new ArrayList<ProductCategory>();
		
		//查询出一级分类
		List<Product_Category> pcList1 = product_Category.menu("0");
		
		//查询出二级分类
		for (Product_Category product_Category1 : pcList1) {
			//创建一级查单的辅助类
			ProductCategory Category1 = new ProductCategory();
			
			//查询出来的值赋值给ProductCategory对象的 Product_Category属性
			Category1.setProduct_Category(product_Category1); 
			
			//查询二级分类的列表
			List<ProductCategory> pc2 = new ArrayList<ProductCategory>();
			List<Product_Category> pcList2 = product_Category.menu(product_Category1.getId()+"");
			for (Product_Category product_Category2 : pcList2) {
				ProductCategory Category2 = new ProductCategory();
				Category2.setProduct_Category(product_Category2);
				
				//查询三级分类的列表
				List<ProductCategory> pc3 = new ArrayList<ProductCategory>();
				
				//查询三级分类
				List<Product_Category> pcList3 = product_Category.menu(product_Category2.getId()+"");
				for (Product_Category product_Category3 : pcList3) {
					
					ProductCategory Category3 = new ProductCategory();
					Category3.setProduct_Category(product_Category3);
					pc3.add(Category3);
				}
				Category2.setListPC(pc3); 
				pc2.add(Category2);
			}
			Category1.setListPC(pc2);
			pc1.add(Category1);
		}
		return pc1;
	}




} 
