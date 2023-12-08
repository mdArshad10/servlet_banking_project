package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 
		 res.getWriter().print("<h1> "+ cusname + "</h1>"
		 		+ "<h1> "+ mob + "</h1>"
		 		+ "<h1> "+ password+ "</h1>"
		 		+ "<h1> " + cus_email+ "</h1>"
		 		+ "<h1> " + gender+ "</h1>"
		 		+ "<h1> " + dob+ "</h1>");
	}
}
