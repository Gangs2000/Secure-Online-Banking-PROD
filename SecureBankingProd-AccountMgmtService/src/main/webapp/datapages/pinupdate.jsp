<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>PIN UPDATED</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="overflow:hidden;">
	<jsp:include page="/forgotpin.jsp"></jsp:include>
	<br><br>
	<div class="row" style="width:80%; margin-left:10%">
		<table class="table table-striped table-hover" align="center">
			<thead>
			<tr>
				<th scope="col">ACCOUNT NUMBER</th>
				<th scope="col">HOLDER NAME</th>
				<th scope="col">NEW PIN</th>
				<th scope="col">ACTION</th>
			</tr>
			</thead>
			<tbody>
			<tr class="info">
				<td scope="row">${updated.accountNo}</td>
				<td>${updated.userName}</td>
				<td>${updated.password}</td>
				<td><a href="/" class="btn btn-primary">LOGIN</a></td>
			</tr>
			</tbody>
		</table>
	</div>
</body>
</html>