package com.sunbeam.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class LogsFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LogFilter init() called!");
	}
	
	@Override
	public void destroy() {
		System.out.println("LogFilter destroy() called!");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest rq = (HttpServletRequest) request;
			System.out.println("Log before : "+rq.getRequestURI());
			chain.doFilter(request, response);
			System.out.println("After before : "+rq.getRequestURI());
		
	}
	
}
