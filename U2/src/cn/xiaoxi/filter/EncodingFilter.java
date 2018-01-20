package cn.xiaoxi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter extends HttpFilter {

	
	// 定义一个变量 来保存全文配置的编码格式
	 private String encoding;
	 	
	@Override
	protected void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}

	// 更改所有访问的  编码格式
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
			request.setCharacterEncoding(encoding);
			filterChain.doFilter(request, response);       
	}
}
