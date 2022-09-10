<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>WITHDRAW..</title>
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
			<div class="col-sm-6" style="width:50%; font-size:13px; font-weight:bold; margin-left:10%; margin-top:3%">
				<div class="panel panel-primary">
    				<div class="panel-heading">WITHDRAWL BOX</div>
    					<div class="panel-body">
							<form action="/withdraw-request" method="post">
								<label class="col-sm-4">AMOUNT : </label>
								<input type="number" class="col-sm-8 input-sm" min="500" name="withdrawamount"  placeholder="Enter withdrawl amount" autocomplete="off" required><br><br>
								<label class="col-sm-4">PASSWORD : </label>
								<input type="password" maxlength="5" class="col-sm-8 input-sm" name="password"  placeholder="XXXXX" autocomplete="off" required>
								<br><br><br>
								<center>
									<button type="submit" class="btn btn-primary" style="font-size:13px;">WITHDRAW AMOUNT</button>
								</center>
							</form>
						</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>