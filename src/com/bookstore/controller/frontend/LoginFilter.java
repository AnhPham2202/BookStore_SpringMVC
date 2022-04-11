package com.bookstore.controller.frontend;

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
@WebFilter("/frontend/*")
public class LoginFilter implements Filter {
	public LoginFilter() {
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
		boolean rootPath = httpReq.getRequestURI().endsWith("frontend") || httpReq.getRequestURI().endsWith("frontend/");
		HttpSession session = httpReq.getSession();
		Object customerSession = session.getAttribute("customer");
		if (customerSession == null && rootPath == false) {
			httpRes.sendRedirect(httpReq.getContextPath() + "/customer/log-in");
		} else {
			chain.doFilter(request, response);
		}
	}
}
