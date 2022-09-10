<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>CREATE ACCOUNT</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<p style="padding:15px 20px; background-color:black; text-align:center; font-weight:bold; color:white;">CREATE YOUR ACCOUNT</p>
		</div>
		<br><br>
		<div class="row">
			<form action="/createaccount" method="post">
				<label class="col-sm-4">ACCOUNT HOLDER NAME : </label>
				<input type="text" class="col-sm-8 input-sm" name="userName" placeholder="Enter your name" autocomplete="off" required><br><br>
				<label class="col-sm-4">EMAIL ID : </label>
                <input type="email" class="col-sm-8 input-sm" name="emailId" placeholder="example@gmail.com" autocomplete="off" required><br><br>
				<label class="col-sm-4">INITIAL BALANCE ACCOUNT : </label>
				<input type="number" min="100" class="col-sm-8 input-sm" name="balance" placeholder="Enter initial balance amount" autocomplete="off"  required><br><br>
				<label class="col-sm-4">DOB : </label>
				<input type="date" class="col-sm-8 input-sm" name="dob" required><br><br>
				<label class="col-sm-4" >MOBILE NUMBER : </label>
				<input type="tel" class="col-sm-8 input-sm" maxlength="10"  name="mobile" placeholder="Enter your mobile number" autocomplete="off"  required><br><br>
				<label class="col-sm-4">PIN : </label>
				<input type="password" maxlength="5" class="col-sm-8 input-sm" name="password" placeholder="XXXXX" autocomplete="off"  required><br><br>
				<label class="col-sm-4">SECURITY QUESTION : </label>
				<select class="col-sm-8 input-sm" name="securityQuestion" required>
					<option>What is favorite color?</option>
					<option>Where were you born?</option>
					<option>What is your favorite vacation spot?</option>
					<option>What is your siblings name?</option>
					<option>What is your favorite sport?</option>
				</select><br><br>
				<label class="col-sm-4">ANSWER : </label>
				<input type="text" class="col-sm-8 input-sm" name="securityAnswer"  placeholder="Enter your security question answer" autocomplete="off" required><br><br>
				<input type="submit" class="btn btn-primary" value="CREATE ACCOUNT">
				<a href="/login" class="btn btn-primary">Back to Login</a>
			</form>
		</div>
	</div>
</body>
</html>