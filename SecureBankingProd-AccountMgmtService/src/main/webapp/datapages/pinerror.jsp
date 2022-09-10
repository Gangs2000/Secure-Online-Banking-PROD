<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>PIN CHANGE ERROR</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="overflow:hidden">
	<jsp:include page="/forgotpin.jsp"></jsp:include>
	<br><br>
	<div class="row" align="center">
		<div style="width:30%; overflow-x:hidden; padding:10px 15px;" class="text-center bg-primary text-white">${error}</div>
	</div>
</body>
</html>