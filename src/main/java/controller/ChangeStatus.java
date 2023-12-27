package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.BankDao;
import dto.BankAcc;

@WebServlet("/changeStatus")
public class ChangeStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get a/c Number from frontend
		String accNo = req.getParameter("accNo");
		
		// convert string(a/c number) into long using the pasre
		long accNumber = Long.parseLong(accNo);
		
		// fetch the a/c detail from a/c number
		BankDao bankDao = new BankDao();
		BankAcc bankAcc = bankDao.fetchBankDetail(accNumber);
		
		// check the status
		if(bankAcc.isStatus()) {
			bankAcc.setStatus(false);
		}else {
			bankAcc.setStatus(true);
		}
//		
		bankDao.updateAccountDetail(bankAcc);
//		
		AdminDao adminDao = new AdminDao();
		List<BankAcc> accountInformation = adminDao.fetchAll();
		
		req.getSession().setAttribute("bankAcc", accountInformation);
		req.getRequestDispatcher("adminHome.jsp").include(req, res);
		
	}
}
