<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>SECURE APP PIN CHANGE</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<p style="padding:15px 20px; background-color:black; text-align:center; font-weight:bold; color:white;">SECURITY PIN CHANGE</p>
		</div>
		<br><br>
		<div class="row">
		<div class="col-sm-3"></div>
			<div class="col-sm-7">
			<form action="/pinchange" method="post">
				<label class="col-sm-5">ENTER ACCOUNT NO : </label>
				<input type="text" maxlength="8" class="col-sm-7" name="accountNo" placeholder="Enter your account number (645XXXXX)" autocomplete="off" required><br><br>
				<label class="col-sm-5">SECURITY QUESTION : </label>
				<select class="col-sm-7 input-sm" name="securityQuestion" required>
					<option>What is favorite color?</option>
					<option>Where were you born?</option>
					<option>What is your favorite vacation spot?</option>
					<option>What is your siblings name?</option>
					<option>What is your favorite sport?</option>
				</select><br><br>
				<label class="col-sm-5">ANSWER : </label>
				<input type="text" class="col-sm-7" name="securityAnswer"  placeholder="Enter your security question answer" autocomplete="off" required><br><br>
				<label class="col-sm-5">ENTER NEW PIN : </label>
				<input type="password" maxlength="5" class="col-sm-7" name="password" placeholder="XXXXX" autocomplete="off" required><br><br>
				<button type="submit" class="btn btn-primary">CHANGE PIN</button>&nbsp;
				<a href="/" class="btn btn-primary">Back to Login</a>
			</form>
			</div>
		<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>