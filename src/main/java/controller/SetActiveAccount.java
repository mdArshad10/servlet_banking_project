package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setActiveAccount")
public class SetActiveAccount extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc_num = req.getParameter("accNo");
		Long accNum = Long.parseLong(acc_num);
		
		req.getSession().setAttribute("accNum", accNum);
		req.getRequestDispatcher("accountHome.html").include(req, resp);
	}
}
