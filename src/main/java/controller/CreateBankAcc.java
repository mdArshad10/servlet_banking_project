package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dao.CustomerDao;
import dto.BankAcc;
import dto.Customer;

@WebServlet("/createBankAccount")
public class CreateBankAcc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String accountType = req.getParameter("accountType");
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		// 1. get the account detail from customer
		List<BankAcc> list = customer.getBankAccounts();

		// flag
		boolean flag = true;

		// 2. check the account is present or not
		for (BankAcc bankAcc : list) {
			if (bankAcc.getAccType().equals(accountType)) {
				flag = false;
				break;
			}
		}

		// 3. if flag is true then create account
		if (flag) {
			// create the bank details
			BankAcc bankAcc = new BankAcc();
			// we set only the account type because other values either automatically set or
			// set by admin(Bank manager)
			bankAcc.setAccType(accountType);

			// set the account limit based on account type
			if (accountType.equals("saving")) {
				bankAcc.setAccLimit(10000);
			} else {
				bankAcc.setAccLimit(15000);
			}
			
			// set the customer into bank
			bankAcc.setCustomer(customer);
			
			BankDao bankDao = new BankDao();

			// 5. update the data into customer table and add
			List<BankAcc> list2 = list;
			list2.add(bankAcc);
			customer.setBankAccounts(list2);

			// 4. save the data into bankAcc
			bankDao.save(bankAcc);

			CustomerDao customerDao = new CustomerDao();
			customerDao.update(customer);

			res.getWriter().printf("<h1>your account is created successfully and wait for manager panale</h1>");
			req.getRequestDispatcher("homePage.html").include(req, res);
			
		} else {
			res.getWriter().printf("<h1>Account is already present</h1>");
		}

	}

}
