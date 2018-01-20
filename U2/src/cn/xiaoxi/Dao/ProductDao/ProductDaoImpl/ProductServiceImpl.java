package cn.xiaoxi.Dao.ProductDao.ProductDaoImpl;

import java.util.List;

import cn.xiaoxi.Dao.ProductDao.ProductDao;
import cn.xiaoxi.Dao.ProductDao.ProductService;
import cn.xiaoxi.bean.Product;
import cn.xiaoxi.util.PageUtil;
import cn.xiaoxi.util.shopping.ShoppingCart;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao  =  new ProductDaoImpl();
	private int quantuty;

	@Override
	public int add(Product t) {
		return 0;
	}

	@Override
	public int dele(Product t) {
		return 0;
	}

	@Override
	public int update(Product t) {
		return 0;
	}

	
	
	//查询总记录数
	public int getCounts(String keyword,String categoryid) {
		int counts = productDao.getCounts(keyword,categoryid);
		return counts;
	}

	//使用分页
	public List<Product> getProductList(PageUtil util, String keyword,String categoryid) {
		List<Product> productList = productDao.getProductList(util, keyword,categoryid);		
		return productList;
	}

	//商品详情信息
	public Product getProductId(String id) {
		Product product = productDao.getProductId(id);
		return product;
	}

	//给购物车中添加商品
	public boolean addToCart(int id, ShoppingCart sc) {
		Product product = getProductId(id+"");
		if(product !=null){
			sc.addProduct(product);
			return true;
		}
		return false;
	}

	//在购物车中的修改数量的方法
	public void upadteItem(ShoppingCart sc, int id, int quantuty) {
		sc.updateItemQuantity(id, quantuty);	
	}

	//删除购物车中的指定商品
	public void delete(ShoppingCart sc, int id) {
		sc.removeItem(id);
	}

	//清空购物车
	public void clear(ShoppingCart sc) {
		sc.clear();
	}

	
}
