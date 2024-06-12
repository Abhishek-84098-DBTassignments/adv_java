package com.sunbeam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AppController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}
	
	protected void requestProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String uri = "/WEB-INF/pages/index.jsp";
		if(page.equals("index"))
			uri = "/WEB-INF/pages/index.jsp";
		else if(page.equals("login"))
			uri = "/WEB-INF/pages/login.jsp";
		else if(page.equals("newuser"))
			uri = "/WEB-INF/pages/newuser.jsp";
		else if(page.equals("register"))
			uri = "/WEB-INF/pages/register.jsp";
		else if(page.equals("candlist"))
			uri = "/WEB-INF/pages/candlist.jsp";
		else if(page.equals("result"))
			uri = "/WEB-INF/pages/newresult.jsp";
		else if(page.equals("vote"))
			uri = "/WEB-INF/pages/vote.jsp";
		else if(page.equals("editcand"))
			uri = "/WEB-INF/pages/editcand.jsp";
		else if(page.equals("updatedcand"))
			uri = "/WEB-INF/pages/updatedcand.jsp";
		else if(page.equals("delcand"))
			uri = "/WEB-INF/pages/delcand.jsp";
		
		ServletContext ctx = this.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher(uri);
		rd.forward(req, resp);
	}
}
