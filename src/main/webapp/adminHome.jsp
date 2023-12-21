<%@page import="dto.BankAcc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Home</title>
</head>
<body>
	<%
	List<BankAcc> bankAccList = (List<BankAcc>) request.getSession().getAttribute("bankAcc");
	%>

	<h1>welcome to Admin home page</h1>

	<table border="1">
		<tr>
			<th>Account Number</th>
			<th>Account Type</th>
			<th>Customer name</th>
			<th>Customer id</th>
			<th>Acccount Status</th>
			<th>Change status</th>
		</tr>
		
		<% for(BankAcc bankAcc: bankAccList) {%>
		<tr>
			<th><%= bankAcc.getAccNumber() %></th>
			<th><%= bankAcc.getAccType() %></th>
			<th><%= bankAcc.getCustomer().getCname() %></th>
			<th><%= bankAcc.getCustomer().getCid() %></th>
			<th> <%= bankAcc.isStatus() %> </th>
			<th><button> change </button> </th>
		</tr>	
		
	<%} %>
	</table>
</body>
</html>