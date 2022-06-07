<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Art gallery</title>
</head>

<body>
<label><a id="gallery" href="/art-gallery">Click here</a> to go back to all art pieces</label>
<br>
<h1>Art gallery - ${saleType} items</h1>
<c:choose>
    <c:when test="${saleType.equals('Buy now')}">
        <form method="post" action="sale-type/price">
            <i>Sort by price range: </i><br><br>
            Min price [Default = 0] : <input type="text" name="min" id="min"/>
            <br><br>
            Max price [Default = 1,000] : <input type="text" name="max" id="max"/>
            <br><br>
        <input type="submit" id="submitPriceBtn" />
        </form>
    </c:when>
    <c:otherwise>
        <form method="post" action="sale-type/time">
            <i>Sort by time remaining: </i><br><br>
            <input type="radio" name="timeTypeOption" id="higher" value="Higher" checked="checked">Higher than
            <input type="radio" name="timeTypeOption" id="lower" value="Lower">Lower than
            <br><br>
            Hours [Default = 24] : <input type="text" name="hour" id="hour"/>
            <br><br>
            Minutes [Default = 0] : <input type="text" name="minute" id="minute"/>
            <br><br>
            <input type="submit" id="submitTimeBtn" />
        </form>
    </c:otherwise>
</c:choose>



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