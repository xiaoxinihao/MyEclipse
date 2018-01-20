package cn.xiaoxi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaoxi.bean.User;

public class CharsetFilter extends HttpFilter {

	/*
	 * 获取请求路径 getRequestURL===> http://localhost:8080/06Filter/login.jsp 统一资源定位符
	 * 最精确 getRequestURI===> /06Filter/login.jsp 统一资源标识符
	 * getContextPath===>/06Filter 项目名称 getServletPath===>/login.jsp 具体的资源
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/* 
	 * doFilter 使我们定义拦截规则的地方 只要有请求就不会进入
	 * 当 session 中有用户信息时 用户直接访问login.jsp 所有的静态资源 css js img
	 */
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		// 查看session 中是否有值
		User user = (User) request.getSession().getAttribute("user");

		// 获取请求的资源路径
		String path = request.getServletPath();
		if (user != null) {
			filterChain.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/home/login.jsp");
		}
	}
}
