package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.DaoInterfaces.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;


@SuppressWarnings("serial")
@WebServlet("/delcand")
public class DeleteCandServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			@SuppressWarnings("unused")
			int count = candDao.deleteById(id);
			String msg = "Candidate deleted : " + count;
			req.setAttribute("message", msg);
//			RequestDispatcher rd = req.getRequestDispatcher("result");
			ServletContext ctx = this.getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/result");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
