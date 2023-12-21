<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banking Account | Home</title>
</head>
<body>
    <h1>welcome to Banking Account</h1>
    
	<% Customer customer = (Customer) request.getSession().getAttribute("customer"); %>
	<h1>hello dear : <%= customer.getCname() %></h1>
	
    <form action="createBankAccount">
        <input type="radio" name="accountType" id=""  value="saving" required="required"> Saving Account
        <br><br>
        <input type="radio" name="accountType" id=""  value="current" required="required"> Current Account 
        <br><br>
        <button type="submit">Submit</button>
        <button type="reset">Cancle</button>
    </form>
</body>
</html>