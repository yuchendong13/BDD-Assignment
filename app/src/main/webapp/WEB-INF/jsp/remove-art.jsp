<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Remove Art</title>
</head>

<body>
<h1>Remove Art</h1>

Art currently displayed in the gallery : <br/>
<c:forEach items="${list}" var="entry">
    ID: ${entry.id} <br/>
    Title: ${entry.title} <br/>
</c:forEach>

<h2>Enter the ID of the art you wish to delete</h2>
<form method="post">
    ID: <input type="text", name="idToRemove" id="idToRemove">
    <input type="submit"  id="submitItToBeRemove">
</form>

<label><a id="backToGallery" href="/art-gallery">Click here</a> to return to the art gallery.</label>

<label style="color:green" id="message">${message}</label>
<label style="color:red" id="errorMessage">${errorMessage}</label>


</body>

</html>