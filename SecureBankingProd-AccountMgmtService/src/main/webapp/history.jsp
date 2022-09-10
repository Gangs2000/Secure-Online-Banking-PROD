<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOC TYPE html>
<html>
<head>
<title>TRANSACTION HISTORY..</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="overflow-y:scroll">
<div class="container-fluid">
	<div class="row">
		<jsp:include page="/datapages/titlebar.jsp"></jsp:include>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<jsp:include page="/datapages/navbar.jsp"></jsp:include>
		</div>
	<div class="col-sm-9" style="width:50%; font-size:10px; font-weight:bold; margin-left:10%; margin-top:3%">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr class="success" align="center">
					<th scope="col" colspan="4">Credit transaction history</th>
				</tr>
				<tr class="danger" align="center">
					<th scope="col">TRANSACTION ID</th>                                    
					<th scope="col">CREDIT ACCOUNT</th>
					<th scope="col">CREDIT AMOUNT</th>
					<th scope="col">TIME STAMP</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${credit}" var="credit">  <!-- In order to use this forEach we need import jstl dependencies --> 
					<tr class="info">              
						<td scope="row">${credit.id}</td>                      
						<td>${credit.creditAccount}</td>
					   	<td>Rs.${credit.creditAmount}</td>
						<td>${credit.stamp}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr class="success" align="center">
					<th scope="col" colspan="4">Debit transaction history</th>
				</tr>
				<tr class="danger" align="center">
					<th scope="col">TRANSACTION ID</th>                                    
					<th scope="col">DEBITED BY</th>
					<th scope="col">DEBITED AMOUNT</th>
					<th scope="col">TIME STAMP</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${debit}" var="debit">  <!-- In order to use this forEach we need import jstl dependencies --> 
					<tr class="info">              
						<td scope="row">${debit.id}</td>                      
						<td>${debit.debitAccount}</td>
					   	<td>Rs.${debit.debitAmount}</td>
						<td>${debit.stamp}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>