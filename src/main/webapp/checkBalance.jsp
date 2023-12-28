<%@page import="dao.BankDao"%>
<%@page import="dto.BankAcc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Long accNum = (Long) request.getSession().getAttribute("accNum");
	
	// get bankDao
	BankDao bankDao = new BankDao();
	// get all a/c detail using a/c number
	BankAcc bankAcc = bankDao.fetchBankDetail(accNum);

	%>
	<h1>welcome to the balance page</h1>
	<h2>your account have the <%= bankAcc.getAmount() %></h2>
</body>
</html>