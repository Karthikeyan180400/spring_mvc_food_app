<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: white;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li:last-child {
	border-right: none;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: red;
	opacity: 0.8;
}

li a:hover:not(.factive) {
	background-color: red;
	opacity: 0.8;
}

li a:hover:not(.lactive) {
	background-color: red;
	opacity: 0.8;
}

li a:hover:not(.bctive) {
	background-color: red;
	opacity: 0.8;
}

.active {
	background-color: #111;
}

.factive {
	background-color: #111;
}

.lactive {
	background-color: #111;
}

.bactive {
	background-color: #111;
}
</style>
</head>
<body>

	<ul>
		<li><a class="factive" href="getuser">Profile</a></li>
		<li><a class="active" href="setitem">Book Order</a></li>
		<li><a class="active" href="getfoodorders">View Orders</a></li>
		<li class="lactive" style="float: right"><a href="loginuser">Logout</a></li>
	</ul>

</body>
</html>


