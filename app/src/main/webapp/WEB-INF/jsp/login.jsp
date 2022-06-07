<html>

<head>
	<title>G2-Gallery</title>
</head>

<body>
	<h1>Login</h1>
	<label><a id="home" href="/">Click here</a> to go back to home</label>
	<h2>Insert username and password</h2>
	<h3 id="error" style="color: red;">${errorMessage}</h3>
	<form method="post">
		Name : <input type="text" name="name" id="name" />
		<br><br>
		Password : <input type="password" name="password" id="password"/>
		<br><br>
		<input type="submit" id="submitbtn" />
	</form>
</body>

</html>