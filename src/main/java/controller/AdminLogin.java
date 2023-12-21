package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dto.BankAcc;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("cname");
		String email = req.getParameter("email");
		
		if(name.equals("admin") && email.equals("admin@gmail.com")) {
			res.getWriter().print("<h1>Admin login successfully</h1>");
			AdminDao adminDao= new AdminDao();
			
			// store all bank a/c detail into list
			List<BankAcc> list= adminDao.fetchAll();
			
			req.getSession().setAttribute("bankAcc", list);
			req.getRequestDispatcher("adminHome.jsp").include(req, res);
			
		}
		else {
			res.getWriter().print("<h1>invalid crediental</h1>");
		}
	}
}
