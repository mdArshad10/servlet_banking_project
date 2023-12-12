package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;

@WebServlet("/customerSignup")
public class CustomerSignup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cusname = req.getParameter("cname");
		String mobile = req.getParameter("mobile");

//		 mobile number is in long data so convert the string to long by applying parsing concept
		long mob = Long.parseLong(mobile);

		String password = req.getParameter("password");
		String cus_email = req.getParameter("cus_email");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");

		// converting the String datatype to date
		Date date = Date.valueOf(dob); //

		Period period = Period.between(date.toLocalDate(), LocalDate.now()); //

		int age = period.getYears(); //

		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDao();
		// check the age valiadation
		if (age > 30) {
			// check the email or phone number validation
			if (customerDao.check(cus_email, mob).isEmpty()) {
				// created
				customer.setCname(cusname);
				customer.setEmail(cus_email);
				customer.setPassword(password);
				customer.setGender(gender);
				customer.setDob(date);
				customer.setMobile(mob);

				customerDao.save(customer);
				res.getWriter().print("<h1>Account created successfully</h1");

			} else {
				res.getWriter().print("<h1>Credientail are already exist</h1>");
			}
		} else {
			res.getWriter().print("<h1>your are not eligible</h1>");
		}
	}
}
