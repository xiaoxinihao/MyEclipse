package cn.xiaoxi.Dao.ProductDao.ProductDaoImpl;

import java.sql.SQLException;
import java.util.List;

import cn.xiaoxi.Dao.ProductDao.ProductDao;
import cn.xiaoxi.bean.Product;
import cn.xiaoxi.util.DaoUtil;
import cn.xiaoxi.util.PageUtil;
import cn.xiaoxi.util.ResultSetUtil;

public class ProductDaoImpl extends DaoUtil implements ProductDao {

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

	
	
	//查询总记录的条数
	public int getCounts(String keyword,String categoryid) {
		StringBuffer sql = new StringBuffer("select count(*) from easybuy_product where 1=1 ");
		if(keyword!=null&&keyword!=""){
			sql.append(" and name like '%"+keyword+"%'");
		}
		if(categoryid!=null&&categoryid!=""){
			sql.append(" and categoryLevel3Id ="+ categoryid);
		}
		 rs = executeQuery(sql.toString());
		int counts=0;		
		try {
			if(rs.next()){
				counts = rs.getInt(1); //获取数据库中第一列的值
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			resources();
		}
		return counts;
	}

	// 收搜商品并分页显示五条数据
	public List<Product> getProductList(PageUtil util,String keyword,String categoryid) {		
		StringBuffer sql = new StringBuffer("select * from easybuy_product where 1=1 ");
		if(keyword!=null&&keyword!=""){
			//sql.append(" and name like '%"+keyword+"%'");
			sql.append(" and name like '%"+keyword+"%'");
		}
		if(categoryid!=null&&categoryid!=""){
			sql.append(" and categoryLevel3Id =" + categoryid);
		}
		
		sql.append(" limit "+(util.getPageIndex()-1)*util.getPageSize()+","+util.getPageSize()); //sql语句的拼接
		 rs = executeQuery(sql.toString());

		List<Product> products = ResultSetUtil.eachResultSet(rs, Product.class);

		resources();
		return products;
	}

	//查询商品详情
	public Product getProductId(String id) {
		String sql = "select * from easybuy_product where id=? ";
		Object prepars[]={id};
		rs= executeQuery(sql, prepars);
		Product product = ResultSetUtil.OneResultSet(rs, Product.class);
		resources();
		return product;
	}
}
