<html>

<head>
    <title>G2-Gallery</title>
</head>

<body>
    <h1>Signup</h1>
    <label><a id="home" href="/">Click here</a> to go back to home</label>
    <h2>Insert details for your account</h2>
    <h3 id="error" style="color: red;">${errorMessage}</h3>
    <form method="post">
        Enter Username : <input type="text" name="name" id="name"/>
        <br><br>
        <i>Password must contain a digit, a capital letter and at least 6 chars</i>
        <br><br>
        Enter Password : <input type="text" name="password" id="password"/>
        <br><br>
        Retype Password : <input type="text" name="retypedPassword" id="retypedPassword"/>
        <br><br>
        <u>Terms & Conditions:</u>
        <input type="checkbox" name="checkbox"/>
        <p>
            ${termsAndConditions}
        </p>
        <input type="submit" id="submitbtn"/>
    </form>
</body>

</html>