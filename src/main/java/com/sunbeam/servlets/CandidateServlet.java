package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.DaoInterfaces.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@SuppressWarnings("serial")
public class CandidateServlet extends HttpServlet {
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
		try (CandidateDao candDao = new CandidateDaoImpl()){
			list = candDao.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate list</title>");
		out.println("</head>");
		out.println("<body>");
//		out.println("<h3>Online Voting</h3>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("AppTitle");
		out.printf("<h3>%s</h3>", appTitle);
		String userName = "";
		Cookie[] arr = req.getCookies();
		if(arr != null) {
			for (Cookie cookie : arr) {
				if(cookie.getName().equals("uname")) {
					userName = cookie.getValue();
					break;
				}
			}
		}
		out.printf("Hi, %s<hr/>",userName);
		ServletContext ctx = this.getServletContext();
		String msg = (String) ctx.getAttribute("announcement");
		if(msg != null)
			out.printf("Announcement : %s <br/><br/>\n", msg);
		out.println("<form method='post' action='vote'>");
		for (Candidate c : list) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s)<br/> \n",
					c.getId(),c.getName(),c.getParty());
		}
		out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

}


























