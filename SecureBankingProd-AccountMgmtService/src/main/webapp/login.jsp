<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>SECURE APP LOGIN</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>	
	<div class="container">
		<div class="row">
			<p style="padding:15px 20px; background-color:black; text-align:center; font-weight:bold; color:white;">SECURE BANKING PROD</p>
		</div><br>
		<div class="row">
			<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="panel panel-primary">
    					<div class="panel-heading">LOGIN PAGE</div>
    						<div class="panel-body">
								<form action="/login" method="post">
									<label class="col-sm-5">ACCOUNT NO : </label>
									<input type="text" maxlength="8" class="col-sm-7 input-sm" name="username" placeholder="Enter your account no (645XXXX..)" autocomplete="off" required><br><br>
									<label class="col-sm-5">PASSWORD : </label>
									<input type="password" maxlength="5" class="col-sm-7 input-sm" name="password"  placeholder="XXXXX" autocomplete="off" required>
									<br><br><br>
									<center>
										<button type="submit" class="btn btn-primary">LOGIN</button>
										<a href="/accountcreation" class="btn btn-danger">CREATE ACCOUNT</a>
										<a href="/forgotpin" class="btn btn-warning">FORGOT PIN</a>
									</center>
								</form>
							</div>
					</div>
					<br>
					<center><b>${SPRING_SECURITY_LAST_EXCEPTION.message}</b></center>
				</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>