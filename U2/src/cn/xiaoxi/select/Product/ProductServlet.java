package cn.xiaoxi.select.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.xiaoxi.Dao.ProductDao.ProductDaoImpl.ProductServiceImpl;
import cn.xiaoxi.Dao.ProductDao.ProductService;
import cn.xiaoxi.bean.Product;
import cn.xiaoxi.util.PageUtil;

@SuppressWarnings("serial")
@WebServlet(value="/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	//实例化 ProductServiceImpl 调用方法
	ProductService 	ProductService   = new ProductServiceImpl();
	PageUtil util = new PageUtil();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setCharacterEncoding("utf-8");	
			
			
			//获取前台请求带的参数
			String flag = req.getParameter("flag");
			//根据请求获取不同的值 进入不同的方法
			if ("search".equals(flag)) {
				search(req,resp);
			}else if("queryProduct".equals(flag)){
				queryProduct(req,resp);
			}else{
		
			String keyword	= req.getParameter("keyword");
			String categoryid = req.getParameter("Categoryid");
			//实例化 ProductServiceImpl 调用方法
			
			util.setTotalCount(ProductService.getCounts(keyword,categoryid)); // 通过关键字获取总记录数
			
			String pageIndex = req.getParameter("pageIndex");
			if(pageIndex==null || pageIndex==""){
				util.setPageIndex(1);		
			}else{
				util.setPageIndex(Integer.parseInt(pageIndex));
			}
			
			List<Product> productList = ProductService.getProductList(util, keyword,categoryid);
			if(productList.size()==0){
				resp.sendRedirect(req.getContextPath()+"/error-1.jsp");
			}else{
				productList.get(0).setUtil(util);
				Gson gson = new Gson();	
				String json = gson.toJson(productList);
				PrintWriter writer = resp.getWriter();
				writer.print(json);		
				writer.close();	
			}	
		}
	}

	

	//从主页面获取查询的方法
	private void search(HttpServletRequest req, HttpServletResponse resp) {
		
		String keyword	= req.getParameter("index_none_header_sysc");
		
		String categoryid = req.getParameter("Categoryid");
		
		//实例化 ProductServiceImpl 调用方法
	
		
		util.setTotalCount(ProductService.getCounts(keyword,categoryid)); // 通过关键字获取总记录数	
		util.setPageIndex(1); //默认显示第一页的内容
	
		//分页的方法
		List<Product> productList = ProductService.getProductList(util,keyword,categoryid);
		if(productList.size()==0){
			try {
				resp.sendRedirect(req.getContextPath()+"/error-1.jsp");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			req.setAttribute("productList", productList);
			req.setAttribute("keyword", keyword);
			try {
				req.getRequestDispatcher("home/search.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//点击三级列表查询
		private void queryProduct(HttpServletRequest req, HttpServletResponse resp) {
			
			String categoryid	= req.getParameter("Categoryid");
			String keyword	= req.getParameter("index_none_header_sysc");
			
			util.setTotalCount(ProductService.getCounts(keyword,categoryid)); // 通过关键字获取总记录数	
			util.setPageIndex(1); //默认显示第一页的内容
		
			//分页的方法
			List<Product> productList = ProductService.getProductList(util,keyword,categoryid);

			if(productList.size()==0){
				try {
					resp.sendRedirect(req.getContextPath()+"/error-1.jsp");
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				req.setAttribute("productList", productList);
				req.setAttribute("keyword",productList.get(0).getName() );
				try {
					req.getRequestDispatcher("home/search.jsp").forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	

}
