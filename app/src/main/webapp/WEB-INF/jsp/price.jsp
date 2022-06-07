<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Art gallery</title>
</head>

<body>
<label><a id="gallery" href="/art-gallery">Click here</a> to go back to all art pieces</label>
<br>
<div id="sales">
    <c:forEach items="${saleList}" var="entry">
        ------------------------------------------------------------------------
        <h5>Image: "src/test/java/A4/G2/model/artwork/testImage${entry.artPiece.title.split(" ")[1]}.png"</h5>
        <h5>Title: ${entry.artPiece.title}</h5>
        <h5>Sale type: ${entry.getSaleType()}</h5>
        <h5>Price: $${entry.price}</h5>
        ------------------------------------------------------------------------
    </c:forEach>
</div>

</body>

</html>