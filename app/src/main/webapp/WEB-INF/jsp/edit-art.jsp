<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Art</title>
</head>
<body>
<p>ID: ${param.ID}</p>

<form method="post">
    <h2>Edit basic art details </h2>
    Title: <input type="text" name="editTitle" id="editTitle" value="${editTitle}"/> <br/>
    Description: <input type="text" name="editDescription" id="editDescription" value="${editDescription}"/> <br/>
    Dimensions: <input type="text" name="editDimensions" id="editDimensions" value="${editDimensions}"/> <br/>


    <input type="submit" id="editSubmit"/> <br/>
</form>


<p id="message" style="color: green">${message}</p>
<p id="errorMessage" style="color: red">${errorMessage}</p>
<label><a id="artDetailButton" href="/art-details">Click here</a> to go back to art details</label>
</body>


</html>