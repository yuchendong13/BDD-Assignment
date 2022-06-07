<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Art gallery</title>
</head>

<body>
<label><a id="gallery" href="/art-gallery">Click here</a> to go back to all art pieces</label>
<br>
<h1>Art gallery - ${artType} items</h1>
<div id="arts">
    <c:forEach items="${artList}" var="entry">
        ------------------------------------------------------------------------
        <h5>Image: "src/test/java/A4/G2/model/artwork/testImage${entry.title.split(" ")[1]}.png"</h5>
        <h5>Title: ${entry.title}</h5>
        <h5>Art type: ${entry.getArtType()}</h5>
        ------------------------------------------------------------------------
    </c:forEach>
</div>

</body>

</html>