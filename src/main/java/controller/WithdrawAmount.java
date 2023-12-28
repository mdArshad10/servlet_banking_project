package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAcc;

@WebServlet("/withdrawAmount")
public class WithdrawAmount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get a/c number from session
		Long accNum = (Long) req.getSession().getAttribute("accNum");
		// get amt from frontend
		String amt = req.getParameter("amount");
		// convert amt into long data type by using parsing
		double amount = Double.parseDouble(amt);

		// get bankDao
		BankDao bankDao = new BankDao();
		// get all a/c detail using a/c number
		BankAcc bankAcc = bankDao.fetchBankDetail(accNum);

		// check the amount is suffient
		if (bankAcc.getAmount() < amount) {
			
			resp.getWriter().print("<h1>insuffient amount present in amount</h1>");
			req.getRequestDispatcher("accountHome.html").include(req, resp);
		} else {
			if (bankAcc.getAccLimit() < amount) {
				resp.getWriter().print("<h1>you are limited exceeding</h1>");
				req.getRequestDispatcher("accountHome.html").include(req, resp);
			} else {
				
				bankAcc.setAmount(bankAcc.getAmount() - amount);

				bankDao.updateAccountDetail(bankAcc);
				resp.getWriter().print("<h1>amount deposite successfully</h1>");
				req.getRequestDispatcher("accountHome.html").include(req, resp);
			}
		}
	}
}
