package cn.xiaoxi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  自定义 HttpFilter ，实现Filter接口
 */
public abstract  class HttpFilter implements Filter {

	private	FilterConfig filterConfig;
	
	
	@Override  // 不建议 子类直接覆盖 
	public void init(FilterConfig filterConfig) throws ServletException {
       		this.filterConfig = filterConfig;
       		init();	
	}
	 
	
	//子类继承 初始化时调用该方法  获取配置的信息
	protected void init(){}
	
	
	//   提供getFilterConfig() 方法  供需要获取的时候使用  返回 init(ServletConfig) 的FilterConfig 对象
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}  
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp , FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		doFilter(request, response, chain);
		
	}
	
	// 定义自己的方法 传 httpFilter
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)throws IOException, ServletException;

	public void destroy() {
		
	}

}
