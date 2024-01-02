package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAcc;
import dto.BankTranscation;

@WebServlet("/depositeAmount")
public class DepositeAmount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long accNum = (Long) req.getSession().getAttribute("accNum");
		String amt = req.getParameter("amount");
		double amount = Double.parseDouble(amt);
		BankDao bankDao = new BankDao();
		BankAcc bankAcc = bankDao.fetchBankDetail(accNum);
		bankAcc.setAmount(amount + bankAcc.getAmount());

		BankTranscation bankTranscation = new BankTranscation();
		bankTranscation.setDeposite(amount);
		bankTranscation.setWithdraw(0);
		bankTranscation.setBalance(bankAcc.getAmount());
		bankTranscation.setDateTime(LocalDateTime.now());

		List<BankTranscation> list =bankAcc.getList();
		list.add(bankTranscation);
		bankAcc.setList(list);
		
		bankDao.updateAccountDetail(bankAcc);
		resp.getWriter().print("<h1>amount deposite successfully</h1>");
	}
}
