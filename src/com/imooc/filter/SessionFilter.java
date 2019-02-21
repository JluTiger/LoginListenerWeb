package com.imooc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录权限过滤器
 */
public class SessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponse hresponse = (HttpServletResponse)response;
		
		String loginUser = (String)hrequest.getSession().getAttribute("loginUser");//从session对象中获取登录用户名
		
		if(loginUser==null){//登录用户名不存在，用户未登录，强制重定向至登陆页面
			hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?flag=1");
			return;
			
		}else{
			chain.doFilter(request, response);//已登录，转入相应的请求处理
			return;
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
