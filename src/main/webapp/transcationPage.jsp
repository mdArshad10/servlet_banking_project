<%@page import="java.util.List"%>
<%@page import="dto.BankTranscation"%>
<%@page import="dto.BankAcc"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>History of Transcation</h1>

	<%
	long accNum = (long) request.getSession().getAttribute("accNum");

	BankDao bankDao = new BankDao();
	BankAcc bankAcc = bankDao.fetchBankDetail(accNum);
	List<BankTranscation> list = bankAcc.getList();
	%>

	<table border="1">
		<tr>
			<th>Tid</th>
			<th>Deposite</th>
			<th>withdraw</th>
			<th>balance</th>
			<th>Date Time</th>
		</tr>

		<%
		for (BankTranscation bankTranscation : list) {
		%>
		<tr>
			<th><%=bankTranscation.getTid()%></th>
			<th><%=bankTranscation.getDeposite()%></th>
			<th><%=bankTranscation.getWithdraw()%></th>
			<th><%=bankTranscation.getBalance()%></th>
			<th><%=bankTranscation.getDateTime()%></th>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>