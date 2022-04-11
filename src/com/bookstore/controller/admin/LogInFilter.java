package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LogInFilter
 */
@WebFilter("/admin/*")
public class LogInFilter implements Filter {
	public LogInFilter() {
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		boolean rootPath = httpReq.getRequestURI().endsWith("admin") || httpReq.getRequestURI().endsWith("admin/");
		HttpSession session = httpReq.getSession();
		Object userSession = session.getAttribute("user");
		if (userSession == null && rootPath == false) {
			httpRes.sendRedirect(httpReq.getContextPath() + "/user/log-in");
		} else {
			chain.doFilter(request, response);
		}
	}
}
