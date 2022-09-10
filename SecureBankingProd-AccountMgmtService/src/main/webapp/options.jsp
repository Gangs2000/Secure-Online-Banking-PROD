<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>SECURE Banking</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/datapages/titlebar.jsp"></jsp:include>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<jsp:include page="/datapages/navbar.jsp"></jsp:include>
			</div>
			<div class="col-sm-9" style="width:50%; font-size:13px; font-weight:bold; margin-left:10%; margin-top:3%">
				<table class="table table-striped table-bordered table-hover">
					<thead class="bg-warning">
						<tr>
							<td colspan="2" align="center">ACCOUNT INFORMATION</td>
						</tr>
					</thead>
					<tbody>
						<tr class="info">
							<td scope="row">ACCOUNT NUMBER</td>
							<td>${data.accountNo}</td>
						</tr>
						<tr class="info">
							<td scope="row">HOLDER NAME</td>
							<td>${data.userName}</td>
						</tr>
						<tr class="info">
                        	<td scope="row">EMAIL ID</td>
                        	<td>${data.emailId}</td>
                        </tr>
						<tr class="info">
							<td scope="row">AVAILABLE BALANCE</td>
							<td>Rs.${data.balance}</td>
						</tr>
						<tr class="info">
							<td scope="row">MOBILE NUMBER</td>
							<td>${data.mobile}</td>
						</tr>
						<tr class="info">
							<td scope="row">DOB</td>
							<td>${data.dob}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>