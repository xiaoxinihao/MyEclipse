package cn.xiaoxi.Dao.ProductDao;

import java.util.List;

import cn.xiaoxi.bean.Product;
import cn.xiaoxi.Dao.BaseDao;
import cn.xiaoxi.util.PageUtil;

public interface ProductDao extends BaseDao<Product> {
	 
	//获取总记录数
	public int getCounts(String keyword,String categoryid);
	
	// 模糊查询所有的功能 
	public List<Product> getProductList(PageUtil util,String keyword,String categoryid );
	
	//根据商品id查询商品详情的方法
	public Product getProductId(String id);
	

}
