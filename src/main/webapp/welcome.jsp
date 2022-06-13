<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iFly</title>
<style>



.button {
	font-size: 1em;
	padding: 10px;
	color: white;
	border: 2px solid white;
	text-decoration: none;
	cursor: pointer;
	transition: all 0.3s ease-out;
	background: navy;
}

.box {
	width: 40%;
	margin: 0 auto;
	background: white;
	padding: 35px;
	text-align: center;
}


.button:hover {
	background: #111;
}


.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body style="background-color:white; font-family: Arial, Helvetica, sans-serif;">
 
 <h1 style="color: navy;text-align:center;">Welcome To <b>iFly</b></h1>
 <div class="box">
		<a class="button" href="login.jsp">&nbsp;&nbsp;&nbsp;&nbsp;Sign In&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
	    <a class="button" href="popup.jsp">&nbsp;&nbsp;&nbsp;&nbsp;Sing Up&nbsp;&nbsp;&nbsp;&nbsp;</a>
		
 </div>
</body>
</html>