package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")

@SuppressWarnings("serial")
public class firstServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		System.out.println("First servlet init() called");
	}
	
	@Override
	public void destroy() {
		System.out.println("First servlet destroy() called");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("First servlet doGet() called");
		processRequest(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("First servlet doPost() called");
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello from FirstServlet</h1>");
		Date now = new Date();
		out.println(now.toString());
		out.println("</body>");
		out.println("</html>");
	}
	
	

	

}
