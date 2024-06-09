package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.DaoInterfaces.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@SuppressWarnings("serial")
public class ResultServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<Candidate>();
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Results</title>");
		out.println("</head>");
		out.println("<body>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("AppTitle");
		out.printf("<h3>%s</h3>", appTitle);
		out.println("<table border='2'>");
		out.println("<thead>");
		out.println("<th>ID</th>");
		out.println("<th>NAME</th>");
		out.println("<th>PARTY</th>");
		out.println("<th>VOTES</th>");
		out.println("<th>ACTION</th>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Candidate c : list) {
			out.println("<tr>");
			out.printf("<td>%d</td>",c.getId());
			out.printf("<td>%s</td>",c.getName());
			out.printf("<td>%s</td>",c.getParty());
			out.printf("<td>%d</td>",c.getVotes());
			out.printf("<td><a href='delcand?id=%d'><img width='20' height='20' src='images/delete.png'/></a></td>\n",c.getId());
			out.printf("<td><a href='editcand?id=%d'><img width='20' height='20' src='images/edit.png'/></a></td>\n",c.getId());
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		String msg = (String) req.getAttribute("message");
		if(msg != null)
			out.println("<br/><br/>" + msg + "<br/><br/>");
		out.println("<br/><a href='announcement.html'>Announce</a>");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}























