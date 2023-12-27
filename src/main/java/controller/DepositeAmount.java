package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAcc;

@WebServlet("/depositeAmount")
public class DepositeAmount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long accNum =(Long) req.getSession().getAttribute("accNum");
		String amt = req.getParameter("amount");
		double amount = Double.parseDouble(amt);
		BankDao bankDao=new BankDao();
	 BankAcc bankAcc = bankDao.fetchBankDetail(accNum);
	 bankAcc.setAmount(amount + bankAcc.getAmount());
	 
	 bankDao.updateAccountDetail(bankAcc);
	 resp.getWriter().print("<h1>amount deposite successfully</h1>");
	}
}
