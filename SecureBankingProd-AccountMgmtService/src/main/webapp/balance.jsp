<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>AVAILABLE BALANCE..</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
			<div class="col-sm-6">
				<div class="panel panel-primary" style="witdh:70%; margin-top:10%; font-size:13px; margin-left:45%;">
    				<div class="panel-heading"><b>AVAILABLE BALANCE</b></div>
    					<div class="panel-body">
							<b>Available balance in your account is Rs.${balance.balance}</b>
						</div>
					</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
	
</body>
</html>