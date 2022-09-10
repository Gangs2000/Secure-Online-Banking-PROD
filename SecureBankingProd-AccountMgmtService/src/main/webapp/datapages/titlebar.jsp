<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOC TYPE html>
<html>
<head>
<title>TITLE BAR</title>
<style>
body
{
	margin:0;
	overflow:hidden;
}
.bar
{
	width:96%;
	padding:20px 35px;
	font-weight:bold;
	background-color:black;
	color:white;
	text-align:center;
	font-size:15px;
}
.button
{
	padding:5px 15px;
	float:right;
	font-weight:bold;
	background-color:blue;
	font-size:15px;
}
.para
{
	float:left;
}
</style>
</head>
<body>
	<div class="bar">
		Online Secure Banking PROD
		<button class="button"><a href="/logout" style="text-decoration:none; color:white;">LOGOUT</a></button>
		<span class="para">Account no : <%=session.getAttribute("accountNo") %></span>
	</div>
</body>
</html>