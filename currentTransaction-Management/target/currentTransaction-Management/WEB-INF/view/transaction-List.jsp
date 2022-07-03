<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Transactions List</title>
</head>
<body>
<div>
</div>
	<div>
	<H1>Account Transactions List</H1>
		<table border="2">
			<thead>
				<tr>
					<td>Account Id</td>
					<td>Customer Id</td>
					<td>Customer Name</td>
					<td>Customer SurName</td>
					<td>Amount</td>
					<td>Balance</td>
				</tr>
			</thead>

			<c:forEach items="${lstAccountTransaction}" var="transaction">
				<tr>
					<td>${transaction.accountId}</td>
					<td>${transaction.customerId}</td>
					<td>${transaction.customerName}</td>
					<td>${transaction.customerSurName}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.balance}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>