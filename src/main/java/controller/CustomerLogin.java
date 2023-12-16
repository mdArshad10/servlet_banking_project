package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;

@WebServlet("/customerLogin")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String cid = req.getParameter("cid");
		String password = req.getParameter("password");
		
		// each and every primative datatype have it own class that class is called
		// wrapper class
		
		int cusId = Integer.parseInt(cid);

		CustomerDao customerDao = new CustomerDao();

		// fetch the customer form database for check the credientals
		Customer customer = customerDao.login(cusId);

		// if customer not exist
		if (customer == null) {
			res.getWriter().print("<h1> invalid customer id </h1>");
		} else {
			// check the password is right or not
			if (customer.getPassword().equals(password)) {
				res.getWriter().print("<h1>login successfully</h1>");

			} else {
				// if customer id wrong
				res.getWriter().print("<h1> invalid customer password</h1>");
				req.getRequestDispatcher("homePage.html").include(req, res);
			}
		}
	}
}
