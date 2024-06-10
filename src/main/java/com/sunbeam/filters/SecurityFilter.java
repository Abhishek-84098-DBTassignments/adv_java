package com.sunbeam.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.entities.User;

public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession session = rq.getSession();
		User usr = (User) session.getAttribute("curuser");
		if(usr == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("index.html");
		}else
			chain.doFilter(request, response);
		
	}

}
