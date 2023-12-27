<%@page import="dto.BankAcc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Active Account</title>
</head>
<body>
	<h1>Welcome to active account type</h1>
	<% List<BankAcc> list  = (List<BankAcc>) request.getSession().getAttribute("list"); %>
	
	<% if(list.isEmpty()) {%>
	
	<%} else {%>
		<h1>select bank account </h1>
		<% for(BankAcc bankAcc:list) {%>
			<%--  --%>
			<a href="setActiveAccount?accNo=<%= bankAcc.getAccNumber()%> "><button> <%= bankAcc.getAccNumber() %> </button></a>
		<%} %>
	<%} %>
</body>
</html>