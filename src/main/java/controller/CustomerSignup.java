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
public class CustomerSignup extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  String cusname = req.getParameter("cname");
		 String mobile =req.getParameter("mobile");
		 
//		 mobile number is in long data so convert the string to long by applying parsing concept
		 long mob = Long.parseLong(mobile);
		 
		 String password =req.getParameter("password");
		 String cus_email =req.getParameter("cus_email");
		 String gender =req.getParameter("gender");
		 String dob =req.getParameter("dob");
		 
//		 System.out.println("the customer name is "+ cusname);
//		 System.out.println("the mobile no. is "+ mob);
//		 System.out.println("the passowrd is "+ password);
//		 System.out.println("the customer email is "+ cus_email);
//		 System.out.println("the gender of customer is "+ gender);
//		 System.out.println("the date of birth is "+ dob);
//		 
//		 res.getWriter().print("<h1> "+ cusname + "</h1>"
//		 		+ "<h1> "+ mob + "</h1>"
//		 		+ "<h1> "+ password+ "</h1>"
//		 		+ "<h1> " + cus_email+ "</h1>"
//		 		+ "<h1> " + gender+ "</h1>"
//		 		+ "<h1> " + dob+ "</h1>");
		 
		 // converting the String datatype to date
		 Date date = Date.valueOf(dob);
//		 System.out.print("the date is "+date);
		 Period period =Period.between(date.toLocalDate(), LocalDate.now());
//		 System.out.println("the period is "+period);
		 int age = period.getYears();
//		 System.out.println("the age is "+age);
		 Customer customer = new Customer();
		 CustomerDao customerDao = new CustomerDao();
		 if(age>30) {
//			 res.getWriter().print("<h1>eligiblie</h1>");
			 customer.setCname(cusname);
			 customer.setEmail(cus_email);
			 customer.setPassword(password);
			 customer.setGender(gender);
			 customer.setDob(date);
			 customer.setMobile(mob);
			 
			 customerDao.save(customer);
			 res.getWriter().print("<h1>Account created successfully</h1");
		 }else {
			 res.getWriter().print("<h1>your are not eligible</h1>");
		 }
//		 res.getWriter().print("<h1> the date "+date+" " +" this is period "+ period+"</h1>");
	}
}
