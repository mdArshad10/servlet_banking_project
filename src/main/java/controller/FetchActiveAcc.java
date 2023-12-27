package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BankAcc;
import dto.Customer;

@WebServlet("/fetchActiveAcc")
public class FetchActiveAcc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		List<BankAcc> list = customer.getBankAccounts();

		List<BankAcc> list2 = new ArrayList();

		for (BankAcc bankAcc : list) {
			if (bankAcc.isStatus()) {
//				System.out.println("Status is active");
				list2.add(bankAcc);
			} else {
				System.out.println("Status is inactive");
			}
			
			req.getSession().setAttribute("list", list2);
			req.getRequestDispatcher("accounts.jsp").include(req, resp);
		}
	}
}
