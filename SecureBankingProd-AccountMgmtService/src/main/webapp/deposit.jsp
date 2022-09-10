<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>DEPOSIT..</title>
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
			<div class="col-sm-9" style="width:50%; font-size:12px; font-weight:bold; margin-left:10%; margin-top:3%">
				<div class="panel panel-primary">
    				<div class="panel-heading">DEPOSITOR BOX</div>
    					<div class="panel-body">
							<form action="/deposit-request" method="post">
								<label class="col-sm-5">DEPOSITOR ACCOUNT NO : </label>
								<input type="text" class="col-sm-7 input-sm" maxlength="8" name="depositTo"  placeholder="Enter depositor account no (645XXXXX)" autocomplete="off" required><br><br>
								<label class="col-sm-5">DEPOSIT AMOUNT : </label>
								<input type="number" class="col-sm-7 input-sm" min="1000" name="depositAmount"  placeholder="Enter depositor amount" autocomplete="off" required><br><br>
								<label class="col-sm-5">PASSWORD : </label>
								<input type="password" maxlength="5" class="col-sm-7 input-sm" name="password"  placeholder="XXXXX" autocomplete="off" required>
								<br><br><br>
								<center>
									<button type="submit" class="btn btn-primary" style="font-size:12px;">DEPOSIT AMOUNT</button>
								</center>
							</form>
						</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>