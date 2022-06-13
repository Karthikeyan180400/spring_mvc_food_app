<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

h3 {
	color: red;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.button1 {
	font-size: 1em;
	padding: 10px;
	color: white;
	border: 2px solid white;
	text-decoration: none;
	cursor: pointer;
	transition: all 0.3s ease-out;
	background: navy;
	text-align: center;
}

.button1:hover {
	background: #111;
}

button {
	background-color: navy;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	background-color: #111;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: navy;
}

.container1 {
	text-align: center;
}

.container {
	padding: 18px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
</style>
</head>
<body>

	<h2>Login Page</h2>

	<form action="validateuser" method="post">

		<div class="container">
			<h3>Email or Password is incorrect</h3>
			<h4>Please try again</h4>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Username" name="email" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>

		</div>
		<div class="container1">
			<h4 align="center">OR</h4>
			<a class="button1" href="createuser">&nbsp;&nbsp;&nbsp;&nbsp;Sing
				Up&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</div>
	</form>

</body>
</html>
