<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>NAVBAR</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
.navbar-brand:hover
{
	background-color:black;
	color:gold;
}
</style>
</head>
<body>
<div class="container-fluid">
	<nav class="navbar bg-dark navbar-dark" style="margin-top:7%;">
    	<ul class="navbar-nav">
    		<p style="padding:10px 15px; color:black; background-color:gold; font-weight:bold; text-align:center; font-size:15px;">ACTIONS</p>
      		<li class="nav-item">
        		<a class="navbar-brand" href="/withdraw"><b>Withdraw amount</b></a>
      		</li>
      		<li class="nav-item">
        		<a class="navbar-brand" href="/deposit"><b>Deposit amount</b></a>
      		</li>
      		<li class="nav-item">
        		<a class="navbar-brand" href="/checkbalance"><b>Check Balance</b></a>
      		</li>
      		<li class="nav-item">
        		<a class="navbar-brand" href="/forgotpin"><b>Change PIN</b></a>
      		</li>
      		<li class="nav-item">
        		<a class="navbar-brand" href="/gethistory"><b>Get Transaction history</b></a>
      		</li>
    	</ul>
	</nav>
</div>
</body>
</html>