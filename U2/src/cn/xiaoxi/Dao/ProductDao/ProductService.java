package cn.xiaoxi.Dao.ProductDao;

import java.util.List;

import cn.xiaoxi.bean.Product;
import cn.xiaoxi.Dao.ServiceDao;
import cn.xiaoxi.util.PageUtil;
import cn.xiaoxi.util.shopping.ShoppingCart;

public interface ProductService extends ServiceDao<Product>{
	
	//获取总记录数
	public int getCounts(String keyword,String categoryid);
		
	// 模糊查询所有的功能 ,点击三级菜单查询
	public List<Product> getProductList(PageUtil util,String keyword,String categoryid );
	
	//根据商品id查询商品详情的方法
	public Product getProductId(String id);

	//添加一个商品的方法
	public boolean addToCart(int id, ShoppingCart sc);

	//修改商品在购物车中数量的方法
	public void upadteItem(ShoppingCart sc, int id, int quantuty);

	//删除购物车中的商品方法
	public void delete(ShoppingCart sc, int id);

	//清空购物车的方法
	public void clear(ShoppingCart sc);

}
